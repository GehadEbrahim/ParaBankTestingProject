# Para Bank & Restful Booker Testing Project  

## 📌 Overview  
This project includes manual and automated testing for Para Bank (a web banking application) and Restful Booker (a hotel booking API).  
- Para Bank → Web UI testing using Selenium WebDriver.  
- Restful Booker → API testing using RestAssured/Postman.  
The goal is to ensure functionality, reliability, and system stability through structured test cases and scripts.  

## 🛠 Tools & Technologies  
- Selenium WebDriver + TestNG/JUnit → UI testing for Para Bank  
- RestAssured / Postman → API testing for Restful Booker  
- Extent Reports / Newman → Test reporting  

## 📂 Project Structure

/para-bank-restful-booker-testing

│── /manual-testing/           # Manual test cases

│── /automation/               # Automated testing scripts

│   │── /para-bank/            # Selenium-based UI tests

│   │── /restful-booker/       # API tests using RestAssured/Postman

│── /reports/                  # Test execution reports

│── /logs/                     # Execution logs

│── README.md                  # Project documentation

│── .gitignore                 # Ignore unnecessary files

│── requirements.txt           # Dependencies for Python-based tests

│── pom.xml                    # Maven dependencies for Java-based tests

## ✅ Test Scenarios  
### Para Bank (Web UI)
-  User Login & Logout  
-  Account Creation & Management  
-  Fund Transfers & Transactions  
-  Error Handling & Validations  

### Restful Booker (API)
-  Create a new booking (POST /booking)  
-  Retrieve booking details (GET /booking/{id})  
-  Update booking (PUT /booking/{id})  
-  Delete booking (DELETE /booking/{id})  

## 🚀 How to Run the Tests  
### 1️⃣ Automated UI Testing (Para Bank)  
1. Clone the repository:  
   `sh
   git clone https://github.com/GehadEbrahim/para-bank-restful-booker-testing.git

2. Navigate to the automation folder:

cd para-bank-restful-booker-testing/automation/para-bank


3. Run the test suite using Maven:

mvn test



2️⃣ API Testing (Restful Booker)

Using Postman: Import the provided collection and run the test cases.

Using RestAssured (Java): Execute the test scripts with:

mvn test -Dtest=RestfulBookerTests


📊 Reporting & Logs

All test execution reports will be available in the /reports/ folder.

Log files are stored in the /logs/ directory for debugging.


🤝 Contributors
-   Gehad Ebrahim
-   Aya Allah Emad
-   Rewan Waheed
-   Nada Gamal
-   Menna Hassan
