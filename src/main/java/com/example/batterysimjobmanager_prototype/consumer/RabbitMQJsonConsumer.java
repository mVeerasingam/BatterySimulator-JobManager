package com.example.batterysimjobmanager_prototype.consumer;

import com.example.batterysimjobmanager_prototype.clients.DbOperations_Client;
import com.example.batterysimjobmanager_prototype.clients.PyBaMM_SimulationClient;
import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    private final PyBaMM_SimulationClient simulationClient;
    private final DbOperations_Client dbOperationsClient;
    @Autowired
    public RabbitMQJsonConsumer(PyBaMM_SimulationClient simulationClient, DbOperations_Client dbOperationsClient){
        this.simulationClient = simulationClient;
        this.dbOperationsClient = dbOperationsClient;
    }
    @Async
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"}, concurrency = "3")
    public void consumeJsonMessage(BatterySimMessage simMessage){
        LOGGER.info(String.format("Received JSON Message -> %s", simMessage.toString()));
        simulationClient.simulate(simMessage);
        String results = simulationClient.simulate(simMessage);
        dbOperationsClient.simulate(results);
        //LOGGER.info("Received response from PyBaMM simulation service: " + results);
    }
}
