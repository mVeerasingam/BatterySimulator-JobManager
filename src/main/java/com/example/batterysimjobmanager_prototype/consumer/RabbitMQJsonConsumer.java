package com.example.batterysimjobmanager_prototype.consumer;

import com.example.batterysimjobmanager_prototype.clients.DbOperations_Client;
import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import com.example.batterysimjobmanager_prototype.service.SimulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    private final DbOperations_Client dbOperationsClient;
    private final SimulationService simulationService;
    private String latestSimulationResults;

    @Autowired
    public RabbitMQJsonConsumer(SimulationService simulationService, DbOperations_Client dbOperationsClient) {
        this.simulationService = simulationService;
        this.dbOperationsClient = dbOperationsClient;
    }

    @Async
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"}, concurrency = "3")
    public void consumeJsonMessage(BatterySimMessage simMessage) {
        LOGGER.info(String.format("Received JSON Message -> %s", simMessage.toString()));

        String results = simulationService.processSimulation(simMessage);
        latestSimulationResults = results;
        LOGGER.info("Received response from PyBaMM simulation service: " + results);
        dbOperationsClient.saveSimulation(results);
    }

    // retrieve the latest simulation from the queue
    public String getLatestSimulationResults() {
        return latestSimulationResults;
    }
}