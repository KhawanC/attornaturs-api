# Attornaturs Processo Seletivo API

Autor: Kauã Cassiano

Spring Boot 2.7.7

Java 11

Uma API feita para o processo seletivo de desenvolvedor junior na  Attornaturs

# Questões de qualidade de código

### Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

- Fazer testes unitários durante o desenvolvimento do software
- Criar funções atômicas, para evitar duplicidade de código em funções diversas
- Ser claro na declaração de funções e variáveis

### Em qual etapa da implementação você considera a qualidade de software?

Tanto na etapa de desenvolvimento quanto na refatoração

- Desenvolvimento: Garantir a qualidade do software nessa etapa garante menos re-trabalho futuro
- Refatoração: Permite visualizar e questionar o fluxo da aplicação, melhorando partes não antes percebidas durante a etapa de desenvolvimento

# Aplicação

* A API foi documentada com Spring Doc (Swagger), e pode ser acessada em [localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
* Foram criados duas entidades, Pessoa e Endereço em uma relação 1:n.
* O padrão MVC foi utilizado para ambas as entidades, assim como foi exposto endpoint para CRUD das mesmas.
* Existe uma função com o verbo PATCH nos endpoints de Endereço para alterar o endereço principal de uma pessoa
* Existe uma função com o verbo GET nos endpoints de Endereço para resgatar o endereço principal de uma pessoa
* Alguns (ou todos) os erros estão sendo tratados via ExceptionHandler
* Foram feitos alguns testes utilizando JUnity 5
* Principios do Clean Code e SOLID foram utilizados (pelo menos eu sempre tento utilizar)