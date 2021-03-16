 To access the application image running locally, you must match the EXPOSE port value in the Dockerfile to the first port on the run command.
 
1) Exposing the Port
	You generally do it by putting EXPOSE statement inside you docker file which you had already done. Now you need to do step 2.
	EXPOSE 9090
2) Publishing the Port
	Use Below Command to do that ( which maps the port of you host machine ( Docker Container ) to the client machine.
		docker run -p client_port:host_port imageName
	In our case, it would be :
		docker run -p 9090:8080 imageName
	Replace imageName with your Docker Image Name
	Then you can do :
		localhost:9090 