package com.bma.snakeladder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class ScoreCard {

    private User tossWinner;
    private List<DiceRoll> diceRolls;
    private User gameWinner;
    public void addDiceRoll(DiceRoll diceRoll) {
        if (Objects.isNull(diceRolls))
            diceRolls = new ArrayList<>();

        diceRolls.add(diceRoll);
    }
}
