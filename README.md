<h1 align="center">🏍️ Projeto Mottu - Gerenciamento Inteligente de Pátios</h1>

<p align="center">
  <strong>Desenvolvido para o Challenge 2025 - 1º Semestre | Disciplina: Java Advanced</strong><br>
  <em>FIAP - 2º Ano - Análise e Desenvolvimento de Sistemas</em>
</p>

---

## 📖 Descrição do Projeto

Este projeto é uma solução desenvolvida com **Java + Spring Boot** que visa atender ao desafio proposto pela empresa **Mottu**, uma startup que atua com aluguel de motos econômicas para entregadores.  
A aplicação tem como objetivo principal implementar uma API REST para dar suporte a **gestão de motos no pátios**, possibilitando uma operação mais eficiente e tecnológica em suas mais de 100 filiais.

---

## 👨‍💻 Integrantes do Grupo

| Nome                                      | RM       | Turma  |
|-------------------------------------------|----------|--------|
| Eduarda Tiemi Akamini Machado             | 554756   | 2TDSPH |
| Felipe Pizzinato Bigatto                  | 555141   | 2TDSPH |
| Gustavo de Oliveira Turci Sandrini        | 557505   | 2TDSPW |

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Bean Validation
- Banco de Dados H2
- Docker
- Swagger/OpenAPI
- Lombok

---

## ✅ Nesse projeto temos

- ✔️ CRUD completo para todas as entidades
- ✔️ Relacionamento entre entidades
- ✔️ Validações com Bean Validation
- ✔️ Paginação e ordenação
- ✔️ Busca por parâmetros
- ✔️ Tratamento centralizado de erros
- ✔️ Utilização de DTOs
- ✔️ Documentação via Swagger
- ✔️ Dockerfile funcional
- ✔️ Scripts para execução em nuvem (Azure CLI)
  
---

### 🧱 Entidades do Projeto

- Bairro -> Parte do endereço, utilizada tanto para clientes quanto para filiais.
- Cidade -> Parte do endereço, utilizada tanto para clientes quanto para filiais.
- Cliente -> Representa os clientes da Mottu que alugam motos.
- Departamento -> Departamentos organizacionais existentes dentro das filiais da Mottu.
- Estado -> Parte do endereço, utilizada tanto para clientes quanto para filiais.
- Filial -> Representa uma unidade física da Mottu responsável pela gestão das motos.
- FilialDepartamento -> Associação entre uma filial e seus respectivos departamentos.
- Funcionario -> Colaboradores que atuam nas filiais da Mottu.
- Logradouro -> Parte do endereço, utilizada tanto para clientes quanto para filiais.
- Manutencao -> Registro de manutenções realizadas nas motos da Mottu.
- Moto -> Motos pertencentes às filiais da Mottu.
- Paíse -> Parte do endereço, utilizada tanto para clientes quanto para filiais.
- Telefone -> Contato telefônico dos clientes da Mottu.

---

## 📦 Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- Docker (opcional, para executar via container)

---
## 🚀 Como Executar o Projeto

### 1️⃣ Clonando o Repositório

```bash
git clone https://github.com/dudatiemiak/projeto-mottu.git
cd projeto-mottu
```

### 2️⃣ Executando com Maven

```bash
mvn clean install
mvn spring-boot:run
```
---

## 📘 Documentação da API

Acesse a documentação da API gerada automaticamente com o Swagger:

🔗 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Acessando o banco de dados H2

### 1️. Inicie o projeto normalmente

```bash
mvn spring-boot:run
```

### 2️. Acesse a inteface H2

Abra o navegador e vá até:

🔗 http://localhost:8080/h2-console

-> Configure ele conforme o application.properties

---

### 💡 Dica: Resetar o banco de dados

Como o projeto utiliza o banco H2 em memória, os dados são reiniciados a cada vez que o projeto é reiniciado. Você pode configurar persistência no arquivo application.properties se desejar manter dados entre sessões.

Ao invés disso:
spring.jpa.hibernate.ddl-auto=create
Troque por isso:
spring.jpa.hibernate.ddl-auto=update

---

## 📌 Rotas da API

### Bairro

| Método | Endpoint                  | Descrição                           |
| ------ | ------------------------- | ----------------------------------- |
| GET    | `/bairros/todos`          | Retorna todos os bairros            |
| GET    | `/bairros/{id_bairro}`    | Retorna um bairro por ID            |
| POST   | `/bairros/inserir`        | Insere um novo bairro               |
| PUT    | `/bairros/atualizar/{id}` | Atualiza um bairro existente por ID |
| DELETE | `/bairros/remover/{id}`   | Remove um bairro por ID             |

### Cidade

