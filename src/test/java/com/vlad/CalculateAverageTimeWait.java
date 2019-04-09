package com.vlad;

public class CalculateAverageTimeWait {
    public static void main(String[] args) {
        DataFileReader.readFile();
        System.out.println(Handler.calculateAverageWaitingTime(DataFileReader.getQuestions(), DataFileReader.getQueries()));
    }
}

