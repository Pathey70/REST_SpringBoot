# REST_SpringBoot

READ ME ..

You should have jre version 11 or higher installed.
This service uses 8083 port number so before running JAR file make sure that no other services are running on port 8083
To Run the application double click on CheggProject-0.0.2-SNAPSHOT.jar file.

Open Command Prompt/ Terminal

Run the following commands to test various functionalities of API


To add a User
	For adding Student
		curl -d '{"name":"value1", "email":"value2","type":"Student","schoolName":"ABC"}' -H "Content-Type: application/json" -X POST http://localhost:8083/user/
	For adding Professor
		curl -d '{"name":"value1", "email":"value2","type":"Professor","schoolName":"ABC","courseTaught":"XYZ"}' -H "Content-Type: application/json" -X POST http://localhost:8083/user/
Both the methods will return the ID of the object

To get List of all users
	curl localhost:8083/user/ 

To Delete a User
	curl -X "DELETE" http://localhost:8083/user/{id}    where id is the id of the Object you want to delete.

To update a User
	curl -d '{"name":"value1", "email":"value2","type":"Student","schoolName":"ABC1"}' -H "Content-Type: application/json" -X PUT  http://localhost:8083/user/{id}  where id is id of object you want to update

To get all Students in a School
	curl localhost:8083/find/students/{schoolName}   Where schoolName is the name of the school you want to get students

To get all Professors in a School
	curl localhost:8083/find/professors/{schoolName}

To get all Professors who taught a specific course 
	curl localhost:8083/find/professorscourse/{courseName} where courseName indicates the name of the course you want to search

To find a student
	 curl localhost:8083/find/student/{id} where id is the id of student you want to find

To find a professor
	 curl localhost:8083/find/professor/{id} where id is the id of professor you want to find


For the simplicity of Project & SetUp currently all the objects are stored in main memory but we can easily expand the project to include Database connectivity for permanent storage.



