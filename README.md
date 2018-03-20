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
