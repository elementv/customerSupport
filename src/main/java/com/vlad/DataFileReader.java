package com.vlad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that take information from the file, check it for valid and save Questions and Queries.
 */
public class DataFileReader {
    private static final String FILENAME = "F:\\programming\\customerSupport\\Source Data.txt"; // Select your path to file with data
    private static int numberOfRowsExpected;
    private static int numberOfRowsActual;

    private static ArrayList<Question> questions = new ArrayList<Question>(); // list of questions
    private static ArrayList<Query> queries = new ArrayList<Query>(); // list of queries

    /**
     * Read file from filepath and creates 2 collection for each of them.
     */
    public static void readFile() {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine; // each line of file as String

            // First line in file have information about number of rows in line
            if ((sCurrentLine = br.readLine()) != null) {
                numberOfRowsExpected = Integer.valueOf(sCurrentLine);
            }

            // Number of rows can't be bigger than 100000
            while ((sCurrentLine = br.readLine()) != null && numberOfRowsActual <= 100000) {
                // If type of the line is Question -> create Question from this line and add it to the list
                if (Controller.isRecordOfTypeQuestion(sCurrentLine)) {
                    questions.add(Controller.createQuestion(numberOfRowsActual, sCurrentLine));
                    numberOfRowsActual++;
                }
                // If type of the line is Query -> create Query from this line and add it to the list
                else {
                    queries.add(Controller.createQuery(numberOfRowsActual, sCurrentLine));
                    numberOfRowsActual++;
                }
            }

            // Compare expected and actual number of rows
            if (numberOfRowsExpected != numberOfRowsActual) {
                System.out.println("Here is wrong input data about number of rows.");
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static ArrayList<Query> getQueries() {
        return queries;
    }
}
