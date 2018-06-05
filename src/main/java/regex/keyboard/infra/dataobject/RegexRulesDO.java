package regex.keyboard.infra.dataobject;

import javax.persistence.*;

/**
 * @Description: dataobject, record the regex rules
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:46
 */
@Entity
@Table(name = "regex_rules")
public class RegexRulesDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String ruleContent;
    @Column(nullable = false, unique = true)
    private String ruleDescribe;
    @Column(nullable = false)
    private Long ruleNature;

    public RegexRulesDO() {
    }

    public RegexRulesDO(Long id, String ruleContent, String ruleDescribe, Long ruleNature) {
        this.id = id;
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
