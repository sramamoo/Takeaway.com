# Takeaway.com
Codechallenge-automation

The project is built using a customized frame work which is loosely based on the page object model. The project has four packages.
Namely,
com.takeaway.codechallenge.core
com.takeaway.codechallenge.pages
com.takeaway.codechallenge.tests
com.takeaway.codechallenge.utils

Core package - It contains the commonly used selenium methods
pages package - It contains the methods related to the various pages of the application
tests package - It contains the tests to be carried on.
		UITest - contains the UI tests
		RestAPITest - contains the backend tests or the API tests given in the task sheet
		
Utils package - It contains various utility classes like seleniumUtil, RestUtils, ObjectRepository, JSONUtils and Constants.

The locator used in this project is xpath as it is can be used get the element by using the css attributes and also other locators


Requirement Java JDK 1.7

Import the project as a maven project in Eclipse and make sure the maven dependencies are downloaded correctly.

To Run the tests:

Run TestNG.xml file as testNG test.


