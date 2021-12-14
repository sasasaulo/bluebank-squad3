<h1> 👨🏻‍💻 Projeto BlueBank </h1>

O seguinte projeto foi desenvolvido durante o Bootcamp fornecido pelo Banco PAN e Gama Academy.
O bootcamp foi focado na parte de backend e na plataforma AWS (Amazon Web Services).

O banco BlueBank precisa de uma API que permita cadastro de novos clientes, incluindo dados pessoais e
dados para contato. O cliente deve ser atrelado a uma conta bancária e registrar
histórico de transações entre as contas.


## ✒️ Autores

Squad 3 da turma 2 composto por:

* **Alana Lima** - [GitHub](https://github.com/AlanaLima) - [Linkedin](https://www.linkedin.com/in/alana-vieira-bb9006158/ )
* **Denise Mignoli** - [GitHub](https://github.com/denisemignoli) - [Linkedin](https://www.linkedin.com/in/denisemignoli/)
* **Edmir de Souza** - [GitHub](https://github.com/Edmir-Cabral) - [Linkedin](https://www.linkedin.com/in/edmir-de-souza-9019841b8/)
* **Marcelo Carvalho** - [GitHub](https://github.com/marceloscientist) - [Linkedin](https://www.linkedin.com/in/marcelo-carvalho-developer/)
* **Saulo Scarpina** - [GitHub](https://github.com/sasasaulo) - [Linkedin](https://www.linkedin.com/in/saulo-scarpina/)

## 🚀 Requisitos, modificações e execução
### ⚙️Requisitos
* Linguagem Java (versão 11)
* SpringBoot
* Maven
* Banco MySQL(se for outro, mudar as configurações no applicationproperties)
* Swagger
* AWS

### 🔧Modificações para rodar localmente
- Faça o download do código

 Em um terminal, execute o comando:
```bash
    git clone https://github.com/sasasaulo/bluebank-squad3.git
```

- Importe o projeto na sua IDE de preferência
- Coloque a sua senha da AWS e também o ARN do tópico (serviço SNS) no arquivo AWSSNSConfig.java

```bash
	public static final String SECRET_KEY = "";
	public static final String ACCESS_KEY = "";
	public static final String TOPIC_ARN = "";
```

- Caso queira utilizar um bando de dados localmente, o configure no arquivo application.properties. Na pasta extras, há um script para criação do banco e povoar as tabelas para teste.
- Execute como "Spring boot app" ou pelo terminal com o seguinte comando:
```bash
    mvn spring-boot:run
``` 

### 📋Execução

<p> No caso dessa API, o CRUD completo é feito por meio do Login, ou seja, é possível criar um login e assim um cliente com endereço e conta. 
E ao deletar o login se deleta também o cliente, a conta e o endereço. 
Não é possível deletar somente a conta, o cliente e o endereço, persistindo um login, ou seja, um usuario sem esses requisitos.
Contudo é possível listar e alterar todas as classes. 
É possível criar todas as classes também, desde que se respeite o relacionamento com as classes "inferiores".
Por exemplo, ao criar um login com email e senha, é necessario criar um cliente, que faz com que se precise criar um endereço e uma conta também.
Criar somente um cliente,sem conta e endereço não é possível, mas mesmo que ele tenha uma conta e um endereço ele não estará associado a um login,
o que em termos de negócio não é positivo e útil.
Recomenda-se criar sempre o login e dentro dele, já o cliente, a conta e o endereço para que os relacionamentos fiquem estabelecidos.
Para mais detalhes, veja os exemplos na documentação do Swagger</p>


<p> O serviço SNS funciona ao se cadastrar o login completo, mandando um email para confirmação.
E posteriormente é possível mandar um email com aviso de manutenção para todos que confirmaram o email</p>

<p> As transações podem ser vistas de forma geral, e também como extrato com base no id da conta.</p>

<p> Uma vez que tudo isso esteja definido, a aplicação possui os seguintes endpoints como principais</p>

#### 📌Endpoints

Endpoint         |        Função       |Método        |
:----------------|---------------------|--------------:
/login/listar | Lista todos os logins e o cliente completo |GET| 
/login/listar/idlogin | Lista o login e o cliente completo pelo ID |GET| 
/login/listar/credenciais/email/senha | Lista o login do cliente com aquele email e senha |GET| 
/login/cadastrar | Cadastra os logins e o cliente completo|POST| 
/login/atualizar/idlogin | Atualiza o login e o cliente completo pelo ID |PUT| 
/login/deletaer/idlogin | Deleta  o login e o cliente completo pelo ID |DELETE| 
/clientes/listar | Lista todos os clientes |GET| 
/clientes/listar/idcliente | Lista o cliente com aquele ID |GET|  
/clientes/alterar/idcliente | Altera aquele cliente |PUT|  
/contas/listar | Lista todas as conta | GET|
/contas/listar/idconta | Lista a conta com aquele ID |GET| 
/conta/alterar/idconta | Altera aquela conta | PUT|
/endereco/listar | Lista todos os enderços | GET|
/endereco/listar/idendereco | Lista o enderecocom aquele ID |GET|
/endereco/alterar/idendereco | Altera aquele endereco|PUT| 
/transacoes/efetuar| Faz uma transação |POST| 
/transacoes/listar| Lista todas as transações | GET|
/transacoes/buscar/idtransacao| Lista a transação com aquele ID |GET| 
/extrato/credito/idconta| Lista todas as transações de recebimento da conta com aquele ID | GET|
/extrato/debito/idconta| Lista todas as transações de envio da conta com aquele ID |GET| 
/enviaNotificacaoAWS | Envia email com aviso para os assinantes do topico|GET| 
/permiteAWSEnviarEmail/{email} | Permite envir email pedindo confirmação |GET|

##### Localmente
- Utilize a url "localhost:8080/" com o método desejado.
Exemplo: localhost:8080/clientes/listar
- Nesse modo, os métodos POST (cadastrar) e PUT (atualizar) não funcionarão corretamente pois precisam ter um "corpo" de dados passados como parâmetro.
- Nesse caso, é necessário utilizar o link do Swagger ou o Postman para que os métodos sejam executados

#### Pela AWS
- Utilize a url "http://s3t2pandasapi-env-2.eba-mysjmetu.us-east-2.elasticbeanstalk.com/" com o método desejado.
  Exemplo:http://s3t2pandasapi-env-2.eba-mysjmetu.us-east-2.elasticbeanstalk.com/clientes/listar
- Nesse modo, os métodos POST (cadastrar) e PUT (atualizar) não funcionarão corretamente pois precisam ter um "corpo" de dados passados como parâmetro.
- Nesse caso, é necessário utilizar o link do Swagger ou o Postman para que os métodos sejam executados corretamente.

#### Gateways
Além de subir a aplicação com um Banco em RDS e um Beanstalk, também foram configurados gateways para a API.
- Utilize a url "https://bpaki29922.execute-api.us-east-2.amazonaws.com/s3t2-pandas-estagio-gateway/" com o método desejado.
  Exemplo:https://bpaki29922.execute-api.us-east-2.amazonaws.com/s3t2-pandas-estagio-gateway/clientes/listar
- Nesse modo, os métodos POST (cadastrar) e PUT (atualizar) não funcionarão corretamente pois precisam ter um "corpo" de dados passados como parâmetro.
- Nesse caso, é necessário utilizar o link do Swagger ou o Postman para que os métodos sejam executados corretamente.

#### Swagger
- Acesse "http://s3t2pandasapi-env-2.eba-mysjmetu.us-east-2.elasticbeanstalk.com/swagger-ui/" ou localhost:8080/e o swagger já listará todos os métodos presentes.
- Para testar, é necessário escolher o método e clicar em "Try it out" para liberar e após isso, clicar em "Execute".
- O Swagger já traz o corpo padrão necessário para as requisções PUT e POST.

#### Postman
- Importe a coleção BlueBank_squad3.postman_collection.json presente na pasta "extras".
- Crie um novo Environment contendo Variable: "baseUrl" e Initial Value: "http://s3t2pandasapi-env-2.eba-mysjmetu.us-east-2.elasticbeanstalk.com/"
- Já será possível testar os métodos

#### Lambda
 O trabalho possui também uma função lambda que retorna uma mensagem de erro, para que seja executada caso ocorra problemas com o servidor.
 - Para testá-la, acesse: https://us-east-2.console.aws.amazon.com/lambda/home?region=us-east-2#/functions/s3t2_PANdas_Lambda?tab=code
 
#### AWSBuild
 O trabalho possui também uma pipeline no AWSBuild, que é capaz de fazer o build no projeto.
 - Acesse em: https://us-west-2.console.aws.amazon.com/codesuite/codepipeline/pipelines/Pipelinebluebanks3t2/view?region=us-west-2
