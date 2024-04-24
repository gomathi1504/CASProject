**Project Name: GSD**
 
 
# Overview
This project aims to automate the OneCognizant portal  using Selenium WebDriver. The automation process involves navigating through the Be.Cognizant portal, extracting user information, navigating to GSD page,  and fetching tooltips.
 
## Libraries and Dependencies
- **Maven Repository:** Maven 4.0.0
- **Apache POI:** 4.1.2
- **TestNG:** 7.9.0
- **Extent Report:** 5.1.1
- **Selenium WebDriver:** 4.18.1
- **Loggers:** 3.0.0
 
## Automation Flow
 
1)Navigate to Be. Cognizant Website and capture the user information.

2)Click One Cognizant application.

3)Search GSD in One Cognizant and click on Live Support - GSD application from search results.

4)Validate the welcome message of GSD Application.

5)Validate the default country and language.

6)Get all the drop-down details from Language drop down.

7)Get all the details present in the GSD page with tooltips and by changing Location from drop down (for three random Locations).
 
## Libraries Explanation
- **Maven Repository:** Used for project management and dependency resolution.
- **Apache POI:** Handles Excel operations for data-driven testing.
- **TestNG:** Facilitates test case organization and execution.
- **TestNG Report:** Generates comprehensive test reports.
- **Selenium WebDriver:** Automates browser interactions.
- **Loggers:** Facilitates logging for better debugging.
 
## Screenshots
Screenshots are captured at relevant steps for documentation and analysis.
 
## How to Run
1) **Open Eclipse IDE:**
   - Launch Eclipse IDE on your machine.
 
2) **Import Project:**
   - Select `File` -> `Import` from the menu.
   - Choose `Existing Maven Projects` and click `Next`.
   - Browse to the directory where you cloned the repository and select the project.
 
3) **Update Maven Project:**
   - Right-click on the project in the Project Explorer.
   - Choose `Maven` -> `Update Project`.
   - Click `OK` to update dependencies.
 
4) **Set Up Configuration:**
   - Open the `src/test/resources/config.properties` file.
   - Update any configuration parameters like browser type, URLs, etc., as needed.
 
5) **Run Test Suite:**
   - Locate the test suite file (`testng.xml`)
   - Right-click on the file and choose `Run As` -> `TestNG Suite`.
 
6) **View Reports:**
   - After execution, open the `test-output` folder.
   - Find the TestNG file (`index.html`) for detailed test case reports.
 
## Reporting
1) **Locate Test Reports:**
   - After the execution, navigate to the `test-output` folder in the project directory.
 
2) **Open Extent Report:**
   - Inside the `test-output` folder, find the Extent Report HTML file named `index.html`.
 
3) **View Test Reports:**
   - Open the `index.html` file using any web browser.
   - This report provides a detailed overview of test executions, including passed and failed tests, test duration, and any exceptions encountered.
 
4) **Screenshots and Logs:**
   - screenshots captured during test execution and relevant logs for test cases.
 
5) **Analyze Results:**
   - Utilize the visual representation in the TestNG Report to quickly identify test status and any issues encountered during the test run.
 
## Contributors
- **Gomathi S   2318582**
- **Vimal Raja Gopal M   2318630**
- **Aswath Subramanian  2318646**
- **Bannela Raghuraj   2318584**
 
## Future Enhancements
 
- **Enhancement 1: Enhanced Logging**
   - Description: Introduce more detailed logging to aid in debugging and analysis of test results.
   - Timeline: Considered for the upcoming sprint.
 
- **Enhancement 2: Test Data Generation**
   - Description: Develop a module for generating test data dynamically to increase test coverage.
   - Timeline: Long-term goal for improved data-driven testing.
 
- **Enhancement 3: Parallel Execution**
   - Description: Enable parallel execution of tests to improve overall test suite efficiency.
   - Timeline: Investigating implementation feasibility.
 
- **Enhancement 4: Integration with CI/CD**
   - Description: Integrate the automation script with popular CI/CD platforms for continuous testing.
   - Timeline: Targeting a future release for streamlined workflows.