# O.D.I.N. - Orbital Debris Identification Network

## Projeto de Java Advanced - FIAP Global Solution 2026

**Turma:** 2TDS Fevereiro | **Matéria:** Java Advanced

---

## 👥 Informações do Grupo

| Nome | RM |
|------|-----|
| Hebert Lopes do Santos | 563192 |
| Marcus Vinícius Vila Nova da Silva | 558771 |
| Nicolas Monteiro Ramiro | 562380 |

---

## 📋 Descrição do Projeto

O **O.D.I.N. (Orbital Debris Identification Network)** é um sistema de monitoramento orbital desenvolvido para detectar e prevenir colisões com lixo espacial. A solução implementa uma **API REST completa em Java com Spring Boot**, seguindo boas práticas de desenvolvimento, arquitetura em camadas e padrões REST avançados.

### Objetivo

Fornecer uma plataforma robusta e escalável para gerenciamento de satélites, operadores, detritos espaciais, alertas, manobras evasivas e auditoria de operações, garantindo a segurança das missões espaciais.

---

## 🔗 Links Importantes

### 🚀 Deploy Público

**Link de Acesso da API:** [https://odin-java-api.onrender.com](https://odin-java-api.onrender.com)

- **Swagger/OpenAPI:** [https://odin-java-api.onrender.com/swagger-ui/index.html](https://odin-java-api.onrender.com/swagger-ui/index.html)
- **API Docs JSON:** [https://odin-java-api.onrender.com/api-docs](https://odin-java-api.onrender.com/api-docs)
- **Health Check:** [https://odin-java-api.onrender.com/actuator/health](https://odin-java-api.onrender.com/actuator/health)

### 📹 Vídeos de Apresentação

- **Vídeo de Apresentação (10 min):** [Link será fornecido após gravação]
- **Vídeo Pitch (3 min):** [Link será fornecido após gravação]

### 📚 Repositório

- **GitHub:** [https://github.com/Hebertlps/odin-java-api](https://github.com/Hebertlps/odin-java-api)

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17+** - Linguagem de programação
- **Spring Boot 3.3.5** - Framework web
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **Lombok** - Redução de boilerplate
- **Spring Boot DevTools** - Desenvolvimento produtivo

### Banco de Dados
- **Oracle Database** - Banco de dados relacional (FIAP)

### Documentação
- **Springdoc OpenAPI 2.3.0** - Documentação automática
- **Swagger UI** - Interface de teste

### Build
- **Gradle** - Gerenciador de dependências

---

## 📊 Entidades do Sistema

### 1. **Satélite**
Representa um satélite em órbita com coordenadas orbitais (@Embedded).

### 2. **Operador**
Usuário responsável por operações no sistema.

### 3. **Manobra**
Registra operações realizadas em satélites com **chave composta (@EmbeddedId)**.

### 4. **Detrito**
Representa detritos espaciais com **@SecondaryTable** para análise adicional.

### 5. **Alerta**
Notificações de eventos críticos relacionados a satélites e detritos.

### 6. **Auditoria**
**Herança de entidades (SINGLE_TABLE strategy)** com subclasses:
- AuditoriaOperacao
- AuditoriaSatelite

---

## 🏗️ Arquitetura

### Padrão em Camadas

```
┌─────────────────────────────────────┐
│         Controllers REST             │
│    (Verbos HTTP, Status Codes)      │
├─────────────────────────────────────┤
│           Services                   │
│    (Lógica de Negócio)              │
├─────────────────────────────────────┤
│        Repositories (JPA)            │
│    (Acesso a Dados)                 │
├─────────────────────────────────────┤
│      Entidades JPA (ORM)             │
│    (Mapeamento Objeto-Relacional)   │
├─────────────────────────────────────┤
│      Banco de Dados Oracle           │
└─────────────────────────────────────┘
```

### Recursos Implementados

- ✅ **HATEOAS** - Links de navegação nas respostas
- ✅ **DTOs** - Transfer Objects para comunicação
- ✅ **Spring Validation** - Validação de dados de entrada
- ✅ **Exception Handling** - Tratamento padronizado de erros
- ✅ **CORS** - Configurado para acesso externo
- ✅ **Injeção de Dependência** - Gerenciamento automático
- ✅ **Lombok** - Redução de boilerplate
- ✅ **Spring Boot DevTools** - Desenvolvimento facilitado

---

## 🚀 Como Executar Localmente

### Pré-requisitos

- Java 17+
- Gradle 7.0+
- Acesso ao banco Oracle (oracle.fiap.com.br)

### Instalação

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Hebertlps/odin-java-api.git
   cd odin-java-api/odin-api
   ```

2. **Configure o banco de dados:**
   
   Edite `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. **Execute a aplicação:**
   ```bash
   ./gradlew bootRun
   ```

4. **Acesse o Swagger:**
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 📡 Endpoints da API

### Satélites
- `GET /api/v1/satelites` - Listar todos
- `GET /api/v1/satelites/{id}` - Buscar por ID
- `POST /api/v1/satelites` - Criar novo
- `PUT /api/v1/satelites/{id}` - Atualizar
- `DELETE /api/v1/satelites/{id}` - Deletar

### Operadores
- `GET /api/v1/operadores` - Listar todos
- `GET /api/v1/operadores/{id}` - Buscar por ID
- `POST /api/v1/operadores` - Criar novo
- `PUT /api/v1/operadores/{id}` - Atualizar
- `DELETE /api/v1/operadores/{id}` - Deletar

### Manobras
- `GET /api/v1/manobras` - Listar todas
- `GET /api/v1/manobras/{id}` - Buscar por ID
- `POST /api/v1/manobras` - Criar nova
- `PUT /api/v1/manobras/{id}` - Atualizar
- `DELETE /api/v1/manobras/{id}` - Deletar

### Detritos
- `GET /api/v1/detritos` - Listar todos
- `GET /api/v1/detritos/{id}` - Buscar por ID
- `POST /api/v1/detritos` - Criar novo
- `PUT /api/v1/detritos/{id}` - Atualizar
- `DELETE /api/v1/detritos/{id}` - Deletar

### Alertas
- `GET /api/v1/alertas` - Listar todos
- `GET /api/v1/alertas/{id}` - Buscar por ID
- `POST /api/v1/alertas` - Criar novo
- `PUT /api/v1/alertas/{id}` - Atualizar
- `DELETE /api/v1/alertas/{id}` - Deletar

### Auditoria
- `GET /api/v1/auditoria` - Listar todos
- `GET /api/v1/auditoria/{id}` - Buscar por ID
- `POST /api/v1/auditoria` - Criar novo
- `PUT /api/v1/auditoria/{id}` - Atualizar
- `DELETE /api/v1/auditoria/{id}` - Deletar

---

## ✅ Requisitos Atendidos

### Desenvolvimento da API (20%) ✅
- [x] API REST com Java e Spring Boot
- [x] Boas práticas e organização em camadas
- [x] Verbos HTTP corretos
- [x] Request, Response e HTTP Status Code
- [x] HATEOAS implementado
- [x] Injeção de dependência
- [x] Lombok e Spring Boot DevTools

### Persistência de Dados e CRUD (20%) ✅
- [x] Spring Data JPA com JpaRepository
- [x] CRUD completo (6 entidades)
- [x] DTOs e Java Records
- [x] Spring Validation
- [x] Tratamento de exceções

### Modelagem Avançada (5%) ✅
- [x] Herança de entidades (SINGLE_TABLE)
- [x] Chave composta (@EmbeddedId)
- [x] Embedded (@Embedded/@Embeddable)
- [x] Múltiplas tabelas (@SecondaryTable)

### Documentação e Deploy (10%) ✅
- [x] Swagger/OpenAPI documentado
- [x] CORS configurado
- [x] Deploy realizado
- [x] Link público entregue
- [x] README completo

### Entrega e Organização (5%) ✅
- [x] README.md organizado
- [x] Todos os links centralizados
- [x] URL do GitHub

### Vídeos (10%) ⏳
- [ ] Vídeo de apresentação (10 min)
- [ ] Vídeo pitch (3 min)

### Apresentação em Aula (30%) ⏳
- [ ] Apresentação presencial

---

## 📝 Exemplo de Requisição

### Criar um Satélite

```bash
curl -X POST "http://localhost:8080/api/v1/satelites" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "INSAT-3D",
    "combustivelAtual": 500.00,
    "statusOperacional": "ATIVO",
    "coordenada": {
      "latitude": 0.0,
      "longitude": 79.5,
      "altitude": 36000.0,
      "velocidade": 3.07
    },
    "dataLancamento": "2013-09-26"
  }'
```

---

## 📚 Documentação Adicional

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Springdoc OpenAPI](https://springdoc.org/)
- [Lombok Documentation](https://projectlombok.org/)

---

**Última atualização:** Junho 2026  
**Versão:** 1.0.0  
**Status:** ✅ Completo
