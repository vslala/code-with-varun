import com.codewithvarun.Contest;
import com.codewithvarun.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.codewithvarun.LambdaExceptionConsumer.wrapEx;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContestTest {

    private Participants participants = Participants.newInstance();
    private Contest contest;

    @BeforeEach
    public void setup() {
        contest = new Contest("round1", participants);
    }

    @Test
    public void itShouldTakeParticipantsAndRunTheCompetitionNTimes() {
        contest.run();
        participants.get().forEach(participant -> {
            assertNotEquals(0, participant.skill());
            assertNotEquals(0, participant.luck());
        });
    }

    @Test
    public void itShouldShortListTheTop10CandidatesOnTheBasisOfTheirSkillsAndLuck() {
        File results = contest.run();
        assertTrue(results.exists());
    }

    @Test
    public void itShouldGenerateGooglePieChartForLuckyAndSkillfulPeopleWhoWonTheContest() throws IOException {
        Map<String, Integer> stats = new HashMap<>();
        try (Stream<Path> paths = Files.walk(Paths.get("src/main/resources"))) {
            paths.filter(path -> path.toFile().isFile())
                    .forEach(wrapEx(path -> {
                        Files.readAllLines(path).forEach(line -> {
                            String luckyOrSkillful = line.trim().split(",")[2].trim();
                            if (stats.containsKey(luckyOrSkillful)) {
                                stats.put(luckyOrSkillful, stats.get(luckyOrSkillful) + 1);
                            } else {
                                stats.put(luckyOrSkillful, 1);
                            }
                        });
                    }));
        }

        System.out.println("LUCKY: " + stats.get("LUCKY"));
        System.out.println("SKILLFUL: " + stats.get("SKILLFUL"));
    }

    @Test
    public void itShouldRunContest1000Times() {
        IntStream.range(1, 1001).forEach(round -> {
            var contest = new Contest("round_" + round, Participants.newInstance());
            contest.run();
        });
    }
}