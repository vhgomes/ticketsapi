# Sistema de Gerenciamento de Tickets

Este projeto é uma aplicação básica de CRUD desenvolvida em Java utilizando Spring Boot e PostgreSQL para gerenciamento de tickets. A aplicação possui três entidades principais: `Setor`, `Status` e `Ticket`.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA (Jakarta Persistence API)
- Lombok
- Banco de Dados: PostgreSQL

## Entidades

### 1. Setor
Representa o setor responsável pelo ticket.

- **Atributos:**
    - `id`: Identificador único do setor.
    - `nome`: Nome do setor.
    - `description`: Descrição do setor.

### 2. Status
Representa o estado atual de um ticket.

- **Atributos:**
    - `id`: Identificador único do status.
    - `status`: Nome do status.
    - `description`: Descrição do status.

### 3. Ticket
Representa o ticket em si, contendo informações sobre o título, descrição, categoria, setor, status e timestamps de criação e atualização.

- **Atributos:**
    - `id`: Identificador único do ticket.
    - `title`: Título do ticket.
    - `description`: Descrição do ticket.
    - `category`: Categoria do ticket.
    - `status`: Status do ticket (relacionamento Many-to-One com a entidade `Status`).
    - `setor`: Setor responsável pelo ticket (relacionamento Many-to-One com a entidade `Setor`).
    - `createdAt`: Data de criação do ticket.
    - `updatedAt`: Data da última atualização do ticket.

## Funcionalidades

Este sistema permite realizar as operações CRUD básicas para as entidades `Setor`, `Status` e `Ticket`:

1. **Criar** - Adicionar novos setores, status e tickets.
2. **Ler** - Consultar os setores, status e tickets existentes.
3. **Atualizar** - Atualizar informações de setores, status e tickets.
4. **Deletar** - Remover setores, status e tickets.

## Como Executar o Projeto

1. Clone o repositório:
    ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

2. Acesse o diretório do projeto:
    ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

3. Configure o banco de dados PostgreSQL no arquivo application.properties ou application.yml:
    ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update

4. Execute a aplicação.

5. Utilize a aplicação utilizando o Postman ou outros serviçoes de chamada de API.

## Autor
Victor Hugo C Gomes
