package com.example.batterysimjobmanager_prototype.controller;

import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobManagerController {
    private final PyBaMM_SimulationClient simulationClient;
    @Autowired
    public JobManagerController(PyBaMM_SimulationClient simulationClient){
        this.simulationClient = simulationClient;
    }

    @PostMapping("/simulateCell")
    public String updateBatteryParameters(@RequestBody BatterySimMessage simMessage) {
        System.out.println("Received request to update battery parameters from Java microservice.");
        String response = simulationClient.simulateCell(simMessage);
        System.out.println("Received response from PyBaMM simulation service: " + response);
        return response;
    }

    @PostMapping("/simulateDriveCycle")
    public String simulateDriveCycle(@RequestBody BatterySimMessage simMessage) {
        System.out.println("Received request to update battery parameters from Java microservice.");
        String response = simulationClient.simulateDriveCycle(simMessage);
        System.out.println("Received response from PyBaMM simulation service: " + response);
        return response;
    }
}