# KAFKA DEMO
Kafka Demo Project
### Docker
Run with Docker using min Java 11

run "docker compose up -d" on a terminal which is at project path
After all of the containers get to the started status
Run the Spring Boot application KafkaDemoApplication

To produce demo data send GET request to http://localhost:8080/api/v1/producer

Afterwards 10000 rows will be inserted to demo_entity table