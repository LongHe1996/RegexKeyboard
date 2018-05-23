package regex.keyboard.infra.dataobject;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: dataobject.record the question information.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:52
 */
@Entity
@Table(name = "questiondo")
public class QuestionDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long questionId;
    private String questionContent;
    private Long questioner;
    private Date putTime;
    private Boolean isSolved;
    private Long acceptAnswer;

    public QuestionDO() {
    }

    public QuestionDO(Long id, Long questionId, String questionContent, Long questioner, Date putTime, Boolean isSolved, Long acceptAnswer) {
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

    public Long getQuestioner() {
        return questioner;
    }

    public void setQuestioner(Long questioner) {
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

    public Long getAcceptAnswer() {
        return acceptAnswer;
    }

    public void setAcceptAnswer(Long acceptAnswer) {
        this.acceptAnswer = acceptAnswer;
    }
}
