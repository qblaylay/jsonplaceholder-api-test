# {JSON}Placeholder - API Automation

Functional automation tests for https://jsonplaceholder.typicode.com/ with using REST Assured

[![JSONPlaceholder](https://lh3.googleusercontent.com/-HKQHzQ_DLzY/X-OGojGBS-I/AAAAAAAAKgk/iDDoWni7ookGfpBrxRJ4kZ-_ely_qE1wgCLcBGAsYHQ/image.png)](https://jsonplaceholder.typicode.com)

[![CircleCI](https://circleci.com/gh/qblaylay/jsonplaceholder-api-test.svg?style=shield)](https://circleci.com/gh/qblaylay/jsonplaceholder-api-test)

## Software requirements

- Docker stable release (for run tests from a docker container)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Assumptions](#assumptions)
* [Setup](#setup)
* [How To Use](#howtouse)
* [Integration with Circle CI](#integrationwithcircleci)
* [Report](#report)
* [Contact](#contact)

## General info
Generating a sample of project with using the REST Assured for the API testing.

The tests are written against a black box. They cover all resources (user, post, comment) and actions on them (get, filter). 

The tests are written using the following test design techniques: Equivalence Partitioning, Use Case Testing, Explanatory Testing.

Information about available resources is taken from https://jsonplaceholder.typicode.com/.

The test also include the email verification based on the RFC 5322 format. The regex characters permitted by RFC 5322.

## Technologies
Project uses a number of open source projects to work properly:

* [REST Assured] - Testing and validating REST services
* [TestNG] - TestNG is a testing framework
* [Allure] - Allure is a type of report tool
* Java


## Assumptions
The project is prepared based on the following test flow. 
The additional tests are added such as attributes of each resources on the response part (users,posts,comments) invalid cases of 
resources, the response of wrong request with path parameters.

1. Search for the user with username “D​elphine”​ .
2. Search the posts written by the above user. 
3. For each post, fetch the comments and validate if the emails in the
comment section are in the proper format.

## Setup
First, clone to project to your local environment.
```sh
$ git clone https://github.com/qblaylay/jsonplaceholder-api-test.git
```

## How To Use
Assume that you satisfy the software requirements.

- Go to the folder that is cloned on your local machine

If you want to execute on `docker`, you need to follow below steps,
- Build the docker file
    ````sh 
    docker build -f Dockerfile -t jsonpath .
    ````

- Run the specific image and Open the report on your local browser
    ````sh 
    docker run -i -p 5050:5050 jsonpath
    ````
  Open the link to display the reports on your browser `http://localhost:5050/allure-docker-service/projects/default/reports/latest/index.html`

## Integrate with Circle CI
The repository is configured with Circle CI to execute the tests in every each commit.
The configuration file is exist on `.circle/config.yaml` .


On Circle CI Tool,

   - Go the CircleCI dashboard
   - Select the last build
   - Select the Tests tab - It displays the how many tests are passed or failed totally    
   - Select the Artifacts tab and click the `Report/Allure/index.html` file
    The browser of Allure report is opened and `test coverage` can be displayed properly.
    
   *The integrated pipeline of this project on CircleCI Tool - https://circleci.com/gh/qblaylay/jsonplaceholder-api-test 

## Contact
Created by [@kubilayozcan](idle.kubi@gmail.com/) - feel free to contact!
    
[TestNG]: <https://testng.org/doc/](https://testng.org/doc/>
[REST Assured]: <http://rest-assured.io/](http://rest-assured.io/>
[Allure]: <https://docs.qameta.io/allure/#_about>
