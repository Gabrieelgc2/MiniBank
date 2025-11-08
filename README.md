# 🏦 MiniBank

## ✨ Innovation and Financial Accessibility

**MiniBank** is an innovative fintech application designed to provide **simple, accessible financial services** to the unbanked population. Capitalizing on recent financial regulations that have paved the way for fully digital, fast, and less bureaucratic account opening, MiniBank aims to attract a wide user base with its streamlined features.

  * **[Portuguese (Brasil) Version](https://www.google.com/search?q=READMEptbr.md)**

-----

## 🚀 Core Features

| Category | Feature | Description |
| :--- | :--- | :--- |
| **Clients** | **Account Opening** | Quick and easy process to get a new digital bank account. |
| **Clients** | **Fund Transfers** | Seamlessly send funds to other MiniBank account holders. |
| **Clients** | **Loan Request** | Submit requests for small loans directly through the application. |
| **Managers** | **View Applications** | Access all submitted loan requests and their status. |
| **Managers** | **Approve/Reject** | Authority to modify the status of a loan application. |

-----

## 🛠️ Getting Started Guide

Follow the steps below to get the MiniBank application up and running on your local machine.

### 📋 Prerequisites

Ensure you have **Docker** installed.

  * **Docker Desktop:** You can download it [here](https://www.docker.com/products/docker-desktop/) and choose the version compatible with your OS.

### ⚙️ Installation and Execution

1.  **Clone the repository:**
    ```bash
    > git clone https://github.com/Gabrieelgc2/MiniBank.git
    ```
2.  **Access the directory:**
    ```bash
    > cd MiniBank
    ```
3.  **Build and start the application in the background (detached mode):**
    ```bash
    > docker-compose up --build -d
    ```
4.  **To follow logs and keep the application in the foreground (optional):**
    ```bash
    > docker-compose up
    ```
5.  **To shut down the application and remove containers:**
    ```bash
    > docker compose down
    ```

### 🌐 Accessing the Application

The Spring Boot application should be accessible at:
**`http://localhost:8081`**

-----

## 🗃️ Accessing the Database (MySQL)

To inspect the database directly:

1.  Check the names of the running containers:
    ```bash
    > docker ps
    ```
    (The database container name is usually `minibank-db-1`).
2.  Access the database container shell:
    ```bash
    > docker exec -it [database container name, e.g., minibank-db-1] bash
    ```
3.  Enter the MySQL client (the password is `casa123`):
    ```bash
    > mysql -u root -p
    ```
4.  Useful commands:
    ```sql
    mysql> SHOW DATABASES;
    mysql> USE pitangdb;
    mysql> SHOW TABLES;
    mysql> SELECT * FROM [table name]\G;
    ```

-----

## 📊 API Endpoints and Detailed Functionalities

This section details the core functionalities and their respective endpoints.

### 1\. User Registration (`/create`) - `POST` 📝

  * Any person can open an account by providing: **name, CPF, address, email, and password.**
  * The **CPF must be unique** (no duplication allowed).
  * A **sequential account number** is created for each new registration.
  * **Bonus:** New accounts start with a bonus balance of **R$ 50.00** to attract new clients.

**Example Body**:

```json
{
  "name" : "Teste1",
  "cpf" : "46326463120",
  "email" : "rodrigo.pereira@example.com",
  "address" : "Test Street, 123",
  "password" : "securePassword123"
}
```

### 2\. Authentication (`/login`) - `GET` 🔑

  * Clients authenticate with their **account number** and **password**.
  * **Managers** authenticate using the fixed account number **`manager`** and the fixed password **`password`** (this user does not need to be registered in the database).

**Example Credentials:**

| User | Account/CPF | Password |
| :--- | :--- | :--- |
| **Client** | 46326463120 | teste2 |
| **Manager** | manager | password |

### 3\. Client: Account Balance and Transactions (`/account/{id}/balance`, `seeTransactions/numberAccount`) - `GET` 💰

  * After authentication, clients can view their **current account balance**.
  * It is also possible to view a **statement** of transfers made and received.

### 4\. Client: Fund Transfer (`/transfer`) - `POST` ➡️

  * Clients can transfer funds to **other MiniBank accounts**, provided they have sufficient balance.
  * The transaction should be recorded as "amount sent" for the sender and "amount received" for the recipient.
  * The new balance must be reflected for both users after completion.

**Example Body**:

```json
{
  "sourceAccount" : 207501,
  "destinationAccount" : 948937,
  "value" : 10
}
```

### 5\. Client: Loan Request (`/loan`) - `POST` 💸

  * The general public can request loans by providing the **desired amount** and the **reason**.

**Example Body**:

```json
{
  "value" : 400,
  "reason" : "Emergency house repair"
}
```

### 6\. Manager: View Loan Applications (`/checkLoan`) - `GET` 📋

  * Managers can view **all** loan requests and their respective statuses (PENDING, ACCEPTED, REJECTED).

### 7\. Manager: Accept or Reject Loan Applications (`/loan/{id}/status`) - `PATCH` ✅❌

  * Managers can modify the loan status to **`APPROVED`** or **`REJECTED`**.
  * If the loan is **accepted**, the amount must be **credited** to the account of the requesting user.

**Example Body**:

```json
{
  "status" : "APPROVED"
}
```

-----

## 💻 Technology Stack

  * **Backend:** **Spring Boot (Java)**
  * **Database:** **MySQL**
  * **Containerization:** **Docker, Docker Compose**
  * **Cloud Computing:** **AWS**

-----

## 🤝 Contributing

We welcome contributions to the MiniBank project\! If you'd like to contribute, please feel free to **fork** the repository, implement your changes, and submit a **Pull Request**.
