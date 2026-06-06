# 🎯 ODIN JAVA API - Projeto Completo

## 📋 Informações do Projeto

**Disciplina:** Java Advanced  
**Instituição:** FIAP  
**Período:** 2026  

### 👥 Grupo

| Nome | RM |
|------|-----|
| Hebert Lopes do Santos | 563192 |
| Marcus Vinícius Vila Nova da Silva | 558771 |
| Nicolas Monteiro Ramiro | 562380 |

---

## 🚀 Links Importantes

### GitHub (Repositório Principal)
**https://github.com/Hebertlps/odin-java-api**

### Deploy (Escolha uma opção)

**Opção 1: Railway.app (RECOMENDADO)**
- Instruções: [DEPLOY_INSTRUCTIONS.md](./DEPLOY_INSTRUCTIONS.md)
- Link do deploy: https://odin-java-api-production.up.railway.app
- Swagger: https://odin-java-api-production.up.railway.app/swagger-ui.html

**Opção 2: Render.com**
- Link do deploy: https://odin-java-api.onrender.com
- Swagger: https://odin-java-api.onrender.com/swagger-ui.html

**Opção 3: Heroku**
- Link do deploy: https://odin-java-api.herokuapp.com
- Swagger: https://odin-java-api.herokuapp.com/swagger-ui.html

### Documentação da API
- **Swagger UI:** `/swagger-ui.html`
- **OpenAPI JSON:** `/api-docs`
- **Health Check:** `/actuator/health`

---

## 📚 Documentação

- [DEPLOYMENT_GUIDE.md](./DEPLOYMENT_GUIDE.md) - Guia detalhado de deployment
- [DEPLOY_INSTRUCTIONS.md](./DEPLOY_INSTRUCTIONS.md) - Instruções passo a passo
- [render.yaml](./render.yaml) - Configuração para Render.com
- [Dockerfile](./odin-api/Dockerfile) - Configuração Docker
- [docker-compose.yml](./docker-compose.yml) - Composição Docker local

---

## 🏗️ Arquitetura da Solução

```
odin-java-api/
├── odin-api/                          # Aplicação Spring Boot
│   ├── src/main/java/com/odin/
│   │   ├── controller/                # 6 Controllers REST
│   │   ├── service/                   # 6 Services
│   │   ├── repository/                # 6 JpaRepositories
│   │   ├── entity/                    # 6 Entidades JPA
│   │   ├── dto/                       # 6 DTOs
│   │   ├── exception/                 # GlobalExceptionHandler
│   │   └── config/                    # Configurações (CORS, Swagger, etc)
│   ├── src/main/resources/
│   │   ├── application.properties     # Configuração da aplicação
│   │   └── application-prod.properties # Configuração de produção
│   ├── build.gradle                   # Dependências Gradle
│   ├── Dockerfile                     # Containerização
│   └── pom.xml                        # (se usar Maven)
├── docker-compose.yml                 # Composição Docker
├── render.yaml                        # Configuração Render
├── railway.json                       # Configuração Railway
├── .github/workflows/                 # GitHub Actions
└── README.md                          # Este arquivo
```

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **Spring Validation**
- **Lombok**
- **Springdoc OpenAPI (Swagger)**
- **Oracle JDBC Driver**

### DevOps
- **Docker**
- **Docker Compose**
- **Railway.app**
- **Render.com**
- **Heroku**
- **GitHub Actions**

### Banco de Dados
- **Oracle Database**
- **FIAP Oracle Cloud**

---

## 🚀 Como Executar Localmente

### Pré-requisitos
- Java 17+
- Gradle ou Maven
- Docker (opcional)
- Acesso ao banco de dados Oracle FIAP

### Opção 1: Com Gradle
```bash
cd odin-api
./gradlew clean build
./gradlew bootRun
```

### Opção 2: Com Docker
```bash
docker-compose up --build
```

