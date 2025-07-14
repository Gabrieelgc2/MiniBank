# MiniBank
Uma aplicação fintech inovadora projetada para fornecer serviços financeiros simples e acessíveis à população não bancarizada. Em resposta às recentes regulamentações financeiras que abriram caminho para a criação de contas totalmente digitais, rápidas e menos burocráticas, o MiniBank visa atrair uma grande base de usuários com seus recursos simplificados.

## Funcionalidades
### Para Clientes (Usuários)
- **Abertura de Conta**: Abra facilmente uma nova conta bancária digital.
- **Transferências de Fundos**: Transfira fundos de sua conta MiniBank para outras contas MiniBank de forma simples.
- **Solicitações de Empréstimos**: Envie solicitações de empréstimos diretamente pelo aplicativo.

### Para Gerentes
- **Visualizar Solicitações de Empréstimos**: Gerentes podem visualizar todas as solicitações de empréstimos enviadas.
- **Aprovar/Rejeitar Empréstimos**: Gerentes têm autoridade para aprovar ou rejeitar as solicitações de empréstimos.

## Como Começar
Para rodar a aplicação MiniBank localmente, siga os passos abaixo:

### Pré-requisitos
- Docker, que pode ser baixado [aqui](https://www.docker.com/products/docker-desktop/) (escolha a versão compatível com seu sistema operacional).

### Instalação
1. Clone o repositório:
   > git clone [https://github.com/Gabrieelgc2/MiniBank.git](https://github.com/Gabrieelgc2/MiniBank.git)

2. Acesse o diretório:
   > cd MiniBank

3. Construa a aplicação com Docker Compose:
   > docker-compose up --build -d

4. Inicie a aplicação com:
   > docker-compose up

5. Caso queira desligar a aplicação:
   > docker compose down

## Acessando a Aplicação
- A aplicação Spring Boot deverá estar acessível em http://localhost:8081.

## Como acessar o banco de dados (MySQL)
1. > docker ps (para ver o nome dos containers)
2. > docker exec -it [nome do banco de dados, geralmente é minibank-db-1] bash
3. > mysql -u root -p | senha: casa123
4. > SHOW DATABASES;
5. > USE pitangdb;
6. > SHOW TABLES;
7. > SELECT * FROM [insira a tabela desejada]\G;

## Endpoints da API e Funcionalidades
Esta seção detalha as funcionalidades principais e seus respectivos endpoints.

### 1 Requisito – Cadastro de Usuário (/create) - POST
- Qualquer pessoa pode abrir uma conta fornecendo dados básicos: nome, CPF, endereço, e-mail e senha.
- O CPF deve ser único (não pode haver duplicação).
- Para cada cadastro, um número de conta sequencial é criado.
- Novas contas começam com um saldo bônus de R$ 50,00 para atrair novos clientes.

Exemplo:

```json
{
  "name" : "Teste1",
  "cpf" : "46326463120",
  "email" : "RodrigoPereira@Jequitinhonha",
  "address" : "teste",
  "password" : "teste2"
}
```
### Requisito 2 – Autenticação (/login) - GET
- Após a criação de uma conta, o usuário deve se autenticar com o número da sua conta (criado sequencialmente) e senha.
- Os gerentes podem se autenticar com o número de conta fixo "gerencia" e qualquer senha fixa; esse usuário não precisa estar realmente registrado no banco de dados.

Exemplo:
  
- Para o cliente: 46326463120 e senha: teste2

- Para o gerente: gerencia e senha: senha

### Requisito 3 – Cliente: Saldo da Conta e Transações (/account/{id}/balance, seeTransactions/numberAccount) - GET
- Após a autenticação, os clientes podem visualizar o saldo da sua conta.
- Também deve ser possível visualizar as transferências realizadas e recebidas.

### Requisito 4 – Cliente: Transferência de Fundos (/transfer) - POST
- Os clientes podem transferir fundos para outras contas do MiniBank, desde que tenham saldo suficiente.
- As transferências devem aparecer para o usuário remetente como "valor enviado" e para o usuário receptor como "valor recebido".
- Após a conclusão da transferência, o novo saldo deve ser refletido para ambos os usuários envolvidos na transação.

Exemplo:

```json
{  
  "sourceAccount": 207501,
  "destinationAccount": 948937,
  "value": 10
}

### Requisito 5 – Cliente: Solicitação de Empréstimo (/loan) - POST
- O público em geral pode solicitar empréstimos fornecendo o valor desejado e o motivo.

Exemplo:

```json
{
  "value": 400,
  "reason": "não sei"
}
```
Requisito 6 – Gerente: Visualizar Solicitações de Empréstimos (/checkLoan) - GET
- Os gerentes podem visualizar todas as solicitações de empréstimos e seus respectivos status (PENDENTE, ACEITO, REJEITADO).

Requisito 7 – Gerente: Aceitar ou Rejeitar Solicitações de Empréstimos (/loan/{id}/status) - PATCH
- Os gerentes podem modificar o status do empréstimo para ACEITO ou REJEITADO.

- Se o empréstimo for aceito, o valor deve ser refletido na conta do usuário que o solicitou.

Exemplo:

```
{         
  "status": "ACEITO"

}
```

Stack de Tecnologia
Backend: Spring Boot (Java)

- Banco de Dados: MySQL

- Containerização: Docker, Docker Compose

- Computação em Nuvem: AWS

Contribuindo
Nós acolhemos contribuições para o projeto MiniBank! 
Se você quiser contribuir, fique à vontade para fazer um fork do repositório, realizar suas alterações e enviar um pull request.
