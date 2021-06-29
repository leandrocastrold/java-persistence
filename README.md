<h2> Persistência de Dados em Java </h2>

Projeto com exemplos de persistência de dados (MySQL), utilizando JDBC, Hibernate (JPA), linguagem JPQL, entre outros. Desenvolvido para testar conhecimentos recém-adquiridos com o tema.
O projeto consiste em CRUDs e consultas mais avançadas, utilizando SQL, JPA e JPQL.

Tecnologias utilizadas (até agora)

* Java 11
* IntelliJ IDEA
* Maven 3.6.3
* MySQL Connector (Driver MySQL para JDBC)
* JDBC 
* Hibernate (JPA)

<h3>Instalação</h3>

Para baixar o projeto na sua máquina, use o comando:

```
git clone https://github.com/leandrocastrold/java-persistence.git
```
<h3>Configuração</h3>

<strong>JDBC</strong>
<p>
O projeto utiliza o driver MySQL para conexão com o banco. Para utilizar outro banco, baixe o driver correspondente e insira sua dependência no arquivo <i>Pom.xml</i>, na seção <i>Dependency</i>.

Acesse a classe <i>ConnectionFactory</i> e altere a string de conexão, usuário e senha. </p>

<strong>Hibernate - JPA</strong>

<p> Acesse o arquivo <i>persistence.xml</i> para alterar as configurações do banco de dados.
</p>

<h3>Execução</h3>

<strong><i>JDBC</i></strong>
<p> Inicialize a aplicação pela classe <i>JDBCApplication</i> para executar o <i>examplejdbc</i>.
</p>

<strong><i>Hibernate - JPA</i></strong>
<p>Inicialize a aplicação pela classe <i>HibernateApplication</i> para executar o <i>examplehibernate</i> utilizando consultas simples com JPA.
</p>

<strong><i>Hibernate - JPQL</i></strong>
<p>Inicialize a aplicação pela classe <i>JPQLApplication</i> para executar o <i>examplehibernate</i> utilizando consultas em JPQL.
</p>

<strong><i>Hibernate - Criteria API</i></strong>
<p>Inicialize a aplicação pela classe <i>CriteriaAPIApplication</i> para executar o <i>examplehibernate</i> utilizando consultas com Criteria API.
</p>

