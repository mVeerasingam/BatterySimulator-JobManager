package com.example.batterysimjobmanager_prototype.controller;

import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void processSimulationRequest(BatterySimMessage simMessage) {
        System.out.println("Received request to update battery parameters from RabbitMQ queue.");

        // Process the request and update the battery parameters
        String response = simulationClient.simulate(simMessage);

        System.out.println("Received response from PyBaMM simulation service: " + response);
    }
}