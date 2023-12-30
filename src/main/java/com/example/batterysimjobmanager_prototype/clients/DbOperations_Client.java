package com.example.batterysimjobmanager_prototype.clients;

import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Async
@FeignClient(name = "Database-Connection-Service", url = "http://localhost:8080")
//@FeignClient(name = "Simulation-Service", url = "http://battery-simulation-service:8084")
public interface DbOperations_Client {
    // Test Java updating Python battery simulation parameters
    @PostMapping("/createSimulation")
    String simulate(@RequestBody String simResults);
}