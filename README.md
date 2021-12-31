# Ip Geolocation
[![License: MPL 2.0](https://img.shields.io/badge/License-MPL_2.0-brightgreen.svg)](https://opensource.org/licenses/MPL-2.0)
[![GitHub version](https://badge.fury.io/gh/xrusu%2Fip-geolocation.svg)](https://badge.fury.io/gh/xrusu%2Fip-geolocation)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/xrusu/ip-geolocation/graphs/commit-activity)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)

API for getting geolocation information about an IP address using Java and Spring Boot. This is useful for getting information about a user's location, or for getting information about a user's IP address, from the server, without using GPS on the client.

## Quick Start
To build the project, go to the root folder of the project and:
- run `./gradlew build`
- go to build/libs
- run `java -jar ipgeolocation-0.0.1-SNAPSHOT.jar`

The API will be available at http://localhost:8080/api/get/<ip>, where `<ip>` is the IP address you want to geolocate.

To quickly test the API, you can access:
[Swagger](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/).


## Please note
This API is based on [geoplugin.com](https://www.geoplugin.com/) and is just a wrapper with caching of their api. This is just an example of how to use their API in a Spring Boot project.

## Others
For other projects / cool stuff, follow me on
[GitHub](https://github.com/xrusu)