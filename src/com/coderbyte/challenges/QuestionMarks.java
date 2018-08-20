package com.coderbyte.challenges;

public class QuestionMarks {

    public static String questionsMarks(String str) {
        int quantityOfQuestionMarks = 0, sumOfNumbers = 0;
        boolean foundFirstNumber = false, foundSecondNumber = false, valid = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 49 && str.charAt(i) <= 57) { //if it´s a number
                sumOfNumbers += Integer.valueOf(String.valueOf(str.charAt(i)));
                //it checks whether it's the first or the second number that has been found
                if (foundFirstNumber == false) foundFirstNumber = true;
                else foundSecondNumber = true;
            }

            //We only care about question marks found between two numbers
            if (str.charAt(i) == 63 && (foundFirstNumber || foundSecondNumber)) quantityOfQuestionMarks++;

            if (foundFirstNumber && foundSecondNumber) {
                if(sumOfNumbers == 10 && quantityOfQuestionMarks == 3) valid = true;
                else if(sumOfNumbers == 10 && quantityOfQuestionMarks != 3) valid = false;

                //It resets the flags to resume the search for another pair of numbers
                foundFirstNumber = false;
                foundSecondNumber = false;
                quantityOfQuestionMarks = 0;
                sumOfNumbers = 0;
            }
        }

        if (valid) return "true";
        return "false";
    }
}
