package regex.keyboard.domain.regexKeyboard.entity;

/**
 * @Description: entity, strategy.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:16
 */
public class StrategyE {
    private Long id;
    private Long strategyId;
    private String strategyRegex;
    private String strategyUse;

    public StrategyE() {
    }

    public StrategyE(Long id, Long strategyId, String strategyRegex, String strategyUse) {
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

    @Override
    public String toString() {
        return "StrategyE{" +
                "id=" + id +
                ", strategyId=" + strategyId +
                ", strategyRegex='" + strategyRegex + '\'' +
                ", strategyUse='" + strategyUse + '\'' +
                '}';
    }
}