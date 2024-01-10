# BatterySimulator_JobManager 🔋🔄
## Authors: Mark Veerasingam and Lucas Jeanes

### JDK: 19. Java: 17, Language Level: SDK Default

### Description: 
ATU 3rd Year CICD 1 Project

Job Manager manages and handle all job based operations for the battery simulator. Job Manager is the Consumer for the Queue Service.

If a message says if a job is already running, it waits before pulling from message queue. If a job is not running it tells the Simulator to execute the next job (generate a new battery). 
Job manager updates the database if and when the simulation is succesfully complete with details of the simulation/id/jobs.

## Instructions:
### Running the application From Docker:
- [Pull the Lithium Ion Battery Simulator Artifact Repository from Docker Hub](https://hub.docker.com/repository/docker/mveerasingam/batterysimulator_jobmanagerservice/general)
  - We found an issue when trying the command
    
    `docker pull mveerasingam/batterysimulator_jobmanagerservice`
    
    Produced an **Error response from daemon: manifest for mveerasingam/batterysimulator_jobmanagerservice:latest not found: manifest unknown: manifest unknown**
    
- You can pull each of the images individually
  
``
docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-database
docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-flask
docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-job-manager
docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-queue-service
docker pull mveerasingam/batterysimulator_jobmanagerservice:rabbitmq
``

- We've updated the [Docker Compose File in Job Manager to Containerise the above images from Docker](https://github.com/mVeerasingam/BatterySimulator-JobManager/blob/master/docker-compose.yml)

## Running on Localhost
- In applications.yml change the the to "host: localhost"
- Be sure to update the URL's in Client to localhost

### Supporting Microservices
- [Battery Simulator Microservice 🔋💥](https://github.com/mVeerasingam/Battery-Simulator-Microservice)
- [Battery Simulator Queue Service](https://github.com/mVeerasingam/BatterySimulator-QueueService)
- [Battery Simulator DB Operations](https://github.com/mVeerasingam/BatterySimulator_DatabaseOperations)
