# O.D.I.N. - Orbital Debris Identification Network (Java API)

## Alunos
- Hebert Lopes do santos (RM: 563192)
- Marcus Vinícius Vila Nova da Silva (RM: 558771)
- Nicolas Monteiro Ramiro (RM: 562380)

## Descrição
API RESTful desenvolvida em Spring Boot para o projeto O.D.I.N., um sistema de monitoramento orbital para detectar e prevenir colisões com lixo espacial. A aplicação implementa boas práticas de desenvolvimento, organização em camadas, persistência com Spring Data JPA e documentação com Swagger/OpenAPI.

## Repositório GitHub
**Link Público:** https://github.com/Hebertlps/odin-java-api

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- Oracle Database
- Swagger/OpenAPI 2.5.0
- Bean Validation (Jakarta Validation)
- Lombok
- Spring Boot DevTools
- Gradle

## Arquitetura

### Camadas da Aplicação
- **Model:** Entidades JPA mapeadas para Oracle (Satelite, Operador, Detrito, Alerta, Manobra, Auditoria)
- **Repository:** Spring Data JPA Repositories para acesso aos dados
- **Service:** Lógica de negócio e orquestração
- **Controller:** Endpoints REST com documentação Swagger
- **DTO:** Data Transfer Objects com Java Records e validações
- **Exception:** GlobalExceptionHandler para tratamento centralizado de erros
- **Config:** Configurações da aplicação

### Entidades Principais
1. **Satelite** - Frota orbital com coordenadas orbitais embarcadas
2. **Operador** - Engenheiros autorizados para manobras
3. **Detrito** - Catálogo de lixo espacial
4. **Alerta** - Histórico de riscos de colisão
5. **Manobra** - Log de evasões realizadas
6. **Auditoria** - Rastreio de ações do sistema

### Relacionamentos
- Alerta → Satelite (ManyToOne)
- Alerta → Detrito (ManyToOne)
- Manobra → Satelite (ManyToOne)
- Manobra → Operador (ManyToOne)
- Auditoria → Operador (ManyToOne)

## Endpoints Disponíveis

### Satélites
- `GET /api/satelites` - Listar com paginação
- `GET /api/satelites/{id}` - Buscar por ID
- `POST /api/satelites` - Criar novo
- `PUT /api/satelites/{id}` - Atualizar
- `DELETE /api/satelites/{id}` - Remover

### Detritos
- `GET /api/detritos` - Listar com paginação
- `GET /api/detritos/{id}` - Buscar por ID
- `POST /api/detritos` - Criar novo
- `PUT /api/detritos/{id}` - Atualizar
- `DELETE /api/detritos/{id}` - Remover

### Operadores
- `GET /api/operadores` - Listar
- `POST /api/operadores` - Criar novo

### Alertas
- `GET /api/alertas` - Listar
- `POST /api/alertas` - Criar novo

### Manobras
- `GET /api/manobras` - Listar
- `POST /api/manobras` - Criar novo

### Auditoria
- `GET /api/auditoria` - Listar ações

## Como Executar

### Pré-requisitos
- Java 17 ou superior
- Gradle 8.0 ou superior
- Oracle Database configurado

### Configuração do Banco de Dados
Configure as variáveis de ambiente:
```bash
export DB_HOST=oracle.fiap.com.br
export DB_PORT=1521
export DB_SID=ORCL
export DB_USER=rm562380
export DB_PASS=040207
```

### Executar a Aplicação
```bash
cd odin-api
./gradlew bootRun
```

A aplicação será iniciada em `http://localhost:8080`

## Documentação da API

Acesse o Swagger UI em: `http://localhost:8080/swagger-ui.html`

A documentação interativa permite testar todos os endpoints diretamente no navegador.

## Validações Implementadas

Todas as DTOs implementam validações com Bean Validation:
- `@NotBlank` - Campos obrigatórios não vazios
- `@NotNull` - Campos obrigatórios
- `@Email` - Validação de email
- `@Size` - Tamanho de strings
- `@Positive` - Valores positivos

## Tratamento de Erros

A aplicação implementa um GlobalExceptionHandler que padroniza todas as respostas de erro com:
- `timestamp` - Data/hora do erro
- `status` - Código HTTP
- `error` - Tipo de erro
- `message` - Descrição do erro

## Boas Práticas Implementadas

- Injeção de Dependência com Spring
- Separação de responsabilidades em camadas
- DTOs para transferência de dados
- Validação de entrada com Bean Validation
- Tratamento centralizado de exceções
- Documentação com Swagger/OpenAPI
- CORS habilitado para acesso externo
- Lombok para redução de boilerplate
- Spring Boot DevTools para desenvolvimento

## Modelagem Avançada

- **Embedded:** CoordenadaOrbital (latitude, longitude, altitude, velocidade)
- **Relacionamentos:** OneToMany e ManyToOne
- **Múltiplas Tabelas:** 6 entidades com relacionamentos complexos

## Informações para Avaliação

- Código-fonte: Disponível no GitHub
- Documentação: Swagger/OpenAPI integrado
- Boas práticas: Organização em camadas, injeção de dependência, validações
- Persistência: Spring Data JPA com Oracle
- Deploy: Pronto para ambiente de produção

## Links Importantes

- **GitHub:** https://github.com/Hebertlps/odin-java-api
- **Swagger UI:** http://localhost:8080/swagger-ui.html (após executar)
- **Documentação API:** http://localhost:8080/v3/api-docs (após executar)

## Próximos Passos

1. Executar a aplicação localmente
2. Testar os endpoints via Swagger
3. Criar vídeo de apresentação (10 min)
4. Criar vídeo pitch (3 min)
5. Apresentar em aula
