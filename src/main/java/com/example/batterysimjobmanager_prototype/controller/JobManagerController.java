package com.example.batterysimjobmanager_prototype.controller;

import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import com.example.batterysimjobmanager_prototype.consumer.RabbitMQJsonConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobManagerController {

    private final RabbitMQJsonConsumer rabbitMQJsonConsumer;
    private final PyBaMM_SimulationClient simulationClient;
    @Autowired
    public JobManagerController(PyBaMM_SimulationClient simulationClient, RabbitMQJsonConsumer consumer){
        this.simulationClient = simulationClient;
        this.rabbitMQJsonConsumer = consumer;
    }

    // retrieves the next simulation results from the queue
    @GetMapping("/getSimulation")
    public String getSimulationFromQueue(){
        // Check if there's something in the queue
        String simulationResults = rabbitMQJsonConsumer.getLatestSimulationResults();

        //check if the queue simulation results are empty
        if (simulationResults != null && !simulationResults.isEmpty()) {
            return simulationResults;
        } else {
            return "Queue is empty";
        }
    }
}