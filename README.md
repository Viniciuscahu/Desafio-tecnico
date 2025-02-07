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

4.2. Clonar o Repositório
git clone https://github.com/seu-usuario/todo-list-api.git
cd todo-list-api

4.3. Configuração do Banco de Dados

<h2>3. Conexão com o sql server na azure</h2>
<table>
    <tr>
        <th>Configuração</th>
        <th>Detalhes</th>
    </tr>
    <tr>
        <td>Host</td>
        <td>todo-list-server-sql.database.windows.net</td>
    </tr>
    <tr>
        <td>Database</td>
        <td>to-do</td>
    </tr>
    <tr>
        <td>Porta</td>
        <td>1433</td>
    </tr>
    <tr>
        <td>Usuário</td>
        <td>sadmin</td>
    </tr>
    <tr>
        <td>Senha</td>
        <td>Todo@1234</td>
    </tr>
    <tr>
        <td>URL de Conexão</td>
        <td>jdbc:sqlserver://;serverName=todo-list-server-sql.database.windows.net;databaseName=to-do</td>
    </tr>
</table>

PS: Rodando via Docker (opcional para ambiente local)

docker run --name sqlserver -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Todo@1234' \
   -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-latest

   4.4 Configurar o Banco no SQL Server

Execute os scripts que vão estar na pasta db/migration para criar os bancos de DBO, desenvolvimento, teste e produção/


<h2>5.0 Endpoints da API</h2>
<table>
    <tr>
        <th>Método</th>
        <th>URL</th>
        <th>Descrição</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>/api/tasks</td>
        <td>Lista todas as tarefas</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>/api/tasks/{id}</td>
        <td>Busca uma tarefa por ID</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>/api/tasks</td>
        <td>Cria uma nova tarefa</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>/api/tasks/{id}</td>
        <td>Atualiza uma tarefa</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>/api/tasks/{id}</td>
        <td>Deleta uma tarefa</td>
    </tr>
</table>


<h2>5. Autenticação</h2>
<p>A API utiliza autenticação básica via Spring Security. Para acessar os endpoints, no postman use, no authorization, auth type: basic auth:</p>
<ul>
    <li><b>Usuário:</b> admin</li>
    <li><b>Senha:</b> admin123</li>
</ul>

<h2>6. CI/CD e Deploy</h2>
<p>A esteira CI/CD foi configurada utilizando <b>GitHub Actions</b> para build e deploy automático na plataforma <b>Azure Web Apps</b> e utiliza <b>Azure SQL Server</b> como banco de dados.</p>





