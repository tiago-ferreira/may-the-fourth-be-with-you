# may-the-fourth-be-with-you
May the fourth be with you

## Arquitetura

O sistema foi dividido em algumas camadas, aqui as camadas estao divididas apenas em nomeclatura de pacotes.

### Modelo
Onde ficam as classes de modelo que fazem um mapeamento com o banco utilizado

### Repository
E a camada responsavel por fazer toda a comunicação com o banco de dados.

### Service
E a camada responsavel pelas regras de negocio

### Controllers
E a camada responsavel por disponibilizar as servicos Rest para que outras aplicações ou clientes possam acessar.

## Banco de Dados
Como banco de daods foi utlizado o Mongo


## Executar

- mvn clean install
- docker-compose up -d

A aplicação irá iniciar em http://localhost:8080

## Servicos para explorar

GET /campaign

POST /campaign

PUT /campaign

DELETE /campaign

Exemplo de Json para fazer um POST
{
"id":"E04",
"name":"Winter 2",
"heartTeamId":"HT03",
"beginValidity":"2018-03-07",
"endValidity":"2018-03-08"
}