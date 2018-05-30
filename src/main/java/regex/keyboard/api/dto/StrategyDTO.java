package regex.keyboard.api.dto;

import regex.keyboard.domain.regexKeyboard.entity.StrategyE;

public class StrategyDTO {
    private StrategyE strategyE;
    private String message;

    public StrategyDTO(StrategyE strategyE, String message) {
        this.strategyE = strategyE;
        this.message = message;
    }

    public StrategyE getStrategyE() {
        return strategyE;
    }

    public String getMessage() {
        return message;
    }
}
