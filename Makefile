IMAGE=gymapp
IMGTAR=${IMAGE}.tar
HOST_PORT=8000
USER=
HOST=
DEST=


build-img: gym-app.jar
	docker build -t ${IMAGE} .
	docker save -o ${IMGTAR} ${IMAGE}
	chmod a+rwx ${IMGTAR}

send-img:
	rsync ${IMGTAR} ${USER}@${HOST}:${DEST}

connect:
	ssh ${USER}@${HOST}

deploy:
	ssh ${USER}@${HOST} 'sudo docker load < ${DEST}${IMGTAR} && \
	docker stop app || true && docker rm app || true && \
	docker run --name app -dp ${HOST_PORT}:8080 ${IMAGE}'

run:
	docker run -p ${HOST_PORT}:8080 ${IMAGE}

gym-app.jar:
	./mvnw clean install
