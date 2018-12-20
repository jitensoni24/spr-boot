##Kubernetes

Installation steps:
1. installing virtualbox : 
	sudo apt install virtualbox
	sudo apt install virtualbox-ext-pack
	sudo apt install virtualbox-qt


Minicube installation
    https://github.com/kubernetes/minikube

1. Error: minikube start : 
 - VT-x is disabled in the BIOS for both all CPU modes (VERR_VMX_MSR_ALL_VMX_DISABLED) 
 - some combinations of f8 f9 keys go to BIOS/computer settings, in securtiy and enable vtx

2. Error: E0625 16:42:23.409722    8099 start.go:299] Error restarting cluster:  
 - restarting kube-proxy: waiting for kube-proxy to be up for configmap update: timed out waiting for the condition
 - minikube delete 
 - minikube start


https://kubernetes.io/docs/tasks/tools/install-kubectl/

-	sudo apt-get update && sudo apt-get install -y apt-transport-https
-	curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -
-	sudo touch /etc/apt/sources.list.d/kubernetes.list 
-	echo "deb http://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list
-	sudo apt-get update
-	sudo apt-get install -y kubectl

-	kubectl cluster-info
-	kubectl cluster-info dump

https://kubernetes.io/docs/reference/kubectl/cheatsheet/



##### Kubernetes Switching context
	-	kubectl config location ~/.kube/config

	Edit this file to add the IMP-Test context, this was obtained from fluid cloud website.
 	-	https://fluidcloud-beta.vdc.sky/env/1a4160179/kubernetes/kubectl

 	-	To view the context use command 
    	kubectl config view -o json / yaml

 	-	To use the context use 
    	kubectl config use-context IMP-Test

#####Login Sky docker registry
Login to docker
    - docker login registry.fluidcloud.bskyb.com
    - Username: sky
    - Password: skypwd

Build the Image and tag it (if you want)
    $ docker build -t registry.fluidcloud.bskyb.com/<skyq>/tomcat8---bla-bla:v1 .

Push the image
    $ docker push registry.fluidcloud.bskyb.com/<skyq>/tomcat8--bla-bla:v1

push project images to registry:
    $ docker tag SOURCE_IMAGE[:TAG] registry.fluidcloud.bskyb.com/skyq/IMAGE[:TAG]

eg. pull command eg.
        docker pull registry.fluidcloud.bskyb.com/skyq/jit-nginx-app:1.0.0


### Login to Github (organisation - sky)
```
Login using smartgit
https://github.com/sky-uk/
uname: personal(jitensoni24) auth: code
pwd : personal
```

STEP 1:
Add docker and readme files in project. (tomcat with java-11 or tomcat, mysql with java-11)

STEP 2:
Run maven package (OR) deploy and push to Nexus for storage of jars and wars etc... (pushing to Nexus not mandatory)

STEP 3:
cd >> to project directory
Build the Image and tag it (if you want)
    $ docker build -t registry.fluidcloud.bskyb.com/<skyq>/IMAGE:VERSION<tag>


STEP 4: Login & Push the docker image to registry vdc sky (VM Harbour)
Login to docker
    docker login registry.fluidcloud.bskyb.com
    Username: sky
    Password: skypwd

Push the image
    $ docker push registry.fluidcloud.bskyb.com/<skyq>/IMAGE:VERSION

STEP 5:
    Manual deploy
    cd >> to skyq-helm-deployment directory:
        /home/sonijit/devenv/sts.3.9.4.workspace/skyq-helm-deployment
    run the install script:
        ./bin/install.sh local -a APPLICATION -e ENVIRONMENT -t TERRITORY



###### K8 monitor nodes
kubectl get nodes --no-headers | awk '{print $1}' | xargs -I {} sh -c 'echo {}; kubectl describe node {} | grep Allocated -A 5 | grep -ve Event -ve Allocated -ve percent -ve -- ; echo'



### HELM Deployments:

helm install --namespace <NAMESPACE> -f values/<VALUES_FILE> .

helm upgrade --namespace <NAMESPACE> -f values/<VALUES_FILE> . --recreate-pods

helm upgrade --namespace <NAMESPACE> -f values/gb-dev.yaml <RELEASE_NAME> . --recreate-pods

helm delete --namespace <NAMESPACE> --purge <RELEASE_NAME>


###Steps to prepare qms-api for dev-edge-gb environment
1. deleted all profiles
2. created profile directories with CreateProfileDirs.class
3. copied environment specific files (application.properities, persistence.properties, cacheconfig.properites etc)
    modified the mount paths
    modified the jndi names
4. updated environment related profiles -renames to dev-edge etc.. including @All



LINKS:

1. https://github.com/sky-uk/skyq-docker-images
2. https://github.com/sky-uk/skyq-kubernetes-playground

 

####Vault Login
```
vault login -method=ldap -path=ldap-hhe username=LDAP
vault {COMMAND} -tls-skip-verify -address=https://10.79.120.2:8200
```


 