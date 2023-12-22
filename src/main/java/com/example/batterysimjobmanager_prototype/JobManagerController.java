package com.example.batterysimjobmanager_prototype;

import com.example.batterysimjobmanager_prototype.dto.BatterySim;
import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobManagerController {
    private PyBaMM_SimulationClient simulationClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(JobManagerController.class);

    @Autowired
    public JobManagerController(PyBaMM_SimulationClient simulationClient){
        this.simulationClient = simulationClient;
    }

    @PostMapping("/updateBatteryParameters")
    public String updateBatteryParameters(@RequestBody BatterySim batterySim) {
        System.out.println("Received request to update battery parameters from Java microservice.");

        // Forward the request to the PyBaMM simulation service
        String response = simulationClient.simulate(batterySim);

        System.out.println("Received response from PyBaMM simulation service: " + response);

        return response;
    }
}
