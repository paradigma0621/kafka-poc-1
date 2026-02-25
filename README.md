# KAFKA POC

Run inside this folder: docker compose up
 
Access Kafdrop at: http://localhost:9000/

--- 

Important note about Docker images: <br>
  zookeeper: <br>
    image: confluentinc/cp-zookeeper:7.6.0  # IMPORTANT: Do not use the "latest" tag <br>
    ... <br>
  kafka: <br>
    image: confluentinc/cp-kafka:7.6.0      # IMPORTANT: Do not use the "latest" tag <br>

