package com.example.batterysimjobmanager_prototype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatterySimMessage {
    private String id;
    private String simulationType;
    private double time;
    private double upperVoltage;
    private double lowerVoltage;
    private double nominalCell;
    private double controlCurrent;
}