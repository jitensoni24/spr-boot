# SPR-BOOT-EX 

#### Docker

##### Build the image
```
docker build --pull --no-cache -t spr-boot:<VERSION> .
```

##### Run the image
```
docker run --rm -d -p8080:8080 spr-boot:<VERSION>
```

##### Push the image
```
docker login --username USERNAME hub.docker.com
docker build --pull --no-cache  -t spr-boot:<VERSION> .
docker push hub.docker.com/sonijit/spr-boot:<VERSION>
```

##### Pull the image
```
docker login --username USERNAME hub.docker.com
docker pull hub.docker.com/sonijit/spr-boot:<VERSION>
```
