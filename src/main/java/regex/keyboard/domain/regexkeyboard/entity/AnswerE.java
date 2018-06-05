package regex.keyboard.domain.regexkeyboard.entity;

import java.util.Date;

/**
 * @Description: entity, answer
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:09
 */
public class AnswerE {
    private Long id;
    private String answerContent;
    private UserE respondent;
    private QuestionE question;
    private Date putTime;
    private Boolean isAccepted;

    public AnswerE() {
    }

    public AnswerE(Long id, String answerContent, UserE respondent, QuestionE question, Date putTime, Boolean isAccepted) {
        this.id = id;
        this.answerContent = answerContent;
        this.respondent = respondent;
        this.question = question;
        this.putTime = putTime;
        this.isAccepted = isAccepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public UserE getRespondent() {
        return respondent;
    }

    public void setRespondent(UserE respondent) {
        this.respondent = respondent;
    }

    public QuestionE getQuestion() {
        return question;
    }

    public void setQuestion(QuestionE question) {
        this.question = question;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public String toString() {
        return "AnswerE{" +
                "id=" + id +
                ", answerContent='" + answerContent + '\'' +
                ", respondent=" + respondent +
                ", question=" + question +
                ", putTime=" + putTime +
                ", isAccepted=" + isAccepted +
                '}';
    }
}
