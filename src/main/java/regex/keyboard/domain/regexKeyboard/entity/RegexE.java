package regex.keyboard.domain.regexKeyboard.entity;

/**
 * @Description: entity, regex.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:13
 */
public class RegexE {
    private Long id;
    private String regexContent;
    private String regexDescribe;

    public RegexE() {
    }

    public RegexE(Long id, String regexContent, String regexDescribe) {
        this.id = id;
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

    @Override
    public String toString() {
        return "RegexE{" +
                "id=" + id +
                ", regexContent='" + regexContent + '\'' +
                ", regexDescribe='" + regexDescribe + '\'' +
                '}';
    }
}
