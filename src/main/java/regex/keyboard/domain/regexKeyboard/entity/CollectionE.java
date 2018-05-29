package regex.keyboard.domain.regexKeyboard.entity;


import java.util.Date;
/**
 * @Description:    entity,collection.
 * @Author:    Eugen
 * @Mail:    longhe1996@foxmail.com
 * @CreateDate:     2018/5/29 23:10
*/
public class CollectionE {
    private Long id;
    private QuestionE question;
    private UserE collector;
    private Date collectionTime;

    public CollectionE() {
    }

    public CollectionE(Long id, QuestionE question, UserE collector, Date collectionTime) {
        this.id = id;
        this.question = question;
        this.collector = collector;
        this.collectionTime = collectionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionE getQuestion() {
        return question;
    }

    public void setQuestion(QuestionE question) {
        this.question = question;
    }

    public UserE getCollector() {
        return collector;
    }

    public void setCollector(UserE collector) {
        this.collector = collector;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public String toString() {
        return "CollectionE{" +
                "id=" + id +
                ", question=" + question +
                ", collector=" + collector +
                ", collectionTime=" + collectionTime +
                '}';
    }
}
