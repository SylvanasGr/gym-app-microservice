IMAGE=gymapp
HOST_PORT=8000


build-img: gym-app.jar
	docker build -t ${IMAGE} .

gym-app.jar:
	./mvnw clean install

run:
	docker run -p ${HOST_PORT}:8080 ${IMAGE}