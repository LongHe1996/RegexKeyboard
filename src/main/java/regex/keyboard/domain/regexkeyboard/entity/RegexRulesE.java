package regex.keyboard.domain.regexkeyboard.entity;

import org.springframework.stereotype.Component;

/**
 * @Description: entity, regex rules.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:15
 */
@Component
public class RegexRulesE {
    private Long id;
    private String ruleContent;
    private String ruleDescribe;
    private Long ruleNature;
    private String ruleExample;

    public RegexRulesE() {
    }

    public RegexRulesE(Long id, String ruleContent, String ruleDescribe, Long ruleNature, String ruleExample) {
        this.id = id;
        this.ruleContent = ruleContent;
        this.ruleDescribe = ruleDescribe;
        this.ruleNature = ruleNature;
        this.ruleExample = ruleExample;
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

    public String getRuleExample() {
        return ruleExample;
    }

    public void setRuleExample(String ruleExample) {
        this.ruleExample = ruleExample;
    }

    @Override
    public String toString() {
        return "RegexRulesE{" +
                "id=" + id +
                ", ruleContent='" + ruleContent + '\'' +
                ", ruleDescribe='" + ruleDescribe + '\'' +
                ", ruleNature=" + ruleNature +
                ", ruleExample='" + ruleExample + '\'' +
                '}';
    }
}
