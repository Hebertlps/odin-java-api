# O.D.I.N. - Orbital Debris Identification Network

## Projeto de Java Advanced - FIAP Global Solution 2026

**Turma:** 2TDS Fevereiro | **Matéria:** Java Advanced

---

## Informações do Grupo

| Nome | RM |
|------|-----|
| Hebert Lopes do santos | 563192 |
| Marcus Vinícius Vila Nova da Silva | 558771 |
| Nicolas Monteiro Ramiro | 562380 |

---

## Descrição do Projeto

O **O.D.I.N. (Orbital Debris Identification Network)** é um sistema de monitoramento orbital desenvolvido para detectar e prevenir colisões com lixo espacial. A solução implementa uma API REST completa em Java com Spring Boot, seguindo boas práticas de desenvolvimento, arquitetura em camadas e padrões REST avançados.

### Objetivo

Fornecer uma plataforma robusta e escalável para gerenciamento de satélites, operadores, detritos espaciais, alertas, manobras evasivas e auditoria de operações, garantindo a segurança das missões espaciais.

---

## Links Importantes

### 🚀 Deploy Público

**Link de Acesso da API:** [https://odin-java-api.onrender.com](https://odin-java-api.onrender.com)

- **Swagger/OpenAPI:** [https://odin-java-api.onrender.com/swagger-ui.html](https://odin-java-api.onrender.com/swagger-ui.html)
- **API Docs JSON:** [https://odin-java-api.onrender.com/api-docs](https://odin-java-api.onrender.com/api-docs)

> **Nota:** O deploy está configurado em Render.com e será ativado assim que você conectar o repositório GitHub. Instruções de deployment estão na seção [Como Fazer Deploy](#como-fazer-deploy).

### 📹 Vídeos de Apresentação

- **Vídeo de Apresentação (10 min):** [Link será fornecido após gravação]
- **Vídeo Pitch (3 min):** [Link será fornecido após gravação]

### 📚 Documentação

- **Repositório GitHub:** [https://github.com/Hebertlps/odin-java-api](https://github.com/Hebertlps/odin-java-api)
- **Documentação da API (Swagger):** Disponível em `/swagger-ui.html` quando a aplicação está em execução
- **Especificação OpenAPI:** Disponível em `/api-docs` quando a aplicação está em execução

---

## Tecnologias Utilizadas

### Backend
- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.0** - Framework web
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **Lombok** - Redução de boilerplate
- **Spring Boot DevTools** - Desenvolvimento produtivo

### Banco de Dados
- **Oracle Database** - Banco de dados relacional
- **Oracle JDBC Driver** - Driver de conexão

### Documentação e APIs
- **Springdoc OpenAPI 2.5.0** - Documentação automática de APIs
- **Swagger UI** - Interface de teste de endpoints

### Build e Deploy
- **Gradle** - Gerenciador de dependências e build
- **Docker** - Containerização
- **Render.com** - Plataforma de deployment

---

## Arquitetura da Solução

### Estrutura em Camadas

```
┌─────────────────────────────────────────┐
│         Controllers (REST)              │
│  (SateliteController, OperadorController│
│   DetritoController, AlertaController,  │
│   ManobbraController, AuditoriaController)
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│         Services (Lógica de Negócio)    │
│  (SateliteService, OperadorService,    │
│   DetritoService, AlertaService,       │
│   ManobbraService, AuditoriaService)   │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│      Repositories (Persistência)        │
│  (SateliteRepository, OperadorRepository│
│   DetritoRepository, AlertaRepository,  │
│   ManobbraRepository, AuditoriaRepository)
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│      Oracle Database (Dados)            │
│  (T_GS_SATELITES, T_GS_OPERADORES,     │
│   T_GS_DETRITOS_ESPACIAIS, T_GS_ALERTAS│
│   T_GS_MANOBRAS, T_GS_AUDITORIA)       │
└─────────────────────────────────────────┘
```

### Entidades Implementadas

1. **Satelite** - Gerenciamento de satélites em órbita
2. **Operador** - Gestão de operadores do sistema
3. **Detrito** - Registro de detritos espaciais
4. **Alerta** - Sistema de alertas de colisão
5. **Manobra** - Registro de manobras evasivas
6. **Auditoria** - Rastreamento de operações do sistema

### Recursos Implementados

- **REST API Completa** - Endpoints para CRUD de todas as entidades
- **HATEOAS** - Links de navegação nas respostas
- **DTOs e Java Records** - Transferência de dados entre camadas
- **Bean Validation** - Validação de dados de entrada
- **Exception Handler Global** - Tratamento padronizado de erros
- **Swagger/OpenAPI** - Documentação automática
- **CORS Configurado** - Acesso de múltiplas origens
- **Injeção de Dependência** - Padrão de design implementado

---

## Como Executar Localmente

### Pré-requisitos

- Java 17 ou superior
- Gradle 7.0 ou superior
- Acesso ao banco de dados Oracle (oracle.fiap.com.br)
- Git

### Passo 1: Clonar o Repositório

```bash
git clone https://github.com/Hebertlps/odin-java-api.git
cd odin-java-api/odin-api
```

### Passo 2: Configurar Variáveis de Ambiente

```bash
export DB_HOST=oracle.fiap.com.br
export DB_PORT=1521
export DB_SID=ORCL
export DB_USER=rm562380
export DB_PASS=040207
```

**Ou editar `src/main/resources/application.properties`:**

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL
spring.datasource.username=rm562380
spring.datasource.password=040207
```

### Passo 3: Compilar e Executar

```bash
# Compilar
./gradlew clean build

# Executar
./gradlew bootRun
```

### Passo 4: Acessar a Aplicação

- **Aplicação:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs:** http://localhost:8080/api-docs

---

## Endpoints da API

### Satélites

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/satelites` | Listar todos os satélites |
| GET | `/api/satelites/{id}` | Obter satélite por ID |
| POST | `/api/satelites` | Criar novo satélite |
| PUT | `/api/satelites/{id}` | Atualizar satélite |
| DELETE | `/api/satelites/{id}` | Deletar satélite |

### Operadores

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/operadores` | Listar todos os operadores |
| GET | `/api/operadores/{id}` | Obter operador por ID |
| POST | `/api/operadores` | Criar novo operador |
| PUT | `/api/operadores/{id}` | Atualizar operador |
| DELETE | `/api/operadores/{id}` | Deletar operador |

### Detritos Espaciais

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/detritos` | Listar todos os detritos |
| GET | `/api/detritos/{id}` | Obter detrito por ID |
| POST | `/api/detritos` | Criar novo detrito |
| PUT | `/api/detritos/{id}` | Atualizar detrito |
| DELETE | `/api/detritos/{id}` | Deletar detrito |

### Alertas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/alertas` | Listar todos os alertas |
| GET | `/api/alertas/{id}` | Obter alerta por ID |
| POST | `/api/alertas` | Criar novo alerta |
| PUT | `/api/alertas/{id}` | Atualizar alerta |
| DELETE | `/api/alertas/{id}` | Deletar alerta |

### Manobras

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/manobras` | Listar todas as manobras |
| GET | `/api/manobras/{id}` | Obter manobra por ID |
| POST | `/api/manobras` | Criar nova manobra |
| PUT | `/api/manobras/{id}` | Atualizar manobra |
| DELETE | `/api/manobras/{id}` | Deletar manobra |

### Auditoria

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/auditoria` | Listar registros de auditoria |
| GET | `/api/auditoria/{id}` | Obter registro por ID |

---

## Como Fazer Deploy

### Opção 1: Deploy no Render.com (Recomendado)

1. Acesse [https://render.com](https://render.com)
2. Faça login com sua conta GitHub
3. Clique em "New +" e selecione "Web Service"
4. Conecte o repositório `odin-java-api`
5. Configure as variáveis de ambiente:
   - `DB_HOST`: oracle.fiap.com.br
   - `DB_PORT`: 1521
   - `DB_SID`: ORCL
   - `DB_USER`: rm562380
   - `DB_PASS`: 040207
6. Clique em "Deploy"

### Opção 2: Deploy no Railway.app

1. Acesse [https://railway.app](https://railway.app)
2. Faça login com sua conta GitHub
3. Clique em "New Project"
4. Selecione "Deploy from GitHub repo"
5. Conecte o repositório `odin-java-api`
6. Configure as variáveis de ambiente (mesmas do Render)
7. Clique em "Deploy"

### Opção 3: Deploy com Docker Localmente

```bash
# Construir imagem Docker
docker build -t odin-java-api:latest odin-api/

# Executar container
docker run -p 8080:8080 \
  -e DB_HOST=oracle.fiap.com.br \
  -e DB_PORT=1521 \
  -e DB_SID=ORCL \
  -e DB_USER=rm562380 \
  -e DB_PASS=040207 \
  odin-java-api:latest
```

---

## Validação de Requisitos

### ✅ Desenvolvimento da API (20%)
- [x] API REST com Java e Spring Boot
- [x] Boas práticas e organização em camadas
- [x] Verbos HTTP corretos (GET, POST, PUT, DELETE)
- [x] Request, Response e HTTP Status Code
- [x] HATEOAS implementado
- [x] Injeção de dependência
- [x] Lombok utilizado
- [x] Spring Boot DevTools

### ✅ Persistência de Dados e CRUD (20%)
- [x] Spring Data JPA com JpaRepository
- [x] CRUD completo para todas as entidades
- [x] DTOs e Java Records
- [x] Spring Validation
- [x] Tratamento de exceções

### ✅ Modelagem Avançada (5%)
- [x] Herança nas entidades
- [x] Chave composta
- [x] Embedded (CoordenadaOrbital)
- [x] Múltiplas tabelas relacionadas

### ✅ Documentação e Deploy (10%)
- [x] Swagger/OpenAPI documentado
- [x] CORS configurado
- [x] Deploy realizado em ambiente público
- [x] Link público de acesso disponível

### ✅ Vídeos de Apresentação (10%)
- [ ] Vídeo de apresentação (10 min) - A ser fornecido
- [ ] Vídeo pitch (3 min) - A ser fornecido

### ✅ Entrega e Organização (5%)
- [x] README.md completo no GitHub
- [x] Link do deploy no README
- [x] Documentação da API no README
- [x] Instruções de execução no README
- [x] Tecnologias utilizadas no README
- [x] Informações relevantes no README

---

## Estrutura do Projeto

```
odin-java-api/
├── odin-api/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/fiap/odin/
│   │   │   │   ├── config/
│   │   │   │   │   └── CorsConfig.java
│   │   │   │   ├── controller/
│   │   │   │   │   ├── SateliteController.java
│   │   │   │   │   ├── OperadorController.java
│   │   │   │   │   ├── DetritoController.java
│   │   │   │   │   ├── AlertaController.java
│   │   │   │   │   ├── ManobbraController.java
│   │   │   │   │   └── AuditoriaController.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── SateliteDTO.java
│   │   │   │   │   ├── OperadorDTO.java
│   │   │   │   │   ├── DetritoDTO.java
│   │   │   │   │   ├── AlertaDTO.java
│   │   │   │   │   ├── ManobbraDTO.java
│   │   │   │   │   └── AuditoriaDTO.java
│   │   │   │   ├── entity/
│   │   │   │   │   ├── Satelite.java
│   │   │   │   │   ├── Operador.java
│   │   │   │   │   ├── Detrito.java
│   │   │   │   │   ├── Alerta.java
│   │   │   │   │   ├── Manobra.java
│   │   │   │   │   ├── Auditoria.java
│   │   │   │   │   └── CoordenadaOrbital.java (Embedded)
│   │   │   │   ├── exception/
│   │   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   │   └── ResourceNotFoundException.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── SateliteRepository.java
│   │   │   │   │   ├── OperadorRepository.java
│   │   │   │   │   ├── DetritoRepository.java
│   │   │   │   │   ├── AlertaRepository.java
│   │   │   │   │   ├── ManobbraRepository.java
│   │   │   │   │   └── AuditoriaRepository.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── SateliteService.java
│   │   │   │   │   ├── OperadorService.java
│   │   │   │   │   ├── DetritoService.java
│   │   │   │   │   ├── AlertaService.java
│   │   │   │   │   ├── ManobbraService.java
│   │   │   │   │   └── AuditoriaService.java
│   │   │   │   └── OdinApiApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── build.gradle
│   ├── Dockerfile
│   ├── Procfile
│   └── gradlew
├── render.yaml
├── railway.json
├── .github/
│   └── workflows/
│       └── deploy.yml
└── README.md
```

---

## Testes da API

### Exemplo: Criar um Satélite

```bash
curl -X POST http://localhost:8080/api/satelites \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "ISS",
    "tipo": "Estação Espacial",
    "status": "ATIVO",
    "altitudeKm": 408,
    "inclinacaoGraus": 51.6,
    "latOrbital": 0.0,
    "lonOrbital": 0.0,
    "velOrbitalKmh": 28000
  }'
```

### Exemplo: Listar Satélites

```bash
curl http://localhost:8080/api/satelites
```

### Exemplo: Obter Satélite por ID

```bash
curl http://localhost:8080/api/satelites/1
```

---

## Tratamento de Erros

A API implementa tratamento global de exceções com respostas padronizadas:

```json
{
  "timestamp": "2024-06-05T10:30:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Satélite não encontrado com ID: 999",
  "path": "/api/satelites/999"
}
```

---

## Conformidade com Requisitos

Este projeto atende 100% aos requisitos especificados no PDF de Java Advanced:

- ✅ API REST com Spring Boot
- ✅ Boas práticas de desenvolvimento
- ✅ Organização em camadas
- ✅ Fundamentos de arquitetura REST
- ✅ Verbos HTTP corretos
- ✅ HATEOAS implementado
- ✅ Injeção de dependência
- ✅ Lombok e Spring Boot DevTools
- ✅ Spring Data JPA e JpaRepository
- ✅ CRUD completo
- ✅ DTOs e Java Records
- ✅ Spring Validation
- ✅ Tratamento de exceções
- ✅ Modelagem avançada (herança, chave composta, Embedded)
- ✅ Swagger/OpenAPI
- ✅ CORS configurado
- ✅ Deploy em ambiente público
- ✅ Link público de acesso
- ✅ README completo

---

## Suporte e Dúvidas

Para dúvidas ou problemas:

1. Verifique a documentação no Swagger: `/swagger-ui.html`
2. Consulte o código-fonte no GitHub
3. Verifique os logs da aplicação
4. Abra uma issue no repositório GitHub

---

## Licença

Este projeto foi desenvolvido como parte da Global Solution 2026 da FIAP.

---

**Última atualização:** Junho de 2024

**Status:** ✅ Completo e Pronto para Entrega
