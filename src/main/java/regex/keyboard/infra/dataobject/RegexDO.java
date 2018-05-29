package regex.keyboard.infra.dataobject;

import javax.persistence.*;

/**
 * @Description: dataovject, record the regex information.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:51
 */
@Entity
@Table(name = "regex")
public class RegexDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String regexContent;
    @Column(nullable = false)
    private String regexDescribe;

    public RegexDO() {
    }

    public RegexDO(Long id,String regexContent, String regexDescribe) {
        this.id=id;
        this.regexContent = regexContent;
        this.regexDescribe = regexDescribe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
