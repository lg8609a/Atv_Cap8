# Projeto de Diversidade e Inclusão Corporativa

Este projeto consiste em uma API RESTful desenvolvida com Spring Boot para gerenciar um sistema de vagas inclusivas e candidatos com marcadores de diversidade, seguindo os princípios ESG (Environmental, Social, and Governance).

## 📋 Sobre o Projeto

O sistema permite:
- Gerenciar vagas inclusivas em empresas
- Registrar candidatos com marcadores de diversidade
- Controlar o acesso à API através de autenticação JWT
- Diferentes níveis de permissão (ADMIN e USER)

Este projeto foi desenvolvido como atividade do Capítulo 8 da Fase 11 do curso de ADS da FIAP.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Security**
- **Spring Data JPA**
- **JWT (JSON Web Token)**
- **Oracle Database**
- **Flyway (Migrations)**
- **Docker**
- **Docker Compose**
- **Lombok**

## 🔐 Segurança

O projeto utiliza Spring Security com JWT (JSON Web Token) para autenticação e autorização:

- Autenticação stateless (sem sessão)
- Tokens JWT com expiração de 2 horas
- Senhas criptografadas com BCrypt
- Dois níveis de acesso: ADMIN e USER
- Proteção contra ataques CSRF

## 📊 Estrutura do Banco de Dados

O projeto utiliza Oracle Database com as seguintes tabelas:

- **candidato**: Armazena informações de candidatos com marcadores de diversidade
- **vaga**: Armazena informações de vagas com flag para indicar se são inclusivas
- **inscricao**: Relaciona candidatos e vagas
- **usuario**: Armazena usuários e suas credenciais

Todas as migrações de banco de dados são gerenciadas pelo Flyway.

## 🌐 Endpoints

### Autenticação

- **POST /api/auth/login**: Autentica um usuário e retorna um token JWT
    - Público

### Candidatos

- **GET /api/candidatos**: Lista todos os candidatos
    - Acessível por: USER, ADMIN
- **POST /api/candidatos**: Cria um novo candidato
    - Acessível por: ADMIN

### Vagas

- **GET /api/vagas**: Lista todas as vagas
    - Acessível por: USER, ADMIN
- **POST /api/vagas**: Cria uma nova vaga
    - Acessível por: ADMIN

## 👥 Usuários Pré-cadastrados

O sistema vem com dois usuários pré-cadastrados:

1. **Administrador**
    - Username: admin
    - Password: admin123
    - Role: ROLE_ADMIN

2. **Usuário Comum**
    - Username: user
    - Password: user123
    - Role: ROLE_USER

## 🏗️ Como Executar

### Pré-requisitos

- Java 21
- Docker e Docker Compose (para execução containerizada)
- Maven (ou use o wrapper incluído: ./mvnw)

### Execução Local

1. Clone o repositório
2. Configure o arquivo `application.properties` com suas credenciais de banco de dados
3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

### Execução com Docker

1. Clone o repositório
2. Construa e inicie os contêineres:
   ```bash
   docker-compose up -d
   ```
3. Para parar a aplicação:
   ```bash
   docker-compose down
   ```

## 📝 Exemplos de Uso

### Obter token de acesso (login)

```bash
curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username": "admin", "password": "admin123"}'
```

Resposta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "tipo": "Bearer"
}
```

### Listar candidatos (autenticado)

```bash
curl -X GET http://localhost:8080/api/candidatos -H "Authorization: Bearer SEU_TOKEN_AQUI"
```

### Criar nova vaga (como ADMIN)

```bash
curl -X POST http://localhost:8080/api/vagas -H "Authorization: Bearer SEU_TOKEN_AQUI" -H "Content-Type: application/json" -d '{"titulo": "Desenvolvedor Java", "descricao": "Vaga para desenvolvedor Java", "inclusiva": true}'
```

## 🔒 Variáveis de Ambiente

- `JWT_SECRET`: Chave secreta para assinatura dos tokens JWT (padrão: 12345678)
- `SPRING_DATASOURCE_URL`: URL de conexão com o banco de dados Oracle
- `SPRING_DATASOURCE_USERNAME`: Nome de usuário do banco de dados
- `SPRING_DATASOURCE_PASSWORD`: Senha do banco de dados

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

## 📚 Documentação Adicional

A API não possui uma documentação Swagger/OpenAPI configurada, mas pode ser implementada adicionando as dependências apropriadas e anotações nos controllers.

