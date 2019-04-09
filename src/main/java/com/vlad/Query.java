package com.vlad;

import java.util.Date;

/**
 * Represents record's type Query.
 */
public class Query {
    private int id;
    private String serviceID;
    private String serviceVariationID;
    private String questionTypeID;
    private String questionCategoryID;
    private String questionSubCategoryID;
    private boolean firstAnswer;
    private Date startDate;
    private Date endDate;

    public Query(int id, String serviceID, String serviceVariationID, String questionTypeID, String questionCategoryID,
                 String questionSubCategoryID, boolean firstAnswer, Date startDate, Date endDate) {
        this.id = id;
        this.serviceID = serviceID;
        this.serviceVariationID = serviceVariationID;
        this.questionTypeID = questionTypeID;
        this.questionCategoryID = questionCategoryID;
        this.questionSubCategoryID = questionSubCategoryID;
        this.firstAnswer = firstAnswer;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String toString (){
        return serviceID + " " + serviceVariationID + " " + questionTypeID + " " +  questionCategoryID + " " +
        questionSubCategoryID + " " + firstAnswer + " " + startDate + " " + endDate;
    }
}
