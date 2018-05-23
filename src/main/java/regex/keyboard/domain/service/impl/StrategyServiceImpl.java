package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.StrategyDTO;
import regex.keyboard.domain.regexKeyboard.convertor.StrategyConvertor;
import regex.keyboard.domain.regexKeyboard.entity.StrategyE;
import regex.keyboard.domain.repository.StrategyRepository;
import regex.keyboard.domain.service.StrategyService;
import regex.keyboard.infra.dataobject.StrategyDO;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private StrategyRepository strategyRepository;
    @Autowired
    private StrategyConvertor strategyConvertor;

    @Override
    public List<StrategyDTO> selectAllStrategy() {
        List<StrategyDTO> allStrategy = new ArrayList<>();
        for (StrategyDO strategyDO : strategyRepository.findAll()
                ) {
            StrategyE strategyE = strategyConvertor.doToEntity(strategyDO);
            allStrategy.add(new StrategyDTO(strategyE, "all.strategy"));
        }
        return allStrategy;
    }
}
