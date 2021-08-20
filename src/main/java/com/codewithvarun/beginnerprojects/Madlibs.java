package com.codewithvarun.beginnerprojects;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;
import static java.util.regex.Pattern.MULTILINE;
import static java.util.regex.Pattern.compile;

@Slf4j
@AllArgsConstructor
public class Madlibs {

    private static final String REGEX = "<([a-zA-Z0-9\\s+]+)>";
    private final Pattern pattern = compile(REGEX, MULTILINE);
    private final Scanner scan = new Scanner(System.in);

    private final Path storyPath;

    public String generateStory() throws IOException {
        return readAllLines(storyPath)
                .stream()
                .map(this::generateStoryLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateStoryLine(String line) {
        var matcher = pattern.matcher(line);
        while (matcher.find()) {
            var placeholder = matcher.group();
            var promptText = matcher.group(1);

            log.info("{}: ", promptText);
            var input = scan.nextLine();

            line = line.replaceFirst(placeholder, input);
        }

        return line;
    }

    public static void main(String[] args) throws IOException {
        log.info(new Madlibs(Path.of("src/main/resources/madlibs/story.txt")).generateStory());
    }
}
