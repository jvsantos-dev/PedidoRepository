# 🧾 Pedido API

## 📌 Descrição
Este projeto tem como objetivo demonstrar a criação de uma API REST em Java utilizando **Spring Boot**, com persistência de dados e validações.

A aplicação permite o gerenciamento de pedidos, incluindo:

- 📦 Cadastro de pedidos  
- 📋 Listagem de pedidos  
- 🔍 Busca por ID  
- ✏️ Atualização  
- ❌ Remoção  

Os dados são armazenados em um banco de dados **H2 em memória**, facilitando testes e desenvolvimento.

---

## 🚀 Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Maven  
- Jakarta Validation  

---

## 📁 Estrutura do Projeto


src/main/java/br/com/fiap/checkpoint1/
├── controller
├── model
├── repository
└── service


- **controller** → endpoints da API  
- **model** → entidade Pedido  
- **repository** → acesso ao banco de dados  
- **service** → regras de negócio  

---

## 📦 Endpoints

| Método | Endpoint        | Descrição              |
|--------|---------------|------------------------|
| GET    | /pedidos       | Lista todos os pedidos |
| GET    | /pedidos/{id}  | Busca por ID           |
| POST   | /pedidos       | Cria um pedido         |
| PUT    | /pedidos/{id}  | Atualiza um pedido     |
| DELETE | /pedidos/{id}  | Remove um pedido       |

---

## 🔄 Exemplo de Requisição

### ➕ Criar Pedido

## json
POST /pedidos
{
  "clienteNome": "João",
  "valorTotal": 150.0
}

## ⚙️ Configuração do Banco (H2)

Arquivo: application.properties

spring.datasource.url=jdbc:h2:mem:pedidos-db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## Como Executar
Clone o repositório
Abra o projeto na IDE
Execute a aplicação Spring Boot

##  Acessar Banco H2

Abra no navegador:

http://localhost:8080/h2-console
Credenciais:
JDBC URL: jdbc:h2:mem:pedidos-db
User: sa
Password: (vazio)
✅ Regras de Validação
✔️ Nome do cliente obrigatório
✔️ Valor total não pode ser negativo
✔️ Data do pedido preenchida automaticamente

## 👥 Integrantes
João Victor Oliveira dos Santos — RM557948
Matheus Alcântara Estevão — RM558193
Nicolle Pellegrino Jelinski — RM558610
Pedro Pereira dos Santos — RM552047
Eric Segawa Montagner — RM558224

## 📌 Observação
Execute a aplicação antes de acessar os endpoints
Utilize Postman ou Insomnia para testar a API
O banco H2 é temporário (dados são apagados ao reiniciar)
