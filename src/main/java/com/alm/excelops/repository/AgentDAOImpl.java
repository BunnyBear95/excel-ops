package com.alm.excelops.repository;

import com.alm.excelops.entity.Agent;
import com.alm.excelops.mapper.AgentMapper;
import com.alm.excelops.model.AgentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AgentDAOImpl implements AgentDAO{

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    private AgentMapper agentMapper;

    @Override
    public void saveAgents(List<AgentModel> agentModelList) {
        List<Agent> agentList = agentMapper.mapListOfAgentsFromModel(agentModelList);
        agentRepository.saveAll(agentList);
    }
}
