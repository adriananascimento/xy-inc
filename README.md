# Projeto

O projeto foi desenvolvido a fim de resolver o seguinte problema:
Um desenvolvedor mobile está desenvolvendo uma app que precisa de um backend simples, mas ele não tem conhecimento para desenvolver esse backend. A Zup quer resolver o problema desse desenvolvedor. A idéia é que através de uma tela simples o desenvolvedor consiga criar um novo "Modelo" e inserir dados (instâncias do "Modelo") para serem consumidos pela app mobile.

Para resolver esse problema, foi implementado um web service REST simples com o [JAX-WS](https://jax-ws.java.net/) usando o [Jersey](https://jersey.java.net/) que irá prover as operações necessárias para adicionar um novo modelo e realizar a consulta, inserção, alteração e remoção das instâncias do "Modelo" criado. Foi utilizado o [Wildfly](http://wildfly.org/) como servidor de aplicação, o [PostgreSQL](https://www.postgresql.org/) como banco de dados e o [Maven](https://maven.apache.org/) para o gerenciamento das dependências. Foi criado um frontend simples, usando o [AngularJS](https://angularjs.org/), para a inserção de um novo modelo, e após a criação do modelo (PUT), é possível realizar as operações de a consulta (GET), inserção (POST), alteração (PUT) e remoção (DELETE) de instâncias do "Modelo" através de qualquer ferramenta para testes de API REST. A ferramenta utilizada foi o [POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop).

## Instruções

Essas instruções irão permitir que você possa rodar a aplicação e realizar os testes localmente. Também é possível baixar o ".war" disponibilidado e instalar em um servidor de aplicação Wildfly remoto, desde que este possua o Datasource configurado.

* Faça download do projeto e importe no [Eclipse](https://eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2)
* Adicione no Eclipse o servidor de aplicação [Wildfly](http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip)
* Inicie o servidor e adicione o usuário administrador (caso não possua)
* Na área administrativa do servidor (http://localhost:9990/console/App.html), crie um Datasource com o seguinte JNDI:
```
java:jboss/datasources/zuptesteds
```
* O Datasource deve ter a URL de conexão ("zupteste" é o nome do banco de dados que deve ser criado no Postgres):
```
jdbc:postgresql://localhost:5432/zupteste
```
* Após o Datasource criado, no Eclipse, adicione o projeto e reinicie o servidor.
* Com o servidor iniciado, acesse a seguinte URL:
```
http://localhost:8080/zupteste/
```
* Neste momento, é possível visualizar a tela para ser adicionado um novo modelo.
* Deve ser inserido o nome e os campos do modelo. 
* Os campos podem ser dos tipos: 'character varying', 'integer', 'numeric' e 'boolean'.
* É possível informar se o campo não permite valores nulos marcando a opção 'Not null?'.
* Não é necessário adicionar um campo ID, pois o mesmo será criado automaticamente e as informações inseridas terão IDs sequenciais.
* Caso nenhum campo seja adicionado, o modelo será criado apenas com o campo ID.
* Após adicionar as informações, é necessário clicar no botão 'Submit' e aguardar que seja exibida a mensagem 'Success!!!' ou 'Error!!!'.
* Exemplo de um novo modelo:
```
Name: products
Fields:
name - character varying - not null
description - character varying - null
price - numeric - not null
active - boolean - not null
```

* Após a criação do modelo, é possível acessar os serviços REST:
```
GET - http://localhost:8080/zupteste/rest/{model}
GET - http://localhost:8080/zupteste/rest/{model}/{id}
POST - http://localhost:8080/zupteste/rest/{model}
PUT - http://localhost:8080/zupteste/rest/{model}/{id}
DELETE - http://localhost:8080/zupteste/rest/{model}/{id}
```
* Exemplo de acesso ao modelo 'products' criado:
```
GET - URL - http://localhost:8080/zupteste/rest/products - Retorna todos os produtos
RETORNO: Array com todas as informações da tabela 'products'

GET - URL - http://localhost:8080/zupteste/rest/products/1 - Retorna o produto com o id igual a 1
RETORNO: Item da tabela 'products' com id = 1

POST - URL - http://localhost:8080/zupteste/rest/products - Insere um produto
JSON: 
{
  name : 'product 1',
  description : 'desc product 1',
  price : 150,
  active : true
}
RETORNO: STATUS 200 OK

PUT - URL - http://localhost:8080/zupteste/rest/products/1 - Atualiza o produto com o id igual a 1
JSON: 
{
  name : 'product 1 atualizado',
  description : 'desc product 1 atualizado',
  price : 250,
  active : true
}
RETORNO: STATUS 200 OK

DELETE - URL - http://localhost:8080/zupteste/rest/products/1 - Remove o produto com o id igual a 1
RETORNO: STATUS 200 OK
```

## Informações
Caso possua algum problema na instalação ou nos testes, por favor, entrar em contato através do e-mail:
```
adri.nascimento@gmail.com
```
