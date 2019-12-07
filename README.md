# GlobalLogic Api
> A Recruiting api from global logic

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [How to Use](#how-to-use)
* [Contact](#contact)

## General info
Users Api.

## Technologies
* Gradle
* Java
* Spring Boot
* JPA
* H2 Database

## Setup
This project contains a wrapper from Gradle, so you only need to clone and run:

- Linux
```shell script
$ ./gradlew bootRun
```

- Windows
```shell script
> gradlew.bat bootRun
```

_It runs on port 9090_

## Status
Project is: _in progress_

## How to Use
Api to add User
```
POST http://127.0.0.1:9090/bci/api/v1/user/
```
```json
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "1hUnte2r",
    "phones": [
        {
            "number": "12345678",
            "citycode": "1",
            "countrycode": "57"
        },
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```


## Contact
Created by [@lriverd](https://github.com/lriverd) - feel free to contact me!