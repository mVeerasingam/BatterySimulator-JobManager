package com.example.batterysimjobmanager_prototype.service;

import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {
    private final PyBaMM_SimulationClient simulationClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(SimulationService.class);

    @Autowired
    public SimulationService(PyBaMM_SimulationClient simulationClient) {
        this.simulationClient = simulationClient;
    }

    public String processSimulation(BatterySimMessage simMessage) {
        String results = null;
        switch (simMessage.getSimulationType()) {
            case "cell":
                results = simulationClient.simulateCell(simMessage);
                break;

            case "driveCycle":
                results = simulationClient.simulateDriveCycle(simMessage);
                break;

            default:
                LOGGER.warn("Invalid simulation type: " + simMessage.getSimulationType() + "\nUse 'cell' or 'driveCycle'");
                results = "Invalid simulation type: " + simMessage.getSimulationType() +
                        ". Use 'cell' or 'driveCycle'";
                break;
        }
        return results;
    }
}
