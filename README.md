# MiniBank
- An innovative fintech application designed to provide simple, accessible financial services to the unbanked population. In response to recent financial regulations that have paved the way for fully digital, fast, and less bureaucratic account opening, MiniBank aims to attract a large user base with its streamlined features.

## Features
### For Clients (Users)
- Account Opening: Easily open a new digital bank account.
- Fund Transfers: Seamlessly transfer funds from your MiniBank account to other MiniBank account holders.
- Loan Requests: Submit requests for small loans directly through the application.

### For Managers
- View Loan Applications: Managers can view all submitted loan requests.
- Approve/Reject Loans: Managers have the authority to approve or reject loan applications.


## Getting Started
To get the MiniBank application up and running on your local machine, follow these steps:

### Prerequisites
- Docker you can download in [here](https://www.docker.com/products/docker-desktop/) and choose a docker that is compatible to your OS

### Installation
1. Clone the repository:
   > git clone [https://github.com/Gabrieelgc2/MiniBank.git](https://github.com/Gabrieelgc2/MiniBank.git)

2. Accessing the directory:
   > cd MiniBank  

3. Start the application with Docker Compose:
   > docker-compose up -d

4. If you want to shutdown the application:
   > docker compose down
## Accessing the Application
- The Spring Boot application should be accessible at http://localhost:8081.
The MySQL database will be running on localhost:3306. You can use a tool like MySQL Workbench to connect.
## API Endpoints and Functionalities
This section details the core functionalities and their respective endpoints.

### 1 Requirement – User Registration (/create) - POST
- Any person can open an account by providing basic data: name, CPF, address, email, and password.
- CPF must be unique (no duplication allowed).
- For each registration, a sequential account number is created.
- New accounts start with a bonus balance of R$ 50,00 to attract new clients.
### 2 Requirement – Authentication (/login) - GET
- Once an account is created, the user must authenticate with their account number (sequentially created) and password.
- Managers can authenticate with the fixed account number "gerencia" and any fixed password; this user does not need to be actually registered in the database.
### 3 Requirement – Client: Account Balance and Transactions (/account/{accountNumber}/balance, /account/{accountNumber}/transactions) - GET
- After authentication, clients can view their account balance.
- It should also be possible to view transfers made and received.
### 4 Requirement – Client: Fund Transfer (/transferencias) - POST
- Clients can transfer funds to other MiniBank accounts, provided they have sufficient balance.
- Transfers should appear for the sending user as an "amount sent" and for the receiving user as an "amount received".
- Upon completion of the transfer, the new balance must be reflected for both users involved in the transaction.
### 5 Requirement – Client: Loan Request (/emprestimo) - POST
- The general public can request loans by providing the desired amount and reason.
### 6 Requirement – Manager: View Loan Applications (/verEmprestimo) - GET
- Managers can view all loan requests and their respective statuses (PENDING, ACCEPTED, REJECTED).
### 7 Requirement – Manager: Accept or Reject Loan Applications (/emprestimos/{id}/status) - PATCH
- Managers can modify the loan status to ACCEPTED or REJECTED.
- If the loan is accepted, the amount must be reflected in the account of the user who requested it.
## Technology Stack
- Backend: Spring Boot (Java)
- Database: MySQL
- Containerization: Docker, Docker Compose
#### Contributing
We welcome contributions to the MiniBank project! If you'd like to contribute, please feel free to fork the repository, make your changes, and submit a pull request.