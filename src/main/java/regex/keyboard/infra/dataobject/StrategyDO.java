package regex.keyboard.infra.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: dataobject, record the system's text strategy
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 11:41
 */
@Entity
@Table(name = "strategydo")
public class StrategyDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long strategyId;
    private String strategyRegex;
    private String strategyUse;

    public StrategyDO() {
    }

    public StrategyDO(Long id, Long strategyId, String strategyRegex, String strategyUse) {
        this.id = id;
        this.strategyId = strategyId;
        this.strategyRegex = strategyRegex;
        this.strategyUse = strategyUse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
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