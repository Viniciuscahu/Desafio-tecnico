# Desafio-tecnico

<h2>1. Introdução</h2>
<p>Este repositório contém a implementação de uma API RESTful para um sistema de gerenciamento de tarefas (To-Do List). O objetivo do projeto é fornecer uma solução eficiente para criação, edição, exclusão, e a leitura das tarefas. Foi desenvolvido utilizando <b>Java 21</b> com <b>Spring Boot 3</b>, seguindo os princípios de <b>Clean Code</b> e <b>Clean Architecture</b>, além de integração com o <b>SQL Server</b> para armazenamento de dados.</p>


<h2>2. Infraestrutura na Azure</h2>
<p>Para a hospedagem da API, foram criadas três instâncias do Azure Web App, cada uma destinada a um ambiente específico: <b>desenvolvimento</b> (develop), <b>teste</b> (tst) e <b>produção</b> (main). Devido a limitações da assinatura da Azure utilizada, não foi possível provisionar múltiplos bancos de dados, o que levou à utilização de um único banco de dados SQL Server, estruturado em <b>schemas</b> distintos para cada ambiente.</p>

<h2>2. Funcionalidades</h2>
<p>A API oferece as seguintes funcionalidades:</p>
<ul>
    <li>✅ Criar novas tarefas</li>
    <li>📋 Listar todas as tarefas cadastradas</li>
    <li>🔍 Buscar uma tarefa específica por ID</li>
    <li>✏️ Atualizar uma tarefa existente</li>
    <li>❌ Excluir uma tarefa</li>
</ul>

<h3>Atributos de uma Tarefa</h3>
<table>
    <tr>
        <th>Atributo</th>
        <th>Descrição</th>
    </tr>
    <tr>
        <td><b>id</b></td>
        <td>Identificador único da tarefa</td>
    </tr>
    <tr>
        <td><b>title</b></td>
        <td>Título descritivo da tarefa</td>
    </tr>
    <tr>
        <td><b>description</b></td>
        <td>Detalhes sobre a tarefa</td>
    </tr>
    <tr>
        <td><b>createdAt</b></td>
        <td>Data de criação da tarefa</td>
    </tr>
    <tr>
        <td><b>status</b></td>
        <td>Status atual da tarefa (PENDING, IN_PROGRESS, COMPLETED)</td>
    </tr>
</table>

<h2>3. Tecnologias Utilizadas</h2>
<p>O projeto foi desenvolvido com as seguintes tecnologias:</p>
<ul>
    <li>☕ <b>Java 21</b> - Linguagem principal</li>
    <li>🚀 <b>Spring Boot 3</b> - Framework para desenvolvimento da API</li>
    <li>🗄️ <b>Spring Data JPA</b> - Persistência de dados</li>
    <li>🔒 <b>Spring Security</b> - Autenticação e segurança</li>
    <li>💾 <b>SQL Server</b> - Banco de dados</li>
    <li>🔄 <b>Git/GitHub</b> - Versionamento de código (GitFlow)</li>
    <li>⚙️ <b>GitHub Actions</b> - CI/CD</li>
    <li>☁️ <b>Azure</b> - Hospedagem da API e banco de dados</li>
</ul>

<h2>4. Configuração do Ambiente</h2>
<h3>4.1. Requisitos</h3>
<p>Antes de iniciar a API, certifique-se de ter os seguintes itens instalados:</p>
<ul>
    <li>✅ <b>Java 17 ou superior</b></li>
    <li>✅ <b>Maven</b> - Gerenciador de dependências</li>
    <li>✅ <b>Docker</b> (opcional para rodar o banco de dados localmente)</li>
    <li>✅ <b>SQL Server</b> - Banco de dados</li>
    <li>✅ <b>Git</b> - Controle de versão</li>
</ul>
4.2. Clonar o Repositório
git clone [https://github.com/seu-usuario/todo-list-api.git](https://github.com/Viniciuscahu/Desafio-tecnico.git)
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





