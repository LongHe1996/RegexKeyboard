package regex.keyboard.domain.regexKeyboard.entity;

import java.util.Date;

/**
 * @Description: entity, question.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:10
 */
public class QuestionE {
    private Long id;
    private Long questionId;
    private String questionContent;
    private UserE questioner;
    private Date putTime;
    private Boolean isSolved;
    private AnswerE acceptAnswer;

    public QuestionE() {
    }

    public QuestionE(Long id, Long questionId, String questionContent, UserE questioner, Date putTime, Boolean isSolved, AnswerE acceptAnswer) {
        this.id = id;
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.questioner = questioner;
        this.putTime = putTime;
        this.isSolved = isSolved;
        this.acceptAnswer = acceptAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Boolean getSolved() {
        return isSolved;
    }

    public void setSolved(Boolean solved) {
        isSolved = solved;
    }

    public AnswerE getAcceptAnswer() {
        return acceptAnswer;
    }

    public void setAcceptAnswer(AnswerE acceptAnswer) {
        this.acceptAnswer = acceptAnswer;
    }

    @Override
    public String toString() {
        return "QuestionE{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", questionContent='" + questionContent + '\'' +
                ", questioner=" + questioner +
                ", putTime=" + putTime +
                ", isSolved=" + isSolved +
                ", acceptAnswer=" + acceptAnswer +
                '}';
    }
}
