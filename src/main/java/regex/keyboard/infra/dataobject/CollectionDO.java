package regex.keyboard.infra.dataobject;

import java.util.Date;
import javax.persistence.*;

/**
 * @Description:    dataobject the.record collection information
 * @Author:    Eugen
 * @Mail:    longhe1996@foxmail.com
 * @CreateDate:     2018/5/29 22:44
*/
@Entity
@Table(name = "collection")
public class CollectionDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long questionId;
    @Column(nullable = false)
    private Long collector;
    private Date collectionTime;

    public CollectionDO() {
    }

    public CollectionDO(Long id,Long questionId, Long collector, Date collectionTime) {
        this.id=id;
        this.questionId = questionId;
        this.collector = collector;
        this.collectionTime = collectionTime;
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

    public Long getCollector() {
        return collector;
    }

    public void setCollector(Long collector) {
        this.collector = collector;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }
}
