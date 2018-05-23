package regex.keyboard.infra.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: dataobject, record the regex rules
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:46
 */
@Entity
@Table(name = "regex_rulesdo")
public class RegexRulesDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long ruleId;
    private String ruleContent;
    private String ruleDescribe;
    private Long ruleNature;

    public RegexRulesDO() {
    }

    public RegexRulesDO(Long id,Long ruleId, String ruleContent, String ruleDescribe, Long ruleNature) {
        this.id=id;
        this.ruleId = ruleId;
        this.ruleContent = ruleContent;
        this.ruleDescribe = ruleDescribe;
        this.ruleNature = ruleNature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
    }

    public String getRuleDescribe() {
        return ruleDescribe;
    }

    public void setRuleDescribe(String ruleDescribe) {
        this.ruleDescribe = ruleDescribe;
    }

    public Long getRuleNature() {
        return ruleNature;
    }

    public void setRuleNature(Long ruleNature) {
        this.ruleNature = ruleNature;
    }
}
