# Desafio-tecnico

1. Introdução

Este repositório contém a implementação de uma API RESTful para um sistema de gerenciamento de tarefas (To-Do List). O projeto foi desenvolvido em Java utilizando Spring Boot e SQL Server como banco de dados, seguindo os princípios de Clean Code e Clean Architecture.

2. Funcionalidades

A API permite:

Criar novas tarefas;

Listar todas as tarefas cadastradas;

Buscar uma tarefa específica por ID;

Atualizar uma tarefa existente;

Excluir uma tarefa;

Cada tarefa contém os seguintes atributos:

id (identificador único)

title (título da tarefa)

description (descrição detalhada da tarefa)

createdAt (data de criação da tarefa)

status (status da tarefa: PENDING, IN_PROGRESS, COMPLETED)

3. Tecnologias Utilizadas

Java 21

Spring Boot 3

Spring Data JPA

Spring Security (autenticação básica)

SQL Server (banco de dados)

Git/GitHub (controle de versão com GitFlow)

GitHub Actions (CI/CD)

Azure (hospedagem da API e banco de dados)

4. Configuração do Ambiente

4.1. Requisitos

Antes de iniciar a API, certifique-se de ter instalado:

Java 17 ou superior

Maven

Docker (opcional para rodar o banco de dados localmente)

SQL Server

Git
