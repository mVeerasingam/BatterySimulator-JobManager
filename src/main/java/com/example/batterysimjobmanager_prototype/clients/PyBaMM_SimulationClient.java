package com.example.batterysimjobmanager_prototype.clients;

import com.example.batterysimjobmanager_prototype.dto.BatterySimMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Async
@FeignClient(name = "Simulation-Service", url = "http://localhost:8084")
//@FeignClient(name = "Simulation-Service", url = "http://battery-simulation-service:8084")
public interface PyBaMM_SimulationClient {
    @PostMapping("/cell/simulate")
    String simulateCell(@RequestBody BatterySimMessage batterySim);

    @PostMapping("/drivecycle/simulate")
    String simulateDriveCycle(@RequestBody BatterySimMessage batterySim);
}