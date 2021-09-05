# MS-Email

> *Microsserviço desenvolvido para envio de e-mail.*

Para o desenvolvimento deste, foi utilizado a linguagem Java, com o framework Spring. Também foi utilizado o PostgreSQL
como banco de dados para que fosse armazenado os e-mails enviados para consultas futuras.

## Sumário

- [Instalando](https://github.com/nahtansmaia/ms-email#instalando)
- [Clonando o repositório](https://github.com/nahtansmaia/ms-email#clonando-o-reposit%C3%B3rio)
- [Funcionalidades](https://github.com/nahtansmaia/ms-email#funcionalidades)
- [Requests](https://github.com/nahtansmaia/ms-email#requests)
    - [Estrutura do JSON SMTP.](https://github.com/nahtansmaia/ms-email#estrutura-de-json-para-envio-de-smtp)
    - [Estrutura do JSON e-mail](https://github.com/nahtansmaia/ms-email#estrutura-de-json-para-envio-de-e-mail)
- [Links](https://github.com/nahtansmaia/ms-email#links)
- [Licença](https://github.com/nahtansmaia/ms-email#licen%C3%A7a)

---

## Instalando

Após o clone deste, é necessário criar o application.properties com as informações do seu banco de dados, smtp e
RabbitMQ. Para melhor entendimento, segue neste um exemplo da estrutura utilizada.
[Clicando aqui](https://github.com/nahtansmaia/ms-email/blob/master/src/main/resources/application-example.properties)
é possível consulta-lo. Após a configuração do mesmo, utilizar o comando abaixo para ser criado o pacote com as
dependências necessárias.

## Clonando o repositório

```shell
git clone https://github.com/nahtansmaia/ms-email.git
cd ms-email/
mvn package # Aguarde a conclusão deste procedimento antes de executa-lo.
```

Após a conclusão do procedimento acima, acesse a classe MsEmailApplication.java para executar. A execução será realizada
na porta 3000 se utilizado o application.properties de exemplo.

## Funcionalidades

O que irá encontrar neste microsserviço:

- Envio de e-mail através de requisições POST através de qualquer SMTP configurado pelo usuário;
- Localização de e-mails enviados através do *ID*, *emailFrom* ou *emailTo* através de requisições GET;
- Banco de dados com todos os e-mails para consultas;

## Requests

> #### Estrutura de JSON para envio de SMTP.

```json
{
  "host": "smtp.gmail.com",
  "port": 587,
  "username": "teste@gmail.com",
  "password": "password",
  "auth": true,
  "tls": true
}
```


> #### Estrutura do response de e-mail.

```json
{
  "id": "UUID",
  "host": "smtp.gmail.com",
  "port": 587,
  "username": "teste@gmail.com",
  "auth": true,
  "tls": true
}
```

* *Exemplo acima é apenas para exemplificação. Em teste local, deverá ser preenchido as informações correspondentes a
  seu host.*

| Atributo | Descrição                         |   Tipo  |
|----------|-----------------------------------|:-------:|
| id       | ID do SMTP salvo.                 |   UUID  |
| host     | SMTP do host utilizado.           |  String |
| port     | Porta de comunicação do host.     | Integer |
| username | E-mail destinatário.              |  String |
| password | Senha do e-mail destinatário.     |  String |
| auth     | Autenticação obrigatória do host. | Boolean |
| tls      | TLS do host.                      | Boolean |
| text     | Corpo do e-mail.                  |  String |

---

> #### Estrutura de JSON para envio de e-mail

```json
{
  "smtp": "UUID",
  "ownerRef": "ownerRef",
  "emailFrom": "emailFrom@gmail.com",
  "emailTo": "emailTo@gmail.com",
  "subject": "subject",
  "text": "text",
  "dirPart": "C:/dirPart/image.png"
}
```

| Atributo  | Descrição                          | Obrigatório |
|-----------|------------------------------------|:-----------:|
| smtp      | UUID do SMTP configurado.          |     Sim     |
| ownerRef  | Owner do terminal utilizado no MS. |     Sim     |
| emailFrom | E-mail emitente.                   |     Sim     |
| emailTo   | E-mail destinatário.               |     Sim     |
| subject   | Assunto do e-mail.                 |     Sim     |
| text      | Corpo do e-mail.                   |     Sim     |
| dirPart   | Diretório do anexo desejado.       |     Não     |


> #### Estrutura do response de e-mail.
>

```json
{
  "emailId": "emailId",
  "ownerRef": "ownerRef",
  "emailFrom": "emailFrom@gmail.com",
  "emailTo": "emailTo@gmail.com",
  "subject": "subject",
  "dirPart": "C:/dirPart/image.png",
  "smtp": "UUID",
  "text": "text",
  "sendDateEmail": "LocalDateTime",
  "statusEmail": "ENUM"
}
```

| Atributo      | Descrição                          |      Tipo     |
|---------------|------------------------------------|:-------------:|
| emailId       | ID do e-mail salvo                 |      UUID     |
| ownerRef      | Owner do terminal utilizado no MS. |     String    |
| emailFrom     | E-mail emitente.                   |     String    |
| emailTo       | E-mail destinatário.               |     String    |
| subject       | Assunto do e-mail.                 |     String    |
| dirPart       | Diretório do anexo desejado.       |     String    |
| smtp          | ID do SMTP utilizado no envio.     |      UUID     |
| text          | Corpo do e-mail.                   |     String    |
| SendDateEmail | Data e hora de envio do e-mail     | LocalDateTime |
| statusEmail   | ERROR ou SENT                      |      ENUM     |

> *Diferente do request, o response retornará alguns campos adicionais, tais como:*

---
## Links

- Repositório: https://github.com/nahtansmaia/ms-email
- Spring: https://spring.io/projects/spring-boot
- PostgreSQL: https://www.postgresql.org/
- RabbitMQ: https://www.rabbitmq.com/

## Licença

O código neste projeto está sob a licença MIT.
