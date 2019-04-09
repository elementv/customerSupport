package com.vlad;

import java.util.ArrayList;

/**
 * Compare queries filters with questions data.
 */
public class Handler {
    /**
     * @param questions - list with all questions from file
     * @param queries   - list of all queries from file
     * @return information about average waiting time for each query
     */
    public static String calculateAverageWaitingTime(ArrayList<Question> questions, ArrayList<Query> queries) {
        String averageWaitingTime = ""; // Average waiting time for each query
        int timeWaitSum; // All waiting time for each query
        int numberOfQuestions; // Number of Question that satisfy the conditions
        for (Query query : queries) {
            timeWaitSum = 0;
            numberOfQuestions = 0;
            // Compare all queries to all questions
            for (Question question : questions) {
                // Continue with question which come before the query
                if (query.getId() > question.getId()) {
                    // service_id filter
                    if (query.getServiceID().equals("*") || (query.getServiceID().equals(question.getServiceID()))) {
                        // variation_id filter
                        if (query.getServiceVariationID().equals("*") || (query.getServiceVariationID().equals(question.getServiceVariationID()))) {
                            // question_type_id filter
                            if (query.getQuestionTypeID().equals("*") || (query.getQuestionTypeID().equals(question.getQuestionTypeID()))) {
                                // category_id filter
                                if (query.getQuestionCategoryID().equals("*") || query.getQuestionCategoryID().equals(question.getQuestionCategoryID())) {
                                    // sub-category_id filter
                                    if (query.getQuestionSubCategoryID().equals("*") || (query.getQuestionSubCategoryID().equals(question.getQuestionSubCategoryID()))) {
                                        // P/N filter
                                        if (query.isFirstAnswer() == question.isFirstAnswer()) {
                                            // date filter
                                            if (question.getDate().compareTo(query.getStartDate()) >= 0 && question.getDate().compareTo(query.getEndDate()) <= 0) {
                                                timeWaitSum += question.getTimeDuration();
                                                numberOfQuestions++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // if here is not question with query's filters output '-' else calculate average waiting time
            if (numberOfQuestions == 0) {
                averageWaitingTime += "-\n";
            } else {
                averageWaitingTime += "" + (timeWaitSum / numberOfQuestions) + "\n";
            }
        }
        return averageWaitingTime;
    }
}
