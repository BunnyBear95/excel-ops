package com.alm.excelops.repository;

import com.alm.excelops.model.AgentModel;

import java.util.List;

public interface AgentDAO {

    void saveAgents(List<AgentModel> agentModelList);
}
