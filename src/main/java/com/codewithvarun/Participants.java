package com.codewithvarun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Participants {
    private List<Participant> participants;

    {
        this.participants = IntStream.iterate(0, operand -> operand + 1)
                .limit(1811)
                .mapToObj(value ->
                        Participant.newInstance()
                                .skill(new Random().nextInt(99) + 1))
                .collect(toList());
    }

    public static Participants newInstance() {
        return new Participants();
    }

    public List<Participant> get() {
        return participants;
    }

    public List<Participant> getAllAboveCutOff(int cutOff) {
        participants.sort(Comparator.comparingInt(Participant::successFactor).reversed());
        int cutOffSuccessFactor = participants.get(cutOff).successFactor();
        return participants.stream().filter(participant -> participant.successFactor() >= cutOffSuccessFactor).collect(toList());
    }

    public Participant get(Integer participantIndex) {
        return participants.get(participantIndex);
    }
}
