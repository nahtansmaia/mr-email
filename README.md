# MS-Email
> *Microsserviço desenvolvido para envio de e-mail.*

Para o desenvolvimento deste, foi utilizado a linguagem Java, com o framework Spring. Também foi utilizado o PostgreSQL 
como banco de dados para que fosse armazenado os e-mails enviados para consultas futuras.

## Sumário
- [Instalando](https://github.com/nahtansmaia/ms-email#instalando)
- [Clonando o repositório](https://github.com/nahtansmaia/ms-email#clonando-o-reposit%C3%B3rio)
- [Funcionalidades](https://github.com/nahtansmaia/ms-email#funcionalidades)
    - [Estrutura de JSON para envio](https://github.com/nahtansmaia/ms-email#estrutura-de-json-para-envio)
    - [Estrutura do response](https://github.com/nahtansmaia/ms-email#estrutura-do-response)
- [Links](https://github.com/nahtansmaia/ms-email#links)
- [Licença](https://github.com/nahtansmaia/ms-email#licen%C3%A7a)

## Instalando

Após o clone deste, é necessário criar o application.properties com as informações do seu banco de dados, smtp e RabbitMQ.
Para melhor entendimento, segue neste um exemplo da estrutura utilizada. 
[Clicando aqui](https://github.com/nahtansmaia/ms-email/blob/master/src/main/resources/application-example.properties)
é possível consulta-lo. Após a configuração do mesmo, utilizar o comando abaixo para que seja criado o pacote com as 
dependências necessárias.

## Clonando o repositório

```shell
git clone https://github.com/nahtansmaia/ms-email.git
cd ms-email/
mvn package # Aguarde a conclusão deste procedimento antes de executa-lo.
```

Após a conclusão do procedimento acima, acesse a classe MsEmailApplication.java para executar.
A execução será realizada na porta 3000 se utilizado o application.properties de exemplo.

## Funcionalidades

O que irá encontrar neste microsserviço:
- Envio de e-mail através de requisições POST;
- Localização de e-mails enviados através do *ID*, *emailFrom* ou *emailTo* através de requisições GET;
- Banco de dados com todos os e-mails para consultas;

#### Estrutura de JSON para envio
```json
{
    "ownerRef": "String",
    "emailFrom": "String",
    "emailTo": "String",
    "subject": "String",
    "text": "String"
}
```
- **ownerRef:** Owner para gerenciamento de fila.
- **emailFrom:** Quem enviará o e-mail.
- **emailTo:** Quem receberá o e-mail.
- **subject:** Assunto do e-mail.
- **text:** Corpo do e-mail.

#### Estrutura do response.
```json
{
  "emailId": "UUID",
  "ownerRef": "String",
  "emailFrom": "String",
  "emailTo": "String",
  "subject": "String",
  "text": "String",
  "sendDateEmail": "LocalDateTime",
  "statusEmail": "ENUM"
}
```
> *Diferente do request, o response retornará alguns campos adicionais, tais como:*
- **emailId:** Id utilizado no banco de dados.
- **sendDateEmail:** Data e hora de envio do e-mail.
- **statusEmail:** Enum com os tipos *SENT* ou *ERROR*, indicando o status da requisição.

## Links

- Repositório: https://github.com/nahtansmaia/ms-email
- Spring: https://spring.io/projects/spring-boot
- PostgreSQL: https://www.postgresql.org/
- RabbitMQ: https://www.rabbitmq.com/

## Licença

O código neste projeto está licenciado sob a licença MIT.
