<h1 align="center">
Desafio Processo Seletivo Super Terminais (Backend)
</h1>

<p align="center">
  <a href="#page_with_curl-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#books-dependencias">Dependencias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#star-requisitos">Requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;  
  <a href="#rocket-começando">Começando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

## :page_with_curl: Sobre
Este repositório contém um sistema baseado em arquitetura Rest Api desenvolvida com Java (17 corretto) e Spring (3.4), banco de dados H2 para a persistência de dados com Spring Data, o spring-validation para fazer as validações necessárias da Api.

## :books: **Dependencias**
**spring-boot-starter-web**: Utilizado para tornar a aplicação web.

**spring-boot-starter-data-jpa**: Utilizado para fazer a integração com o banco de dados e gerenciar a persistência de dados do sistema.

**spring-boot-starter-validation**: Utilizado para as validações das Entidades, DTOs, etc.

**spring-boot-devtools**: Utilizado para o LiveReload do servidor.

**lombok**: Utilizado para gerar Getters, Setters, construtores, reduzir Boilerplate e injeção de dependências.


## :star: Requisitos
- Ter [**Git**](https://git-scm.com/) para clonar o projeto.
- Ter [**Java 17**]() instalado.
- Ter [**Maven**]([https://gradle.org/install/](https://maven.apache.org/download.cgi)) instalado. (Opcional)


## :rocket: Começando
``` bash
  # Clonar o projeto:
  $ git clone https://github.com/felipelago/PortalServicosST-back

```

## :computer: Iniciando o Projeto
```bash
  # Instalar as dependências:
  $ mvn clean install 

  # Rodar a aplicação:
  $ mvn spring-boot:run
```