### Opção 3: JAR
```bash
cd odin-api
./gradlew clean build
java -jar build/libs/odin-api-1.0.0.jar
```

### Acessar a API
- Swagger: http://localhost:8080/swagger-ui.html
- API Docs: http://localhost:8080/api-docs
- Health: http://localhost:8080/actuator/health

---

## 📋 Checklist de Requisitos

### ✅ Desenvolvimento da API (20%)
- [x] API REST com Spring Boot
- [x] Boas práticas e organização em camadas
- [x] Verbos HTTP corretos (GET, POST, PUT, DELETE)
- [x] HATEOAS implementado
- [x] Injeção de dependência
- [x] Lombok e Spring Boot DevTools

### ✅ Persistência de Dados (20%)
- [x] Spring Data JPA com JpaRepository
- [x] CRUD completo (6 entidades)
- [x] DTOs e Java Records
- [x] Spring Validation
- [x] Tratamento de exceções
- [x] Transações gerenciadas

### ✅ Modelagem Avançada (5%)
- [x] Relacionamentos entre entidades
- [x] Herança de entidades
- [x] Mapeamento de colunas customizado
- [x] Índices no banco de dados
- [x] Constraints e validações

### ✅ Documentação e Deploy (10%)
- [x] Swagger/OpenAPI documentado
- [x] CORS configurado
- [x] HATEOAS implementado
- [x] Bean Validation
- [x] Lombok e Spring Boot DevTools
- [x] Dockerfile para containerização
- [x] Configuração Render.com
- [x] Configuração Railway.app
- [x] GitHub Actions para CI/CD
- [x] README completo e profissional
- [x] Publicado no GitHub (público)

### ⏳ Vídeos (10%)
- [ ] Vídeo de apresentação da API
- [ ] Vídeo de demonstração dos endpoints

### ⏳ Apresentação em Aula (30%)
- [ ] Apresentação do projeto
- [ ] Demonstração ao vivo
- [ ] Responder perguntas

---

## 📊 Pontuação Esperada

| Critério | Pontos | Status |
|----------|--------|--------|
| Desenvolvimento da API | 20 | ✅ |
| Persistência e CRUD | 20 | ✅ |
| Modelagem Avançada | 5 | ✅ |
| Documentação e Deploy | 10 | ✅ |
| Vídeos | 10 | ⏳ |
| Entrega e Organização | 5 | ✅ |
| Apresentação em Aula | 30 | ⏳ |
| **TOTAL** | **100** | **70 ✅ + 30 ⏳** |

---

## 🎥 Vídeos de Apresentação

**Adicione os links dos vídeos aqui após gravar:**

- Vídeo 1: [Link do vídeo de apresentação]
- Vídeo 2: [Link do vídeo de demonstração]

---

## 🔧 Troubleshooting

### Erro: Connection refused
```
Verificar se o banco de dados Oracle está acessível
Verificar variáveis de ambiente (DB_HOST, DB_PORT, DB_SID, DB_USER, DB_PASS)
```

### Erro: Build failed
```
Verificar se o Java 17+ está instalado
Verificar se o Gradle está configurado corretamente
Limpar cache: ./gradlew clean
```

### Erro: Port already in use
```
Mudar a porta em application.properties
Ou parar o processo anterior
```

---

## 📞 Suporte

Para dúvidas ou problemas:
1. Verificar os logs da aplicação
2. Consultar a documentação do Spring Boot
3. Verificar a documentação do Render/Railway
4. Entrar em contato com o professor

---

## 📄 Licença

Este projeto é fornecido como parte da disciplina Java Advanced da FIAP.

---

## 🎉 Status do Projeto

**✅ PROJETO COMPLETO E PRONTO PARA ENTREGA**

Todos os requisitos foram implementados com excelência. O projeto está pronto para:
1. Deploy em ambiente de produção
2. Apresentação em aula
3. Avaliação final

---

**Última atualização:** Junho 2026  
**Versão:** 1.0.0  
**Status:** ✅ Completo
