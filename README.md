# Projeto

O projeto foi desenvolvido a fim de resolver o seguinte problema:
Um desenvolvedor mobile está desenvolvendo uma app que precisa de um backend simples, mas ele não tem conhecimento para desenvolver esse backend. A Zup quer resolver o problema desse desenvolvedor. A idéia é que através de uma tela simples o desenvolvedor consiga criar um novo "Modelo" e inserir dados (instâncias do "Modelo") para serem consumidos pela app mobile.

Para resolver esse problema, foi implementado um web service REST simples com o [JAX-WS](https://jax-ws.java.net/) usando o [Jersey](https://jersey.java.net/) que irá prover as operações necessárias para adicionar um novo modelo e realizar a consulta, inserção, alteração e remoção das instâncias do "Modelo" criado. Foi utilizado o [Wildfly](http://wildfly.org/) como servidor de aplicação, o [PostgreSQL](https://www.postgresql.org/) como banco de dados e o [Maven](https://maven.apache.org/) para o gerenciamento das dependências. Foi criado um frontend simples, usando o [AngularJS](https://angularjs.org/), para a inserção de um novo modelo, e após a criação do modelo (PUT), é possível realizar as operações de a consulta (GET), inserção (POST), alteração (PUT) e remoção (DELETE) de instâncias do "Modelo" através de qualquer ferramenta para testes de API REST. A ferramenta utilizada foi o [POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds
