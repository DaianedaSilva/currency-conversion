# Conversor de Moedas de Trust

Aplicação para converter a moeda de valores monetários.

# Plano de estudos

## Etapas do projeto de conversão de moedas

O objetivo do conversor de moedas é ser um projeto que permita adquirir e aplicar novos conhecimentos gradualmente. Ao longo de cinco semanas, o projeto evoluirá a fim de propor um novo desafio a cada semana.

> Se possível, recomendamos investir um tempo para tentar aprender testes automatizados. Eles ajudarão ao longo de todas as etapas, validando cada incremento da solução e evitando alteração de comportamento sem previsibilidade.

> _"Acceptance tests are critical in an agile environment because they answer the questions, “How do I know when I am done?” for developers and “Did I get what I wanted?” for users."_
>
> Humble, Jez; Farley, David. Continuous Delivery (Addison-Wesley Signature Series (Fowler)) (p. 85). Kindle Edition.

### Semana 1: Resolver o problema utilizando conhecimento Kotlin
Pensando em resolução em um formato mais simples mesmo, utilizando um terminal e aplicando conhecimento de Kotlin.

### Semana 2: Utilizar Spring Boot para desenvolver um endpoint
Transformar o conversor desenvolvido na semana 1 em uma api web, expondo um endpoint que realize a mesma operação proposta na etapa anterior. 

### Semana 3: Utilizar MongoDB para desenvolver uma persistência de dados
Persistir as taxas de câmbio em uma coleção MongoDB. Talvez versionar as taxas de câmbio por data, permitindo conversões retroativas.

### Semana 4: Resolver o problema utilizando uma API externa
Consumir uma API real que forneça taxas de câmbio atualizadas e utilizar isso na resolução do problema. Sugestões:
- [Frankfurter](https://www.frankfurter.app/docs/)
- [Lista de outras APIs públicas de taxa de câmbio](https://github.com/public-apis/public-apis#currency-exchange)

### Semana 5: Dockerizar a aplicação
Dockerizar a aplicação permitirá entender as vantagens trazidas pelos containers para os projetos de software modernos. Também facilitará o entendimento do papel dos containers na infraestrutura da Creditas.

---

## Material de apoio

Separamos alguns conteúdos que podem ser utilizados para auxiliar na resolução do problema ou para praticar conceitos:

### Kotlin
- https://youtube.com/playlist?list=PLM8_o_MDe-LElQqV-SZtlyGt8l7iz770r
- https://play.kotlinlang.org/koans/overview
- https://exercism.io/tracks/kotlin
- https://github.com/aceleradora-TW/trilha-de-exercicios/tree/master/src/java/specs

### Testes unitários
- https://spin.atomicobject.com/2018/10/07/kotlin-unit-testing/
- https://bugfender.com/blog/how-to-write-unit-tests-for-kotlin/ 

### Spring Boot
- https://www.baeldung.com/spring-boot
- https://www.youtube.com/watch?v=iNeYefuqj-E&t=102s
- https://youtube.com/playlist?list=PLM8_o_MDe-LEas_XSKIyaFAp_MS__5j4p

### MongoDB
- https://university.mongodb.com/courses/M001/about
- https://fabiano-goes.medium.com/crud-api-rest-com-kotlin-spring-e-mongodb-521a8676f43a
- https://medium.com/techwasti/spring-boot-mongodb-rest-api-using-kotlin-47e49729bb21

### Docker
- https://github.com/gomex/docker-para-desenvolvedores
- https://github.com/guirisnik/docker-training
- https://www.kodekloud.com/p/docker-labs
