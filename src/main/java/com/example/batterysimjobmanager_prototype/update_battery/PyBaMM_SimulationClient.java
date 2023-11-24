package com.example.batterysimjobmanager_prototype.update_battery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Simulation-Service", url = "http://127.0.0.1:8084")
public interface PyBaMM_SimulationClient {
    // Test Java updating Python battery simulation parameters
    @PostMapping("/simulate")
    String simulate(@RequestBody BatteryParameters batteryParameters);
}
