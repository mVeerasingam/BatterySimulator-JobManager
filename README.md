# BatterySimulator_JobManager 🔋🔄
## Authors: Mark Veerasingam and Lucas Jeanes

### JDK: 19. Java: 17, Language Level: SDK Default

### Description: 
ATU 3rd Year CICD 1 Project

Job Manager manages and handle all job based operations for the battery simulator. Job Manager looks at the message queues sent from  microservice 1. 
If a message says if a job is already running, it waits before pulling from message queue. If a job is not running it tells microservice 3 to execute the next job (generate a new battery). 
Job manager updates the database if and when the simulation is succesfully complete with details of the simulation/id/jobs.

Job manager speaks to the [Battery Simulator Microservice](https://github.com/mVeerasingam/Battery-Simulator-Microservice) over Rest API Post requests.

### Current Features: 
- Update Lithium Ion Battery Parameters [POST] ``http://127.0.0.1:8083/updateBatteryParameters``
  
  Example POST
  {
  "time": 3,
  "upperVoltage": 4.2,
  "lowerVoltage": 2.5,
  "nominalCell": 7,
  "controlCurrent": 2
}

### Supporting Microservices
- [Battery Simulator Microservice 🔋💥](https://github.com/mVeerasingam/Battery-Simulator-Microservice)
