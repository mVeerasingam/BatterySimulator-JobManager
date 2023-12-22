package com.example.batterysimjobmanager_prototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatterySimMessage implements Serializable{
    private boolean startJob;
    private String jobType;
    private BatterySim batterySim;
}
