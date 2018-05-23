package regex.keyboard.infra.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: dataovject, record the regex information.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:51
 */
@Entity
@Table(name = "regexdo")
public class RegexDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long regexId;
    private String regexContent;
    private String regexDescribe;

    public RegexDO() {
    }

    public RegexDO(Long id,Long regexId, String regexContent, String regexDescribe) {
        this.id=id;
        this.regexId = regexId;
        this.regexContent = regexContent;
        this.regexDescribe = regexDescribe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegexId() {
        return regexId;
    }

    public void setRegexId(Long regexId) {
        this.regexId = regexId;
    }

    public String getRegexContent() {
        return regexContent;
    }

    public void setRegexContent(String regexContent) {
        this.regexContent = regexContent;
    }

    public String getRegexDescribe() {
        return regexDescribe;
    }

    public void setRegexDescribe(String regexDescribe) {
        this.regexDescribe = regexDescribe;
    }
}
