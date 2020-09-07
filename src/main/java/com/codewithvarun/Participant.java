package com.codewithvarun;

public class Participant {
    private int skillPercent = 0;
    private int luckPercent = 0;

    public static Participant newInstance() {
        return new Participant();
    }

    public Participant skill(int skillPercent) {
        this.skillPercent = skillPercent;
        return this;
    }

    public Participant luck(int luckPercent) {
        this.luckPercent = luckPercent;
        return this;
    }

    public int skill() {
        return skillPercent;
    }

    public int luck() {
        return luckPercent;
    }

    public int successFactor() {
        return ((luckPercent + skillPercent) / 100) * 100;
    }

    public String toString() {
        return String.format("%s, %s, %s", skillPercent, luckPercent, luckPercent > skillPercent ? "LUCKY" : "SKILLFUL");
    }

    public int luckFactor() {
        return luckPercent;
    }
}
