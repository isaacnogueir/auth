# Auth API - Spring Boot & JWT

Esta é uma API de autenticação desenvolvida com **Spring Boot**, **Spring Security** e **JWT**.  
Ela oferece endpoints para **registro de usuários**, **login** e **proteção de rotas com base em perfis de acesso (roles)**.  
O objetivo é servir como **base reutilizável e segura para projetos maiores** que necessitem de autenticação robusta.

## Funcionalidades

- Registro de novos usuários com papel (USER ou ADMIN)
- Geração de token JWT no login
- Validação de token em todas as requisições autenticadas
- Proteção de rotas com base em roles
- Projeto preparado para expansão

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Security
- JWT (Auth0)
- JPA/Hibernate
- Banco de dados relacional (MySQL, PostgreSQL ou H2)

## Endpoints principais

| Método | Rota           | Acesso     | Descrição                    |
|--------|----------------|------------|------------------------------|
| POST   | /auth/register | Público    | Registra um novo usuário     |
| POST   | /auth/login    | Público    | Retorna o token JWT          |
| GET    | /hello         | Protegido  | Exemplo de rota autenticada  |

**Isaac Ferreira – 2025**  
