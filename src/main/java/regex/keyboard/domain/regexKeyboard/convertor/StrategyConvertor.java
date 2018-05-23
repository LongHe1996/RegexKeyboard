package regex.keyboard.domain.regexKeyboard.convertor;

import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexKeyboard.entity.StrategyE;
import regex.keyboard.infra.dataobject.StrategyDO;

@Component
public class StrategyConvertor implements ConvertorI<StrategyDO, StrategyE> {
    @Override
    public StrategyE doToEntity(StrategyDO dataObject) {
        return new StrategyE(dataObject.getId(), dataObject.getStrategyId(), dataObject.getStrategyRegex(), dataObject.getStrategyUse());
    }

    @Override
    public StrategyDO entityToDo(StrategyE entity) {
        return new StrategyDO(entity.getId(), entity.getStrategyId(), entity.getStrategyRegex(), entity.getStrategyUse());
    }
}
