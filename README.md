# Para Bank Testing Project  

## 📌 Overview  
This project includes manual and automated testing for Para Bank (a web banking application) 
- Para Bank → Web UI testing using Selenium WebDriver.  
The goal is to ensure functionality, reliability, and system stability through structured test cases and scripts.  

## 🛠 Tools & Technologies  
- Selenium WebDriver + TestNG → UI testing for Para Bank
  
- Extent Reports / Newman → Test reporting  

## 📂 Project Structure

/ParaBankTestingProject

│── /manual-testing/                              # Manual test cases
│── /Test Cases _ ParaBank/                       # The Test Cases
│── /automation/                                  # Automated testing scripts
│   │── /src/                                    
│   │──|── /main/   
│   │──|──│──/pages/                               # Selenium-based UI tests
│   │──|──│──/data/
            #data provider
│   │──|──│──/properties/
│   │──|── /test/  
│   │──|──│── /tests/                             # TestNG tests
│── /Bug Tracker/                                 # Test execution reports
│── README.md                                     # Project documentation
│── .gitignore                                    # Ignore unnecessary files
│── Requirements for parabank.txt           # Contains fancional , non-functional requirements , user storis and use cases

## ✅ Test Scenarios  
### Para Bank (Web UI)
-  User Login & Logout  
-  Account Creation & Management  
-  Fund Transfers & Transactions  
-  Error Handling & Validations  

## 🚀 How to Run the Tests:

1. Clone the repository:  
   `sh
   git clone https://github.com/GehadEbrahim/ParaBankTestingProject

2. Navigate to the automation folder:

cd ParaBankTestingProject/automation/src


3. Run the test suite using Maven:

mvn test



📊 Reporting

All test execution reports will be available in the /reports/ folder.


🤝 Contributors
-   Gehad Ebrahim
-   Menna Hassan
-   Rewan Waheed
-   Nada Gamal
-   Aya Allah Emad
-   Mariam Mohamed
