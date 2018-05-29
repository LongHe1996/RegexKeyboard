package regex.keyboard.domain.regexKeyboard.entity;
/**
 * @Description:   entity,regexrulesnature.
 * @Author:    Eugen
 * @Mail:    longhe1996@foxmail.com
 * @CreateDate:     2018/5/29 23:11
*/
public class RegexRulesNatureE {
    private Long id;
    private String nature;

    public RegexRulesNatureE() {
    }

    public RegexRulesNatureE(Long id, String nature) {
        this.id = id;
        this.nature = nature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "RegexRulesNatureE{" +
                "id=" + id +
                ", nature='" + nature + '\'' +
                '}';
    }
}
