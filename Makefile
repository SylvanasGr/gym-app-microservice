IMAGE=gymapp
HOST_PORT=8000


build-img:
	docker build -t ${IMAGE} .

run:
	docker run -p ${HOST_PORT}:8080 ${IMAGE}