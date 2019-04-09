package com.vlad;

import java.util.Date;

/**
 * Represents record's type Question.
 */
public class Question {
    private int id;
    private String serviceID;
    private String serviceVariationID;
    private String questionTypeID;
    private String questionCategoryID;
    private String questionSubCategoryID;
    private boolean firstAnswer;
    private Date date;
    private int timeDuration;

    public Question(int id, String serviceID, String serviceVariationID, String questionTypeID, String questionCategoryID,
                    String questionSubCategoryID, boolean firstAnswer, Date date, int timeDuration) {
        this.id = id;
        this.serviceID = serviceID;
        this.serviceVariationID = serviceVariationID;
        this.questionTypeID = questionTypeID;
        this.questionCategoryID = questionCategoryID;
        this.questionSubCategoryID = questionSubCategoryID;
        this.firstAnswer = firstAnswer;
        this.date = date;
        this.timeDuration = timeDuration;
    }

    public int getId() {
        return id;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getServiceVariationID() {
        return serviceVariationID;
    }

    public String getQuestionTypeID() {
        return questionTypeID;
    }

    public String getQuestionCategoryID() {
        return questionCategoryID;
    }

    public String getQuestionSubCategoryID() {
        return questionSubCategoryID;
    }

    public boolean isFirstAnswer() {
        return firstAnswer;
    }

    public Date getDate() {
        return date;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public String toString(){
        return serviceID + " " + serviceVariationID + " " +  questionTypeID + " " + questionCategoryID + " " +
                questionSubCategoryID + " " + firstAnswer + " " + date + " " + timeDuration;
    }
}
