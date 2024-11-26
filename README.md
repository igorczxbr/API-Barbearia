# API-Barbearia
Editor de código: eclipse

Banco de dados: postgres

Gerenciador do banco de dados: pgAdmin

Documentação da api: https://www.postman.com/igorcruz232/api-barbearia/collection/a6wguzy/api-documentation?action=share&creator=40001346

## Configuração do banco de dados
Gerenciador: pgAdmin

1 - Crie um banco de dados chamado agendamento

2 - Com o botão direito no banco de dados e clique em query tool

3 - Importe a query usando o arquivo estrutura.sql na pasta do repositório

4 - Execute a query, por padrão o banco bem sem nenhum dado


## Importação do projeto
Editor de código: eclipse 

1 - Crie uma pasta adequada pra fazer o git clone do repositório

2 - Instalar o ambiente do spring boot no eclipse e extrair o arquivo .zip: https://spring.io/tools

3 - Apos extrair abra o eclipse e na área de trabalho selecione a pasta extraida e clique em iniciar

4 - No campo arquivo, clique em importar

5 - Abra a pasta maven e selcione Projeto Maven existent

6 - Procure a pasta do repósitorio e selecione a pasta agendamento

7 - Clique em finish

## Configurar banco de dados na api 
1 - Acesse a pasta com.api.agendamento

2 - Abra o arquivo DatabaseConfig.java

3 - Configurar DataSource:
    - dataSource.setDriverClassName("org.postgresql.Driver");
    - dataSource.setUrl("jdbc:postgresql://localhost:5432/agendamento"); // Ajuste a URL conforme necessário
    - dataSource.setUsername("postgres");// Substitua pelo seu usuário
    - dataSource.setPassword("markim");   





