package regex.keyboard.api.dto;

import regex.keyboard.domain.regexkeyboard.entity.UserE;

public class OneForAllQuestionDTO {
    private Long id;
    private String questionTitle;
    private String questionContent;
    private UserE questioner;
    private String putTime;
    private Boolean isSolved;
    private Integer answerNum;

    public OneForAllQuestionDTO(Long id, String questionTitle, String questionContent, UserE questioner, String putTime, Boolean isSolved, Integer answerNum) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questioner = questioner;
        this.putTime = putTime;
        this.isSolved = isSolved;
        this.answerNum = answerNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public UserE getQuestioner() {
        return questioner;
    }

    public void setQuestioner(UserE questioner) {
        this.questioner = questioner;
    }

    public String getPutTime() {
        return putTime;
    }

    public void setPutTime(String putTime) {
        this.putTime = putTime;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }
}
