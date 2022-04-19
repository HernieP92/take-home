# Take home task
This project contains the solution implemented by me -Hernan Perez- For the Take Home Task

## Overview
+ IDE used: IntelliJ Ultimate 2021.1.3
+ Language: Java
+ Dependencies manager: Gradle
+ Testing FW: TestNG
+ FrontEnd Automation FW: Selenide
+ BackEnd Services tested with: Rest assured

Probably the MVP for this automation can be achieved with a simpler solution, but the intention 
was also built a complete and scalable solution/framework, for this reason in this "PoC" im not complaining
Side scenarios like: what happen if i send in quantity param of url for GET request instead a number i send
a letter? or For the frontEnd automation the path with suggested result (Used in this solution) and
just pressing enter and validating the other side page?.....

## Project Layers
This project implements BDD tests with 5 main layers. Its main responsibility are:

1 Features: Contains the tests wrote using gherkin.

2 Steps: Connects the gherkin tests with its java implementation.

3 Definitions: Implements the algorithms to execute the steps.

4 Pages: Allows interaction with page elements exposing business-oriented actions.

5 Adapters: Allow to create service consumptions in scalable way

It's common to find the 2nd and 3rd as only one layer, but personally I prefer this project implementation because allow reusing a lot of code oriented to the domain and simplify the maintenance. 

## Running project

- The project can be runned by : gradlew test order in command line for windows or for linux use the gradlew.bat

The project can be runned by executing TestRunnerTask class, this class will trigger all the features,
for this mvp i leave just 1 test runner but in real enviroments we need to provide more than 1 test runner to split
responsabilities between front and back validations.

## Notes
- The Front end automation can be flaky, because in this deliverable, maybe the mapping phase can be more stylish than just
build some xpaths, for the complexity of the nested fields i preffer using this according to the time to send this task.

- Selenide speed is greater than native Selenium, so, probably for this ocation the test will need to be executed again
  (Sorry)