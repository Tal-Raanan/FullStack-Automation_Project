## **Full Stack Test Automation Final Project**
[Short Video - Demonstration](https://vimeo.com/658418465)
### **_This project created to demonstrate my knowledge and skills in Automation Testing._**
***
### _About_
The project demonstates a smart automation infrastructure. It is built in hierarchy order of modules. The modules contain number of classes with methods.
There are main/common/helpers/actions/page_object modules.
In this way, the tests can be created in very simple way with a minimum lines of code.
Also the infrastructure allows to work with differend kinds of applications.
**Big advantage of the infrastructure is that it can be easily maintained!**

### _Project Overview_

The project is an example of infrastructure for automation testing of different kinds of applications:
* Web based application
* Mobile application
* Web API
* Electron application
* Desktop application

### **_Infrastructure project includes using of:_**
* Page object design pattern
* Project layers (Extensions, Work Flows, Test Cases etc.)
* Support of different clients and browsers
* Failure mechanism
* Common functionality
* External files support
* Reporting system (including screenshots)
* Visual testing
* DB support
* CI support  

***

### _List of applications were used in this project:_
* Grafana webpage - Web based application
* Mortgage calculator - Mobile application
* Grafana API - Web API
* Electron application (Todolist)
* Windows calculator - Desktop application

### _Tools & Frameworks used in the project:_
* TestNG - Testing framework
* Listeners - Interface used to generate logs and customize the TestNG reports
* MySQL Free Online DB - Used for login to Grafana web page
* [Jenkins](https://www.jenkins.io/) - For tests execution
* REST Assured - For API testing
* [Allure Reports](http://allure.qatools.ru/) - As the main reporting system:

![This is an image](/allure-results/Report-Failure.png)


### Tests Execution:
> Each of the applications has a few tests for demonstration purpose.
These tests can be developed very simply, thanks to a well stabled infrastructure.
[(Sanity Tests)](https://github.com/Tal-Raanan/FullStack-Automation_Project/tree/master/src/test/java/sanity)
### _Known Issues:_
Sometimes, a situation of conflict between dependencies may be arised, due to the use of several applications in the same methods.
Hence, the project is for DEMO purpose only. In production it should be divided into several projects.