| Método | Endpoint                  | Descrição                            |
| ------ | ------------------------- | ------------------------------------ |
| GET    | `/cidades/todas`          | Retorna todas as cidades             |
| GET    | `/cidades/{id_cidade}`    | Retorna uma cidade por ID            |
| POST   | `/cidades/inserir`        | Insere uma nova cidade               |
| PUT    | `/cidades/atualizar/{id}` | Atualiza uma cidade existente por ID |
| DELETE | `/cidades/remover/{id}`   | Remove uma cidade por ID             |

### Cliente

| Método | Endpoint                         | Descrição                                                |
| ------ | -------------------------------- | -------------------------------------------------------- |
| GET    | `/clientes/todos`                | Retorna todos os clientes                                |
| GET    | `/clientes/todos_cacheable`      | Retorna todos os clientes (com cache)                    |
| GET    | `/clientes/paginados`            | Retorna clientes paginados (params: `pagina`, `tamanho`) |
| GET    | `/clientes/{id_cliente}`         | Retorna um cliente por ID                                |
| POST   | `/clientes/inserir`              | Insere um novo cliente                                   |
| PUT    | `/clientes/atualizar/{id}`       | Atualiza um cliente existente por ID                     |
| DELETE | `/clientes/remover/{id}`         | Remove um cliente por ID                                 |
| GET    | `/clientes/buscar_por_substring` | Busca clientes por substring do nome (param: `filtro`)   |

### Departamento

| Método | Endpoint                                     | Descrição                                                       |
| ------ | -------------------------------------------- | --------------------------------------------------------------- |
| GET    | `/departamentos/todos`                       | Retorna todos os departamentos                                  |
| GET    | `/departamentos/todos_cacheable`             | Retorna departamentos com cache                                 |
| GET    | `/departamentos/paginados`                   | Retorna departamentos paginados (params: `pagina`, `tamanho`)   |
| GET    | `/departamentos/buscar_por_nome`             | Busca departamentos pelo nome (`nmDepartamento` como parâmetro) |
| GET    | `/departamentos/{id_departamento}`           | Retorna um departamento por ID                                  |
| POST   | `/departamentos/inserir`                     | Insere um novo departamento                                     |
| PUT    | `/departamentos/atualizar/{id_departamento}` | Atualiza um departamento existente por ID                       |
| DELETE | `/departamentos/remover/{id_departamento}`   | Remove um departamento por ID                                   |

### Estado

| Método | Endpoint                         | Descrição                           |
| ------ | -------------------------------- | ----------------------------------- |
| GET    | `/estados/todos`                 | Retorna todos os estados            |
| GET    | `/estados/{id_estado}`           | Retorna um estado por ID            |
| POST   | `/estados/inserir`               | Insere um novo estado               |
| PUT    | `/estados/atualizar/{id_estado}` | Atualiza um estado existente por ID |
| DELETE | `/estados/remover/{id_estado}`   | Remove um estado por ID             |

### Filial

| Método | Endpoint                         | Descrição                                               |
| ------ | -------------------------------- | ------------------------------------------------------- |
| GET    | `/filiais/todas`                 | Retorna todas as filiais                                |
| GET    | `/filiais/todas_cacheable`       | Retorna filiais com cache                               |
| GET    | `/filiais/paginados`             | Retorna filiais paginadas (params: `pagina`, `tamanho`) |
| GET    | `/filiais/{id_filial}`           | Retorna uma filial por ID                               |
| GET    | `/filiais/busca_por_nome_filial` | Busca filiais pelo nome (`nomeFilial` como parâmetro)   |
| POST   | `/filiais/inserir`               | Insere uma nova filial                                  |
| PUT    | `/filiais/atualizar/{id_filial}` | Atualiza uma filial existente por ID                    |
| DELETE | `/filiais/remover/{id_filial}`   | Remove uma filial por ID                                |

### FilialDepartamento

| Método | Endpoint                                          | Descrição                                               |
| ------ | ------------------------------------------------- | ------------------------------------------------------- |
| GET    | `/filiais_departamentos/todos`                    | Retorna todos os vínculos entre filiais e departamentos |
| GET    | `/filiais_departamentos/todos_cacheable`          | Retorna todos os vínculos com cache                     |
| GET    | `/filiais_departamentos/paginados`                | Paginação de vínculos (params: `pagina`, `tamanho`)     |
| GET    | `/filiais_departamentos/{id_filial_departamento}` | Retorna um vínculo por ID                               |
| POST   | `/filiais_departamentos/inserir`                  | Insere um novo vínculo entre filial e departamento      |
| PUT    | `/filiais_departamentos/atualizar/{id}`           | Atualiza um vínculo existente                           |
| DELETE | `/filiais_departamentos/remover/{id}`             | Remove um vínculo por ID                                |

### Funcionario

