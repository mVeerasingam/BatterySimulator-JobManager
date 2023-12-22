package com.example.batterysimjobmanager_prototype;

import com.example.batterysimjobmanager_prototype.consumer.RabbitMQJsonConsumer;
import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobManagerController {

    private PyBaMM_SimulationClient simulationClient;
    private final RabbitMQJsonConsumer rabbitMQJsonConsumer;

    @Autowired
    public JobManagerController(RabbitMQJsonConsumer rabbitMQJsonConsumer) {
        this.rabbitMQJsonConsumer = rabbitMQJsonConsumer;
    }

    @GetMapping("/receiveJsonMessage")
    public String receiveJsonMessage() {
        // Perform any processing related to received JSON messages
        return "Received JSON message and processed!";
    }

//    @Autowired
//    public JobManagerController(PyBaMM_SimulationClient simulationClient){
//        this.simulationClient = simulationClient;
//    }
//
//    @PostMapping("/updateBatteryParameters")
//    public String updateBatteryParameters(@RequestBody BatterySim batterySim) {
//        System.out.println("Received request to update battery parameters from Java microservice.");
//
//        // Forward the request to the PyBaMM simulation service
//        String response = simulationClient.simulate(batterySim);
//
//        System.out.println("Received response from PyBaMM simulation service: " + response);
//
//        return response;
//    }
}
