package com.alm.excelops.mapper;

import com.alm.excelops.entity.Agent;
import com.alm.excelops.model.AgentModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgentMapper {

    List<Agent> mapListOfAgentsFromModel(List<AgentModel> agentModelList);

}
