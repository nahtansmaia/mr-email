# MS-Email
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/nahtansmaia/ms-email/blob/master/README.en.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/nahtansmaia/ms-email/blob/master/README.md)

> *Microservice developed for sending email.*

For its development, Java and frameworks such as SpringBoot, PostgreSQL and RabbitMQ were used.

## Sumário

- [Starting](https://github.com/nahtansmaia/ms-email#Starting)
- [Cloning](https://github.com/nahtansmaia/ms-email#Cloning)
- [Resources](https://github.com/nahtansmaia/ms-email#Resources)
- [Request examples](https://github.com/nahtansmaia/ms-email#requests)
    - [JSON SMTP Structure](https://github.com/nahtansmaia/ms-email#JSON-SMTP-Structure)
    - [JSON email structure](https://github.com/nahtansmaia/ms-email#Structure-for-SMTP-response.)
- [Links](https://github.com/nahtansmaia/ms-email#links)
- [License](https://github.com/nahtansmaia/ms-email#license)

---

## Starting

After clone this, it is necessary to create the application.properties with the information from your database, smtp and
RabbitMQ. For better understanding, here is an example of the structure used.
[Click here](https://github.com/nahtansmaia/ms-email/blob/master/src/main/resources/application-example.properties)
can consult it. After configuring it, use the command below to create the package with the
necessary dependencies.

## Cloning

```shell
git clone https://github.com/nahtansmaia/ms-email.git
cd ms-email/
mvn package # Wait for this procedure to complete before performing it.
```

After completing the above procedure, access the MsEmailApplication.java class to execute. The execution will be carried out
on port 3000 if using the example application.properties.

## Resources

What will you find in this microservice:

- Sending email through POST requests for any SMTP configured by the user;
- Location of emails sent via *ID*, *emailFrom* or *emailTo* via GET requests;
- Database with all emails for queries;

## Requests

> #### JSON SMTP Structure.

```json
{
  "host": "smtp.gmail.com",
  "port": 587,
  "username": "test@gmail.com",
  "password": "password",
  "auth": true,
  "tls": true
}
```


> #### Structure for SMTP response.

```json
{
  "id": "UUID",
  "host": "smtp.gmail.com",
  "port": 587,
  "username": "test@gmail.com",
  "auth": true,
  "tls": true
}
```

* *Example above is for example only. In a local test, the information corresponding to
  your host.*

| Attribute| Description                      |   Type  |
|----------|----------------------------------|:-------:|
| id       | SMTP ID saved.                   |   UUID  |
| host     | SMTP of the host used.           |  String |
| port     | Host communication port.         | Integer |
| username | Recipient email.                 |  String |
| password | Recipient email password.        |  String |
| auth     | Mandatory host authentication..  | Boolean |
| tls      | Host TLS.                        | Boolean |
| text     | Email body.                      |  String |

---

> #### Structure for email request.

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

| Attribute | Description                       | Required |
|-----------|-----------------------------------| :-------:|
| smtp      | SMTP UUID configured.             | Yes      |
| ownerRef  | Owner of the terminal used in MS. | Yes      |
| emailFrom | Sending email.                    | Yes      |
| emailTo   | Recipient email.                  | Yes      |
| subject   | Subject email.             | Yes      |
| text      | Email body.                       | Yes      |
| dirPart   | Desired attachment directory.     | No       |


> #### Structure for email response.
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

| Attribute     | Description                       | Type          |
|---------------|-----------------------------------|:-------------:|
| emailId       | Email ID saved                    | String        |
| ownerRef      | Owner of the terminal used in MS. | String        |
| emailFrom     | Sending email.                    | String        |
| emailTo       | Recipient email.                  | String        |
| subject       | Subject email.             | String        |
| dirPart       | Desired attachment directory.     | String        |
| smtp          | SMTP ID used when sending.        | UUI           |
| text          | Email body.                       | String        |
| SendDateEmail | Date and time of email sending    | LocalDateTime |
| statusEmail   | ERROR or SENT                     | ENUM          |

---

## Links

- Repository: https://github.com/nahtansmaia/ms-email
- Spring: https://spring.io/projects/spring-boot
- PostgreSQL: https://www.postgresql.org/
- RabbitMQ: https://www.rabbitmq.com/

## License

The code in this project is under the MIT license.
