package com.alm.excelops.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "new_agent", schema = "poc")
public class Agent {

    @Id
    @GeneratedValue(generator = "new_agent_seq")
    @SequenceGenerator(name = "new_agent_seq",schema = "poc", sequenceName = "new_agent_seq", initialValue = 1, allocationSize = 1)
    private Long agentId;
    private String legalFirstName;
    private String legalLastName;
    private String legalMiddleName;
    private String pinCode;
    private String city;
    private String state;

}
