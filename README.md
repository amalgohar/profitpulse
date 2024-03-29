<p align="center">
  <img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/Bank%20Management%20System/src/icons/logo.jpg" alt="App Logo" width="180" height="180">
</p>

<h1 align="center">🤑 ProfitPulse: Bank Management System</h1>

A Java-based mock bank management system designed to simulate banking operations such as account creation, login, transactions, and more. This system connects to an SQL database using JDBC to store and retrieve user data securely. 

This system utilizes JFrame, a Java GUI toolkit, to create interactive user interfaces for seamless interaction with the application. Additionally, it connects to an SQL database using JDBC to store and retrieve user data securely. Through the combination of JFrame for the frontend and JDBC for backend database interaction, users can experience a comprehensive banking experience within the application.

# 🍀 Features
* **User Authentication:** Users can log in securely using their card number and PIN.
* **Account Management:** Account holders can perform various transactions including deposits, withdrawals, fast cash, changing pin, balance inquiries, and recent transactions.
* **Multi-step Signup Process:** New users can sign up for an account by providing personal and additional details through a three-step form.

# 🚦 Getting Started
1. Clone the repository to your local machine.
2. Set up an SQL database and update the connection details in **Connection.java**. Replace the designated space in the line below with your SQL password:
   ```java
   c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "PUT PASSWORD HERE");
   ```
4. Set up an SQL database and create the necessary tables. (Below in the next section are the SQL commands to create the required tables).
5. Compile and run the Java files to start the ProfitPulse bank management system.

## 📗 SQL Commands
* Create the database.
```sql
CREATE DATABASE bankmanagementsystem;
```

* Create the **login** table.
 ```sql
CREATE TABLE login (
    formNo VARCHAR(50),
    cardNumber VARCHAR(20),
    pinNumber VARCHAR(10)
);
```

* Create the **signup** table for storing user personal details.
 ```sql
CREATE TABLE signup (
    formNo VARCHAR(10),
    name VARCHAR(100),
    dob DATE,
    gender VARCHAR(20),
    email VARCHAR(100),
    maritalStatus VARCHAR(20),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10)
);
```

* Create the **signuptwo** table for storing additional user details.
 ```sql
CREATE TABLE signuptwo (
    formNo VARCHAR(10),
    citizenship VARCHAR(50),
    race VARCHAR(50),
    income VARCHAR(50),
    occupation VARCHAR(50),
    ssn VARCHAR(20),
    seniorCitizen VARCHAR(3),
    driversLicense VARCHAR(20),
    existingAccount VARCHAR(3)
);
```

* Create the **signupthree** table for storing additional account details.
```sql
CREATE TABLE signupthree (
    formNo VARCHAR(50),
    accountType VARCHAR(50),
    cardNumber VARCHAR(20),
    pinNumber VARCHAR(10),
    services VARCHAR(255)
);
```

* Create the **bank** table structure for recording transactions.
```sql
CREATE TABLE bank (
    pinNumber VARCHAR(10),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);
```

# 🧩 Dependencies
* Java Development Kit (JDK)
* SQL database (MySQL)
* JDBC driver for your chosen SQL database

# 🔋 Demo
1. Sign-Up: Page 1. 
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/signupone.jpg" alt="Account Creation - Page 1" width="500">

2. Sign-Up: Page 2. 
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/signuptwo.jpg" alt="Account Creation - Page 2" width="500">

3. Sign-Up: Page 3.  
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/signupthree.jpg" alt="Account Creation - Page 3" width="500">

4. Login.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/login.jpg" alt="Login" width="500">

5. Main ATM screen after signing in.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/mainscreen.jpg" alt="Main Screen" width="500">

6. Deposit screen.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/deposit.jpg" alt="Deposit" width="500">

7. Withdrawal screen.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/withdrawal.jpg" alt="Withdrawal" width="500">

8. Fast cash screen.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/fastcash.jpg" alt="Fast Cash" width="500">

9. Recent transactions screen.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/recenttransactions.jpg" alt="Recent Transaction" width="500">

10. Change PIN screen.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/changepin.jpg" alt="Change PIN" width="500">

11. Balance inquiry screen.
<img src="https://raw.githubusercontent.com/amalgohar/profitpulse/main/demo/balanceinquiry.jpg" alt="Balance Inquiry" width="500">
