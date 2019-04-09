package com.vlad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that check what kind of record is on a row, creates appropriate objects.
 */
public class Controller {
    /**
     * @param sCurrentLine - each line of file
     * @return if first element of line is 'C' - Question, if first element is 'D' - Query
     */
    public static boolean isRecordOfTypeQuestion(String sCurrentLine) {
        if (sCurrentLine.charAt(0) == 'C') {
            return true;
        } else return false;
    }

    /**
     * take String line and return Question object
     * @param numberOfRowsActual
     * @param sCurrentLine
     * @return Question
     */
    public static Question createQuestion(int numberOfRowsActual, String sCurrentLine) {
        String[] tokens = sCurrentLine.split(" ");

        String[] serviceTypeAndSubType = tokens[1].split("\\.");
        String serviceID = serviceTypeAndSubType[0];

        String serviceVariationID = "*";
        if (serviceTypeAndSubType.length > 1) {
            serviceVariationID = serviceTypeAndSubType[1];
        }

        String[] questionTypeCategorySubCategory = tokens[2].split("\\.");
        String questionTypeID = questionTypeCategorySubCategory[0];
        String questionCategoryID = "*";
        String questionSubCategoryID = "*";

        if (questionTypeCategorySubCategory.length > 1) {
            questionCategoryID = questionTypeCategorySubCategory[1];
        }

        if (questionTypeCategorySubCategory.length > 2) {
            questionSubCategoryID = questionTypeCategorySubCategory[2];
        }

        boolean firstAnswer = false;
        if (tokens[3].equals("P")) {
            firstAnswer = true;
        }


        Date date = null;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(tokens[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int timeDuration = Integer.valueOf(tokens[5]);
        return new Question(numberOfRowsActual, serviceID, serviceVariationID, questionTypeID,
                questionCategoryID, questionSubCategoryID, firstAnswer, date, timeDuration);
    }

    /**
     * Take String line and return Query object
     * @param numberOfRowsActual
     * @param sCurrentLine
     * @return Query
     */
    public static Query createQuery(int numberOfRowsActual, String sCurrentLine) {
        String[] tokens = sCurrentLine.split(" ");

        String[] serviceTypeAndSubType = tokens[1].split("\\.");
        String serviceID = serviceTypeAndSubType[0];

        String serviceVariationID = "*";
        if (serviceTypeAndSubType.length > 1) {
            serviceVariationID = serviceTypeAndSubType[1];
        }

        String[] questionTypeCategorySubCategory = tokens[2].split("\\.");
        String questionTypeID = questionTypeCategorySubCategory[0];
        String questionCategoryID = "*";
        String questionSubCategoryID = "*";

        if (questionTypeCategorySubCategory.length > 1) {
            questionCategoryID = questionTypeCategorySubCategory[1];
        }

        if (questionTypeCategorySubCategory.length > 2) {
            questionSubCategoryID = questionTypeCategorySubCategory[2];
        }

        boolean firstAnswer = false;
        if (tokens[3].equals("P")) {
            firstAnswer = true;
        }

        String[] date = tokens[4].split("-");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("dd.MM.yyyy").parse(date[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = startDate;
        if (date.length > 1) {
            try {
                endDate = new SimpleDateFormat("dd.MM.yyyy").parse(date[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return new Query(numberOfRowsActual, serviceID, serviceVariationID, questionTypeID,
                questionCategoryID, questionSubCategoryID, firstAnswer, startDate, endDate);
    }
}
