package regex.keyboard.infra.dataobject;

import javax.persistence.*;

/**
 * @Description: dataobject, record the system's text strategy
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:41
 */
@Entity
@Table(name = "strategy")
public class StrategyDO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String strategyRegex;
    @Column(nullable = false)
    private String strategyUse;

    public StrategyDO() {
    }

    public StrategyDO(Long id,String strategyRegex, String strategyUse) {
        this.id=id;
        this.strategyRegex = strategyRegex;
        this.strategyUse = strategyUse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrategyRegex() {
        return strategyRegex;
    }

    public void setStrategyRegex(String strategyRegex) {
        this.strategyRegex = strategyRegex;
    }

    public String getStrategyUse() {
        return strategyUse;
    }

    public void setStrategyUse(String strategyUse) {
        this.strategyUse = strategyUse;
    }
}