| Método | Endpoint                          | Descrição                                                   |
| ------ | --------------------------------- | ----------------------------------------------------------- |
| GET    | `/funcionarios/todos`             | Retorna todos os funcionários                               |
| GET    | `/funcionarios/todos_cacheable`   | Retorna todos os funcionários com cache                     |
| GET    | `/funcionarios/paginados`         | Paginação de funcionários (params: `pagina`, `tamanho`)     |
| GET    | `/funcionarios/{id_funcionario}`  | Retorna um funcionário por ID                               |
| GET    | `/funcionarios/buscar_por_filial` | Busca funcionários por nome da filial (param: `nomeFilial`) |
| GET    | `/funcionarios/buscar_por_cargo`  | Busca funcionários por cargo (param: `cargo`)               |
| POST   | `/funcionarios/inserir`           | Insere um novo funcionário                                  |
| PUT    | `/funcionarios/atualizar/{id}`    | Atualiza um funcionário por ID                              |
| DELETE | `/funcionarios/remover/{id}`      | Remove um funcionário por ID                                |

### Logradouro

| Método | Endpoint                       | Descrição                        |
| ------ | ------------------------------ | -------------------------------- |
| GET    | `/logradouros/todos`           | Retorna todos os logradouros     |
| GET    | `/logradouros/{id_logradouro}` | Retorna um logradouro por ID     |
| POST   | `/logradouros/inserir`         | Insere um novo logradouro        |
| PUT    | `/logradouros/atualizar/{id}`  | Atualiza um logradouro existente |
| DELETE | `/logradouros/remover/{id}`    | Remove um logradouro por ID      |

### Manutencao

| Método | Endpoint                                      | Descrição                                              |
| ------ | --------------------------------------------- | ------------------------------------------------------ |
| GET    | `/manutencoes/todas`                          | Retorna todas as manutenções                           |
| GET    | `/manutencoes/todos_cacheable`                | Retorna todas as manutenções com cache                 |
| GET    | `/manutencoes/paginados`                      | Paginação de manutenções (params: `pagina`, `tamanho`) |
| GET    | `/manutencoes/buscar_todas_ordenada_por_data` | Retorna manutenções ordenadas pela data de entrada     |
| GET    | `/manutencoes/buscar_em_aberto`               | Retorna manutenções que estão em aberto                |
| GET    | `/manutencoes/buscar_por_descricao`           | Busca manutenções por descrição (param: `keyword`)     |
| GET    | `/manutencoes/{id_manutencao}`                | Retorna uma manutenção por ID                          |
| POST   | `/manutencoes/inserir`                        | Insere uma nova manutenção                             |
| PUT    | `/manutencoes/atualizar/{id}`                 | Atualiza uma manutenção existente                      |
| DELETE | `/manutencoes/remover/{id}`                   | Remove uma manutenção por ID                           |

### Moto

| Método | Endpoint                            | Descrição                                                          |
| ------ | ----------------------------------- | ------------------------------------------------------------------ |
| GET    | `/motos/todas`                      | Retorna todas as motos                                             |
| GET    | `/motos/todas_cacheable`            | Retorna todas as motos com cache                                   |
| GET    | `/motos/paginados`                  | Retorna motos paginadas (params: `pagina`, `tamanho`)              |
| GET    | `/motos/{id_moto}`                  | Retorna uma moto por ID                                            |
| POST   | `/motos/inserir`                    | Insere uma nova moto                                               |
| PUT    | `/motos/atualizar/{id_moto}`        | Atualiza os dados de uma moto                                      |
| DELETE | `/motos/remover/{id_moto}`          | Remove uma moto por ID                                             |
| GET    | `/motos/buscar_por_situacao`        | Busca motos pela situação (`situacao` = ENUM)                      |
| GET    | `/motos/buscar_por_placa`           | Busca uma moto pela placa (param: `placa`)                         |
| GET    | `/motos/buscar_por_filial_ordenado` | Busca motos por filial, ordenadas por modelo (param: `nomeFilial`) |

### Pais

| Método | Endpoint                      | Descrição                  |
| ------ | ----------------------------- | -------------------------- |
| GET    | `/paises/todos`               | Retorna todos os países    |
| GET    | `/paises/{id_pais}`           | Retorna um país por ID     |
| POST   | `/paises/inserir`             | Insere um novo país        |
| PUT    | `/paises/atualizar/{id_pais}` | Atualiza um país existente |
| DELETE | `/paises/remover/{id_pais}`   | Remove um país por ID      |

### Telefone

| Método | Endpoint                    | Descrição                               |
| ------ | --------------------------- | --------------------------------------- |
| GET    | `/telefones/todos`          | Retorna todos os telefones              |
| GET    | `/telefones/{id_telefone}`  | Retorna um telefone por ID              |
| POST   | `/telefones/inserir`        | Insere um novo telefone                 |
| PUT    | `/telefones/atualizar/{id}` | Atualiza os dados de um telefone por ID |
| DELETE | `/telefones/remover/{id}`   | Remove um telefone por ID               |

---

<p align="center"> <em>Desenvolvido por alunos do 2º ano de ADS - FIAP | 2025</em> </p> ```
