# 📦 Projeto Clientes com JPA + Hibernate + Maven

Este é um projeto Java simples utilizando **JPA (Java Persistence API)** com **Hibernate**  e **Maven** para realizar operações de persistência em um banco de dados relacional. O programa funciona por meio de um menu no console, permitindo o cadastro, listagem e busca de clientes.

## 🔧 Tecnologias Utilizadas

- Java 11+ (ou superior)
- JPA (Java Persistence API)
- Hibernate (como provedor ORM)
- Maven (gerenciamento de dependências)
- JDBC + Banco de Dados Relacional (ex: MySQL ou H2)
- `persistence.xml` para configuração da persistência


## 🧱 Estrutura do Projeto

```bash
src/
├── com.projetoclientes.application
│   └── Application.java       # Classe principal com menu interativo no console
├── com.projetoclientes.entities
│   └── Cliente.java           # Entidade JPA mapeada para tabela "clientes"
└── META-INF
    └── persistence.xml        # Configurações do JPA (unidade de persistência)
```

## 📝 Funcionalidades

✔️ Cadastro de novos clientes
✔️ Listagem de todos os clientes cadastrados
✔️ Busca de cliente por ID
✔️ Persistência automática no banco de dados com Hibernate


## 💻 Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/projeto-clientes-jpa.git
```
2. Importe como projeto Maven em sua IDE (Eclipse, IntelliJ, etc.)
3. Verifique o arquivo persistence.xml na pasta src/main/resources/META-INF e ajuste os dados do banco (URL, usuário, senha)
4. Execute a classe Application.java


## 🛠️ Exemplo de persistence.xml

```bash
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
  <persistence-unit name="BancoTeste">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <class>com.projetoclientes.entities.Cliente</class>
    <properties>
      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/bancoteste" />
      <property name="javax.persistence.jdbc.user" value="root" />
      <property name="javax.persistence.jdbc.password" value="senha" />
      <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />

      <!-- Hibernate config -->
      <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
      <property name="hibernate.hbm2ddl.auto" value="update" />
      <property name="hibernate.show_sql" value="true" />
    </properties>
  </persistence-unit>
</persistence>
```
## 📌 Observações

- A aplicação é executada via console.
- Ao encerrar o programa, o EntityManager e Scanner são corretamente fechados.
- O menu é simples e ideal para aprender os fundamentos da persistência com JPA.

## 🤝 Contribuições
Sinta-se à vontade para abrir issues ou fazer pull requests com melhorias no projeto!

## 📜 Licença
Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais informações.


Feito por Isaque Dias
