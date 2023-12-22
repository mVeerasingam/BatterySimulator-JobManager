package com.example.batterysimjobmanager_prototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatterySimMessage {
    private boolean startJob;
    private String jobType;
    private BatterySim batterySim;
}
