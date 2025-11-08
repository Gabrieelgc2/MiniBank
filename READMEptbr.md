# 🏦 MiniBank

## ✨ Inovação e Acessibilidade Financeira

O **MiniBank** é uma aplicação fintech inovadora, desenhada para fornecer **serviços financeiros simples e acessíveis** à população desbancarizada. Aproveitando as recentes regulamentações financeiras que facilitaram a abertura de contas totalmente digitais, rápidas e menos burocráticas, o MiniBank visa atrair uma ampla base de usuários com suas funcionalidades otimizadas.

  * **[Versão em Português (Brasil)](https://www.google.com/search?q=READMEptbr.md)**

-----

## 🚀 Funcionalidades Principais

| Categoria | Funcionalidade | Descrição |
| :--- | :--- | :--- |
| **Clientes** | **Abertura de Conta** | Processo fácil e rápido para obter uma conta bancária digital. |
| **Clientes** | **Transferências** | Envio de fundos sem complicações para outros titulares de contas MiniBank. |
| **Clientes** | **Solicitação de Empréstimo** | Envio direto de pedidos de pequenos empréstimos pelo aplicativo. |
| **Gestores** | **Visualizar Pedidos** | Acesso a todos os pedidos de empréstimo submetidos. |
| **Gestores** | **Aprovar/Rejeitar** | Autoridade para modificar o status de um pedido de empréstimo. |

-----

## 🛠️ Guia de Inicialização

Siga os passos abaixo para colocar a aplicação MiniBank em funcionamento na sua máquina local.

### 📋 Pré-requisitos

Certifique-se de ter o **Docker** instalado.

  * **Docker Desktop:** Você pode fazer o download [aqui](https://www.docker.com/products/docker-desktop/) e escolher a versão compatível com seu sistema operacional.

### ⚙️ Instalação e Execução

1.  **Clone o repositório:**
    ```bash
    > git clone https://github.com/Gabrieelgc2/MiniBank.git
    ```
2.  **Acesse o diretório:**
    ```bash
    > cd MiniBank
    ```
3.  **Construa e inicie a aplicação em segundo plano (modo *detached*):**
    ```bash
    > docker-compose up --build -d
    ```
4.  **Para acompanhar os logs e manter a aplicação em primeiro plano (opcional):**
    ```bash
    > docker-compose up
    ```
5.  **Para desligar a aplicação e remover os contêineres:**
    ```bash
    > docker compose down
    ```

### 🌐 Acesso à Aplicação

A aplicação Spring Boot estará acessível em:
**`http://localhost:8081`**

-----

## 🗃️ Acessando o Banco de Dados (MySQL)

Para inspecionar o banco de dados diretamente:

1.  Verifique o nome dos contêineres em execução:
    ```bash
    > docker ps
    ```
    (O nome do contêiner do banco de dados geralmente é `minibank-db-1`).
2.  Acesse o *shell* do contêiner do banco de dados:
    ```bash
    > docker exec -it [nome do banco de dados, e.g., minibank-db-1] bash
    ```
3.  Entre no cliente MySQL (a senha é `casa123`):
    ```bash
    > mysql -u root -p
    ```
4.  Comandos úteis:
    ```sql
    mysql> SHOW DATABASES;
    mysql> USE pitangdb;
    mysql> SHOW TABLES;
    mysql> SELECT * FROM [nome da tabela]\G;
    ```

-----

## 📊 Endpoints da API e Funcionalidades Detalhadas

Esta seção detalha as funcionalidades essenciais e seus respectivos endpoints.

### 1\. Cadastro de Usuário (`/create`) - `POST` 📝

  * Qualquer pessoa pode abrir uma conta fornecendo: **nome, CPF, endereço, email e senha.**
  * O **CPF deve ser único** (não permite duplicação).
  * Um **número de conta sequencial** é gerado para cada novo cadastro.
  * **Bônus:** Novas contas iniciam com um saldo de **R$ 50,00** para atrair novos clientes.

**Exemplo de *Body***:

```json
{
  "name" : "Teste1",
  "cpf" : "46326463120",
  "email" : "rodrigo.pereira@exemplo.com",
  "address" : "Rua Teste, 123",
  "password" : "senhaSegura123"
}
```

### 2\. Autenticação (`/login`) - `GET` 🔑

  * Clientes autenticam com o **número de conta** e **senha**.
  * **Gestores** autenticam usando o número de conta fixo **`gerencia`** e a senha **`password`** (este usuário não precisa estar cadastrado no banco de dados).

**Exemplo de Credenciais:**

| Usuário | Conta/CPF | Senha |
| :--- | :--- | :--- |
| **Cliente** | 46326463120 | teste2 |
| **Gestor** | manager | password |

### 3\. Cliente: Saldo e Transações (`/account/{id}/balance`, `seeTransactions/numberAccount`) - `GET` 💰

  * Após a autenticação, clientes podem visualizar seu **saldo atual**.
  * Também é possível ver um **extrato** de transferências realizadas e recebidas.

### 4\. Cliente: Transferência de Fundos (`/transfer`) - `POST` ➡️

  * Clientes podem transferir fundos para **outras contas MiniBank**, desde que tenham saldo suficiente.
  * A transação deve ser registrada como "valor enviado" para o remetente e "valor recebido" para o destinatário.
  * O novo saldo deve ser refletido para ambos os usuários após a conclusão.

**Exemplo de *Body***:

```json
{
  "sourceAccount" : 207501,
  "destinationAccount" : 948937,
  "value" : 10
}
```

### 5\. Cliente: Solicitação de Empréstimo (`/loan`) - `POST` 💸

  * O público geral pode solicitar empréstimos informando o **valor desejado** e o **motivo**.

**Exemplo de *Body***:

```json
{
  "value" : 400,
  "reason" : "Reforma de emergência na casa"
}
```

### 6\. Gestor: Visualizar Pedidos de Empréstimo (`/checkLoan`) - `GET` 📋

  * Gestores podem visualizar **todos** os pedidos de empréstimo e seus respectivos *status* (PENDING, ACCEPTED, REJECTED).

### 7\. Gestor: Aceitar ou Rejeitar Empréstimo (`/loan/{id}/status`) - `PATCH` ✅❌

  * Gestores podem modificar o *status* do empréstimo para **`APPROVED`** ou **`REJECTED`**.
  * Se o empréstimo for **aceito**, o valor deve ser **adicionado** à conta do usuário solicitante.

**Exemplo de *Body***:

```json
{
  "status" : "APPROVED"
}
```

-----

## 💻 Tecnologia Utilizada

  * **Backend:** **Spring Boot (Java)**
  * **Banco de Dados:** **MySQL**
  * **Conteinerização:** **Docker, Docker Compose**
  * **Cloud Computing:** **AWS**

-----

## 🤝 Contribuições

Contamos com a sua colaboração para o projeto MiniBank\! Se desejar contribuir, sinta-se à vontade para fazer um **fork** do repositório, implementar suas alterações e submeter um **Pull Request**.
