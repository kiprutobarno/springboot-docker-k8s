# Application Containerizatin and Orchestration

This is a simple application that demonstrates containerization with Docker and container orchestration with Kubernetes

## Technology

- Java 21
- Spring Boot 3.1.4
- Docker 24.0.6
- Kubernetes (minikube)
- Maven 3.9.5
- MySQL 8.0.34

## Setup

To run this project locally

1. Clone the repository from github
2. Navigate to the project root directory and install it by running the following command on the terminal:

   `$ ./mvnw clean install -DskipTests`

3. Setup Docker by logging into docker from the terminal.
4. Setup Kubernetes:

   `$ minikube start`

   `$ eval $(minikube docker-env)`

5. Setup project database in Kubernetes by navigating to the `k8s` directory and issue the following commands:

   `$ cd /k8s`  
   `$ kubectl apply -f mysql-configmap.yaml`  
   `$ kubectl apply -f mysql-root-credentials.yaml`  
   `$ kubectl apply -f mysql-credentials.yaml`  
   `$ kubectl apply -f mysql-deployment.yaml`  

   OPTIONAL: You can run the following commands to interact with MySQL:

   `$ kubectl run -it --rm --image=mysql:latest --restart=Never mysql-client -- mysql -h mysql -uroot -ptoor`

   The above command will create a `mysql-client` and present a mysql prompt in the terminal like:

   `$ mysql> `

6. Navigate back to the root directory where the `Dockerfile` is domiciled and build the application image using docker by running:

   `$ cd ..`  
   `$ docker build -t <your-dockerhub-username>/springboot-k8s-mysql:latest .`

7. Setup the main application by navigating again to the `k8s` folder and issue the following command in the terminal within k8s folder

   `$ kubectl apply -f deployment.yaml`

8. OPTIONAL: clean kubernetes workspace by running the following commands in that order:

   `$ kubectl delete deployments --all`  
   `$ kubectl delete services --all`  
   `$ kubectl delete pvc --all`  
   `$ kubectl delete pv --all`  
   `$ kubectl delete secrets --all`  
   `$ kubectl delete configmaps --all`  

9. You can also interact with Kubernetes pods using the following sample commands

   `$ kubectl get pods`  
   `$ kubectl logs pod-name`  
   `$ kubectl get events --sort-by=.metadata.creationTimestamp`

## Screenshots


![Running Kubernetes Pods](file:///home/maxwel/Pictures/Screenshots/Screenshot%20from%202023-10-24%2001-58-33.png?raw=true "Running Kubernetes Pods")
