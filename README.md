# Desafio-tecnico

<h2>1. Introdução</h2>
<p>Este repositório contém a implementação de uma API RESTful para um sistema de gerenciamento de tarefas (To-Do List). O objetivo do projeto é fornecer uma solução eficiente para criação, edição, exclusão, e a leitura das tarefas. Foi desenvolvido utilizando <b>Java 21</b> com <b>Spring Boot 3</b>, seguindo os princípios de <b>Clean Code</b> e <b>Clean Architecture</b>, além de integração com o <b>SQL Server</b> para armazenamento de dados.</p>



<h2>2. Testando o Banco de Dados Localmente</h2>
<p>Se desejar testar a API com um banco de dados local, pode instalar o <b>SQL Server Express</b>, que é uma versão gratuita do SQL Server.</p>

<h3>2.1. Instalação do SQL Server Express</h3>
<p>Baixe e instale o SQL Server Express através do link oficial da Microsoft:</p>
<p>🔗 <a href="https://www.microsoft.com/pt-br/sql-server/sql-server-downloads" target="_blank">Baixar SQL Server Express</a></p>

<h3>2.2. Criar Banco de Dados Local</h3>
<p>Após instalar o SQL Server, crie um banco de dados e uma tabela para armazenar as tarefas executando os comandos abaixo no SQL Server Management Studio (SSMS):</p>
<pre>
CREATE DATABASE to_do;
GO
USE to_do;
GO
CREATE TABLE tasks (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT GETDATE(),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
);
GO
</pre>

<h3>2.3. Configuração da API para Usar o Banco Local</h3>
<p>Altere o arquivo <code>application.properties</code> para conectar ao banco local:</p>
<pre>
spring.datasource.url=jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=to_do;encrypt=false;
spring.datasource.username=sa
spring.datasource.password=SUA_SENHA_AQUI
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
</pre>

<h3>2.4. Rodando a API Localmente</h3>
<p>Após configurar o banco, inicie a API com:</p>
<pre>
mvn spring-boot:run
</pre>
<p>Se tudo estiver correto, a API estará disponível em <code>http://localhost:8080</code>.</p>

<h2>3. Infraestrutura na Azure</h2>
<p>Para a hospedagem da API, foram criadas três instâncias do Azure Web App, cada uma destinada a um ambiente específico: <b>desenvolvimento</b> (develop), <b>teste</b> (tst) e <b>produção</b> (main). Devido a limitações da assinatura da Azure utilizada, não foi possível ter uma boa resposta rápida do servidor, o que levou à utilização de um único banco de dados SQL Server, estruturado em <b>schemas</b> distintos para cada ambiente.</p>

<h3>3.1. Estrutura dos Ambientes</h3>
<table>
    <tr>
        <td>Desenvolvimento</td>
        <td>todo-list-dev</td>
        <td>dev</td>
    </tr>
    <tr>
        <td>Teste</td>
        <td>todo-list-tst</td>
        <td>tst</td>
    </tr>
    <tr>
        <td>Produção</td>
        <td>todo-list-main</td>
        <td>prd</td>
    </tr>
</table>

<p>Essa abordagem garante a separação lógica dos dados entre os diferentes ambientes, permitindo a validação e a garantia de qualidade antes da implantação final em produção, apesar da limitação no número de serviços disponíveis.</p>


<h2>3.2 Links dos Ambientes Hospedados</h2>
<p>A API está disponível nos seguintes ambientes hospedados na Azure:</p>
<table>
    <tr>
        <th>Ambiente</th>
        <th>URL</th>
    </tr>
    <tr>
        <td>Desenvolvimento</td>
        <td><a href="https://todo-list-dev-gdaxgsdsgffsfdae.brazilsouth-01.azurewebsites.net/api/tasks" target="_blank">todo-list-dev</a></td>
    </tr>
    <tr>
        <td>Teste</td>
        <td><a href="https://todo-list-tst.azurewebsites.net/api/tasks" target="_blank">todo-list-tst</a></td>
    </tr>
    <tr>
        <td>Produção</td>
        <td><a href="https://todo-list-prd.azurewebsites.net/api/tasks" target="_blank">todo-list-prd</a></td>
    </tr>
</table>

PS: Pode demorar um pouco para carregar os dados das APIs, devido à hospedagem no SQL Server Azure.

<h2>3.3. Screenshots dos Ambientes</h2>

<h3>3.4. Ambiente de Desenvolvimento</h3>
<p>API rodando em <b>Develop</b>:</p>
<img width="920" alt="Pasted Graphic" src="https://github.com/user-attachments/assets/61afccef-3817-4619-8af9-6644f2d80c2e" />
<p>Banco de dados do ambiente <b>Develop</b>:</p>
<img width="695" alt="Az description" src="https://github.com/user-attachments/assets/1f37d896-aa75-4d95-a3f7-712b83bb1544" />

<h3>3.5. Ambiente de Teste</h3>
<p>API rodando em <b>Test</b>:</p>
<img width="523" alt="Pasted Graphic" src="https://github.com/user-attachments/assets/9bcf43a0-76e3-4553-8523-7b08b2cdda0e" />
<p>Banco de dados do ambiente <b>Test</b>:</p>
<img width="717" alt="image" src="https://github.com/user-attachments/assets/1d6f7e71-688e-4acb-8fbc-e610ede529fb" />

<h3>3.6. Ambiente de Produção</h3>
<p>API rodando em <b>Produção</b>:</p>
<img width="462" alt="image" src="https://github.com/user-attachments/assets/4a00bf2c-1a76-43b7-a5a2-685292dde17c" />
<p>Banco de dados do ambiente <b>Produção</b>:</p>
<img width="766" alt="image" src="https://github.com/user-attachments/assets/df79ec18-558e-40e8-8489-389507999c5e" />

<h2>4. Funcionalidades</h2>
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

<h2>5. Tecnologias Utilizadas</h2>
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

<h2>6. Configuração do Ambiente</h2>
<h3>6.1. Requisitos</h3>
<p>Antes de iniciar a API, certifique-se de ter os seguintes itens instalados:</p>
<ul>
    <li>✅ <b>Java 17 ou superior</b></li>
    <li>✅ <b>Maven</b> - Gerenciador de dependências</li>
    <li>✅ <b>Docker</b> (opcional para rodar o banco de dados localmente)</li>
    <li>✅ <b>SQL Server</b> - Banco de dados</li>
    <li>✅ <b>Git</b> - Controle de versão</li>
</ul>
6.2. Clonar o Repositório
git clone (https://github.com/seu_usuario/Desafio-tecnico.git)
cd todo-list-api

6.3. Configuração do Banco de Dados

 Rodando via Docker (opcional para ambiente local)

docker run --name sqlserver -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Todo@1234' \
   -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-latest

   6.4 Configurar o Banco 

Execute os scripts que vão estar na pasta db/migration para criar os bancos de DBO, desenvolvimento, teste e produção/


<h2>7.0 Endpoints da API</h2>
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


<h2>8. Autenticação</h2>
<p>A API utiliza autenticação básica via Spring Security. Para acessar os endpoints, no postman use, no authorization, auth type: basic auth:</p>
<ul>
    <li><b>Usuário:</b> admin</li>
    <li><b>Senha:</b> admin123</li>
</ul>

<h2>9. CI/CD e Deploy</h2>
<p>A esteira CI/CD foi configurada utilizando <b>GitHub Actions</b> para build e deploy automático na plataforma <b>Azure Web Apps</b> e utiliza <b>Azure SQL Server</b> como banco de dados.</p>





