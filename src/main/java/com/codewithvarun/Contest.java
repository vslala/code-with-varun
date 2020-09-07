package com.codewithvarun;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public class Contest {

    private final Participants participants;
    private final String name;

    public Contest(String name, Participants participants) {
        this.name = name;
        this.participants = participants;
    }

    public File run() {
        judgeParticipants();
        HashSet<Integer> winners = selectWinners();
        return generateReport(winners);
    }

    private File generateReport(HashSet<Integer> winners) {
        Path roundResult = Paths.get(format("src/main/resources/%s.dat", name));

        try(BufferedWriter br = new BufferedWriter(new FileWriter(roundResult.toFile()))) {
            if (roundResult.toFile().exists()) {
                Files.writeString(roundResult, "");

                for (int winner : winners) {
                    Participant participant = participants.get(winner);
                    br.append(participant.toString());
                    br.newLine();
                }
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

        return roundResult.toFile();
    }

    private HashSet<Integer> selectWinners() {
        List<Participant> finalists = participants.getAllAboveCutOff(11);
        Random random = new Random();
        HashSet<Integer> selectedParticipants = new HashSet<>();
        while (selectedParticipants.size() <= 11) {
            int selectedParticipant = random.nextInt(finalists.size());
            if (!selectedParticipants.contains(selectedParticipant))
                selectedParticipants.add(selectedParticipant);
        }
        return selectedParticipants;
    }

    private void judgeParticipants() {
        Random rand = new Random();
        participants.get().forEach(participant -> {
            int luckPercent = rand.nextInt(99) + 1;
            participant.luck(luckPercent);
        });
    }
}
