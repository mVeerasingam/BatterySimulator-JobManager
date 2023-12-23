package com.example.batterysimjobmanager_prototype.clients;

import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "Simulation-Service", url = "http://localhost:8084")
//@FeignClient(name = "Simulation-Service", url = "http://battery-simulation-service:8084")
public interface PyBaMM_SimulationClient {
    // Test Java updating Python battery simulation parameters
    @PostMapping("/simulate")
    String simulate(@RequestBody BatterySimMessage batterySim);
}