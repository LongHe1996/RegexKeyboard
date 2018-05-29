package regex.keyboard.infra.dataobject;

import javax.persistence.*;

import org.springframework.data.repository.cdi.Eager;

/**
 * @Description:   dataobject ,record the nature of regex rules.
 * @Author:    Eugen
 * @Mail:    longhe1996@foxmail.com
 * @CreateDate:     2018/5/29 22:51
*/
@Entity
@Table(name = "regex_rules_nature")
public class RegexRulesNatureDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String nature;

    public RegexRulesNatureDO() {
    }

    public RegexRulesNatureDO(Long id,String nature) {
        this.id=id;
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
}
