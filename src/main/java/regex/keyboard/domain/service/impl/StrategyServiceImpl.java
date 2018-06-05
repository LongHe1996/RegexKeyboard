package regex.keyboard.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.StrategyDTO;
import regex.keyboard.domain.regexkeyboard.convertor.StrategyConvertor;
import regex.keyboard.domain.regexkeyboard.entity.StrategyE;
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

    @Override
    public List<StrategyDTO> selectAllSelf() {
        List<StrategyDTO> allStrategy = new ArrayList<>();
        for (StrategyDO strategyDO : strategyRepository.findByStrategyType(1L)
                ) {
            StrategyE strategyE = strategyConvertor.doToEntity(strategyDO);
            allStrategy.add(new StrategyDTO(strategyE, "all.strategy.by.type.1"));
        }
        return allStrategy;
    }

    @Override
    public List<StrategyDTO> selectDeterminedNTimes() {
        List<StrategyDTO> allStrategy = new ArrayList<>();
        for (StrategyDO strategyDO : strategyRepository.findByStrategyType(2L)
                ) {
            StrategyE strategyE = strategyConvertor.doToEntity(strategyDO);
            allStrategy.add(new StrategyDTO(strategyE, "all.strategy.by.type.2"));
        }
        return allStrategy;
    }

    @Override
    public List<StrategyDTO> selectLeastNTimes() {
        List<StrategyDTO> allStrategy = new ArrayList<>();
        for (StrategyDO strategyDO : strategyRepository.findByStrategyType(3L)
                ) {
            StrategyE strategyE = strategyConvertor.doToEntity(strategyDO);
            allStrategy.add(new StrategyDTO(strategyE, "all.strategy.by.type.3"));
        }
        return allStrategy;
    }

    @Override
    public List<StrategyDTO> selectNtoMTimes() {
        List<StrategyDTO> allStrategy = new ArrayList<>();
        for (StrategyDO strategyDO : strategyRepository.findByStrategyType(4L)
                ) {
            StrategyE strategyE = strategyConvertor.doToEntity(strategyDO);
            allStrategy.add(new StrategyDTO(strategyE, "all.strategy.by.type.3"));
        }
        return allStrategy;
    }
}
