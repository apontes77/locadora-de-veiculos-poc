# Locadora de veículos

Esta é uma aplicação que usa Spring Boot e Spring Data JPA para a atividade em questão.
Há dois bancos de dados possíveis de usar: H2 Database (banco de dados em memória) ou o PostgreSQL (via Docker).

### executando o banco de dados H2

basta descomentar as linhas comentadas no arquivo ``application.properties`` e comentar as demais, executo a diretiva `server.port`.
Esta deve estar como ``server.port=3030``. Mas pode ser outra porta também, sem problema.

execute a aplicação com ``mvn spring-boot:run``

PS.: a linha ``spring.jpa.database-platform=org.hibernate.dialect.H2Dialect``
deve estar asssim para o banco H2.

### executando o banco de dados PostgreSQL

1 - tenha o Docker executando na sua máquina - se Windows, Docker Desktop 

2 - via terminal, entre na pasta ``locadora-veiculos`` e execute ``docker-compose up -d``

3 - execute a aplicação com mvn spring-boot:run

PS.: a linha ``spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect``
deve estar asssim para o banco PostgreSQL.

Pronto, terminou. Se quiser acessar a base de dados, use um client como o DBeaver, crie uma conexão PostgresSQL e insira os dados de conexão contidos no docker-compose.

Para matar os containers, execute ``docker-compose down``
