# O.D.I.N. - Orbital Debris Identification Network (Java API)

## Alunos
- Hebert Lopes do santos (RM: 563192)
- Marcus Vinícius Vila Nova da Silva (RM: 558771)
- Nicolas Monteiro Ramiro (RM: 562380)

## Descrição
API RESTful desenvolvida em Spring Boot para o projeto O.D.I.N., um sistema de monitoramento orbital para detectar e prevenir colisões com lixo espacial.

## Tecnologias
- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- Oracle Database
- Swagger/OpenAPI
- Bean Validation

## Como Executar
1. Configure as variáveis de ambiente:
   - `DB_HOST`: oracle.fiap.com.br
   - `DB_PORT`: 1521
   - `DB_SID`: ORCL
   - `DB_USER`: rm562380
   - `DB_PASS`: 040207
2. Execute `./gradlew bootRun`
3. Acesse o Swagger em `http://localhost:8080/swagger-ui.html`
