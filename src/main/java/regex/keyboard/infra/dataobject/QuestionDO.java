package regex.keyboard.infra.dataobject;

import java.util.Date;
import javax.persistence.*;

/**
 * @Description: dataobject.record the question information.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:52
 */
@Entity
@Table(name = "question")
public class QuestionDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String questionTitle;
    private String questionContent;
    @Column(nullable = false)
    private Long questioner;
    private Date putTime;
    @Column(nullable = false)
    private Boolean isSolved;
    private Long acceptAnswer;

    public QuestionDO() {
    }

    public QuestionDO(Long id, String questionTitle, String questionContent, Long questioner, Date putTime, Boolean isSolved, Long acceptAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
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
