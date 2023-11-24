package com.example.batterysimjobmanager_prototype;

import com.example.batterysimjobmanager_prototype.update_battery.BatteryParameters;
import com.example.batterysimjobmanager_prototype.update_battery.PyBaMM_SimulationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobManagerController {
    private PyBaMM_SimulationClient simulationClient;
    @Autowired
    public JobManagerController(PyBaMM_SimulationClient simulationClient){
        this.simulationClient = simulationClient;
    }

        @PostMapping("/updateBatteryParameters")
    public String updateBatteryParameters(@RequestBody BatteryParameters batteryParameters) {
        System.out.println("Received request to update battery parameters from Java microservice.");

        // Forward the request to the PyBaMM simulation service
        String response = simulationClient.simulate(batteryParameters);

        System.out.println("Received response from PyBaMM simulation service: " + response);

        return response;
    }
}
