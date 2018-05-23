package regex.keyboard.infra.dataobject;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: dataobject, record the answer information.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:55
 */
@Entity
@Table(name = "answerdo")
public class AnswerDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long answerId;
    private String answerContent;
    private Long respondent;
    private Long questionId;
    private Date putTime;
    private Boolean isAccepted;

    public AnswerDO() {
    }

    public AnswerDO(Long id, Long answerId, String answerContent, Long respondent, Long questionId, Date putTime, Boolean isAccepted) {
        this.id = id;
        this.answerId = answerId;
        this.answerContent = answerContent;
        this.respondent = respondent;
        this.questionId = questionId;
        this.putTime = putTime;
        this.isAccepted = isAccepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Long getRespondent() {
        return respondent;
    }

    public void setRespondent(Long respondent) {
        this.respondent = respondent;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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
}
