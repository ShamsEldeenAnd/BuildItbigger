package com.developer.albyroni.jocklib;

public class Jock {
    private static final String jokes[] = {"A: I have the perfect son.\n" +
            "B: Does he smoke?\n" +
            "A: No, he doesn't.\n" +
            "B: Does he drink whiskey?\n" +
            "A: No, he doesn't.\n" +
            "B: Does he ever come home late?\n" +
            "A: No, he doesn't.\n" +
            "B: I guess you really do have the perfect son. How old is he?\n" +
            "A: He will be six months old next Wednesday. "
            , "Girl: You would be a good dancer except for two things.\n" +
            "Boy: What are the two things?\n" +
            "Girl: Your feet. ",
            "A family of mice were surprised by a big cat. Father Mouse jumped and and said, \"Bow-wow!\" The cat ran away. \"What was that, Father?\" asked Baby Mouse. \"Well, son, that's why it's important to learn a second language.\" "
            , "Headmaster: I've had complaints about you, Johnny, from all your teachers. What have you been doing?\n" +
            "Johnny: Nothing, sir.\n" +
            "Headmaster: Exactly. ",
            "A: Why are you crying?\n" +
                    "B: The elephant is dead.\n" +
                    "A: Was he your pet?\n" +
                    "B: No, but I'm the one who must dig his grave. "
    };


    public String JockTeller() {
        int random = (int) (Math.random()*3);

        return jokes[random];
    }
}
