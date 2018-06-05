package regex.keyboard.domain.regexkeyboard.entity;

/**
 * @Description: entity, strategy.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 12:16
 */
public class StrategyE {
    private Long id;
    private String strategyRegex;
    private String strategyUse;
    private Long strategyType;

    public StrategyE() {
    }

    public StrategyE(Long id, String strategyRegex, String strategyUse, Long strategyType) {
        this.id = id;
        this.strategyRegex = strategyRegex;
        this.strategyUse = strategyUse;
        this.strategyType = strategyType;
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

    public Long getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(Long strategyType) {
        this.strategyType = strategyType;
    }

    @Override
    public String toString() {
        return "StrategyE{" +
                "id=" + id +
                ", strategyRegex='" + strategyRegex + '\'' +
                ", strategyUse='" + strategyUse + '\'' +
                ", strategyType=" + strategyType +
                '}';
    }
}
