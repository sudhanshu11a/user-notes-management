# User Notes management Application

This is RESTful APIs for accessing user's note. 


# Requirement 

Build a RESTful API for a “notes” application using Spring Boot. Use MySql as your database to store the notes. Use a multilayered architecture.

Git:
Please use Git as version control. Create a new project in your own GitHub account (if you don’t have an account, create one at github.com) and push the code to it. It is extremely important to commit often so we can see the history of the commits. We are going to judge the project by not only the end result, but also the history of the commits. Projects with only 2-3 commits will be rejected.

Domain objects:
User:
A user in the system. It contains the following fields:
- Email: Non blank, valid email address, unique
- Password: Non blank, at least 8 characters
- Create Time
- Last Update Time

Note:
A note in the system. Notes are associated with Users. A user can have many notes. A note has the following fields:
- Title: Non blank, max 50 characters long
- Note: max 1000 long
- Create Time
- Last Update Time

RESTful API:
Design and build a RESTful API to allow CRUD operations on notes. Support JSON for requests and responses. Note access should be restricted to the owner of the note.

No need to build a RESTful API for user. You can insert a few default users into the database using SQL.

Authentication:
Use Basic HTTP Authentication.

Demonstration:
Provide cURL commands to demonstrate the APIs

Bonus Points:
Demonstrate concepts of OO design and design patterns
Use of Dependency Injection
Use correct HTTP methods when building the API
Use of an ORM
Use OAuth 2.0 Bearer Tokens for authentication

## Getting Started

This is a POC application on demonstrating the solution of #Requirement

Please note that "Develop" branch contains the requirement code with HTTP basic authentication. However, for Use OAuth 2.0 Bearer Tokens for authentication, a separate feature branch has been created.
 

## Prerequisites

* Java 8 or higher : https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* MySQL server version 5 or higher:
MySQL server: https://dev.mysql.com/downloads/mysql/

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Deployment
Following are the three steps to run the application:r
1) import sql :
Import the sql in the mySQL server to create the database, tables and inserting the pre-defined users in the db. 
Location of the sql file: /user-notes-management/src/main/resources/db/import.sql

2) Update database credentials: 
Please update credentials of database in the application.properties (/user-notes-management/src/main/resources/application.properties)

3) Run Spring Boot Application using
	* Java CLI
	```
		mvn package && java -jar target/user-notes-management-0.0.1-SNAPSHOT.jar
	```

	* IDE (Eclipse/IntelliJ)
		Its much easier to run the Spring Boot app in eclipse. Select the project, Right Click and, move to Run As and click on Spring Boot App. Again, remember you need to select the project to get this option, not the pom file.

## Default Users
For convenience, following default users has been created through import.sql in the db for authenticating and testing REST APTs:

1) Sudhanshu
```
Username/email: sudhanshu11a@gmail.com
password: sudhanshu
```

2) Drew
```
Username/email: drew@gotprint.com
password: drew
```

3) Prabhu
```
Username/email: prabhu@gotprint.com
password: prabhu
```

## REST APIs 

Following are the REST API for performing CRUD operation on Note resource:

### Creating new note
POST 
/api/v1/secure/user/notes 
saveUserNote
```
curl -X POST "http://localhost:8085/api/v1/secure/user/notes?note=First%20Note%20Description&title=First%20Note%20" -H "accept: */*" --user sudhanshu11a@gmail.com:sudhanshu
```

### Getting all user notes details
GET 
/api/v1/secure/user/notes
getUserNotes
````
curl -X GET "http://localhost:8085/api/v1/secure/user/notes" -H "accept: */*" --user sudhanshu11a@gmail.com:sudhanshu
````


### Getting note details by note id 
GET
/api/v1/secure/user/notes/{id}
getUserNotedetails
```
curl -X GET "http://localhost:8085/api/v1/secure/user/notes/1" -H "accept: */*" --user sudhanshu11a@gmail.com:sudhanshu
```
### Updating note by note id
PUT
/api/v1/secure/user/notes/{id}
updateUserNote
```
curl -X PUT "http://localhost:8085/api/v1/secure/user/notes/2?note=updated%20Note%20Content&title=updated%20Note%20Title%20" -H "accept: */*" --user sudhanshu11a@gmail.com:sudhanshu
```
### Deleting note by note id
DELETE
/api/v1/secure/user/notes/{id}
deleteUserNote
```
curl -X DELETE "http://localhost:8085/api/v1/secure/user/notes/1" -H "accept: */*" --user sudhanshu11a@gmail.com:sudhanshu  
```

For convenience, we may use the following URL for accessing all the REST APIs of the application using the following URL: 
```
http://localhost:8085/swagger-ui.html
```
## Pending  
Following can be enhanced in the application: 
* Securing application from attacks ( eg. XSS attack, )
* JUNIT Cases
* Multi-module architecture for more scalability
* Stronger logging

## Authors

**Sudhanshu Sharma** - [sudhanshu11a](https://github.com/sudhanshu11a)


## Acknowledgments


