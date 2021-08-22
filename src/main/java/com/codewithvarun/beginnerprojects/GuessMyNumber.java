package com.codewithvarun.beginnerprojects;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Scanner;

@Slf4j
@AllArgsConstructor
public class GuessMyNumber {

    private final int bound;
    private final Random random = new Random();
    private final Scanner scanner;

    public void play() {
        var randomNumber = random.nextInt(bound);
        var userInput = 0;
        while (randomNumber != userInput) {
            log.info("What's your guess?");
            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput < randomNumber) log.info("Try a bigger number!");

            if (userInput > randomNumber) log.info("Try a lower number!");
        }

        log.info("Yay! you guess the number. The number was {}", userInput);
    }

    public void playWithComputer(int selectedNumber) {
        var lower = 1;
        var upper = 100;

        // computer selects a random number to start with
        var computerChoice = random.nextInt(upper);

        while (computerChoice != selectedNumber) {
            // computer asks for validation
            log.info("Is this your number: {}, (L=Lower, H=Higher)", computerChoice);

            // take feedback from user ('L' = Lower, 'H' = Higher)
            var userInput = scanner.nextLine();

            // set the bounds for random selection
            if (userInput.equals("L")) computerChoice = generateRandomNumberInRange(lower, computerChoice + 1);
            if (userInput.equals("H")) computerChoice = generateRandomNumberInRange(lower, computerChoice);
        }

        log.info("Computer guessed your number correctly. Your number is: {}", computerChoice);
    }

    private int generateRandomNumberInRange(int lower, int upper) {
        return lower + random.nextInt(upper - lower);
    }

    public static void main(String[] args) {
        new GuessMyNumber(100, new Scanner(System.in)).playWithComputer(73);
    }
}
