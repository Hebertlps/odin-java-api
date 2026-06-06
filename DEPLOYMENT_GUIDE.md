# 🚀 Guia Completo de Deployment - Odin Java API

## Opção 1: Deploy no Railway.app (RECOMENDADO - 5 minutos)

### Passo 1: Criar conta no Railway
1. Acesse https://railway.app
2. Clique em "Start Project"
3. Faça login com GitHub

### Passo 2: Conectar repositório
1. Clique em "New Project"
2. Selecione "Deploy from GitHub repo"
3. Autorize o Railway a acessar seu GitHub
4. Selecione o repositório `odin-java-api`

### Passo 3: Configurar variáveis de ambiente
1. No dashboard do Railway, vá para "Variables"
2. Adicione as seguintes variáveis:
   ```
   DB_HOST=oracle.fiap.com.br
   DB_PORT=1521
   DB_SID=ORCL
   DB_USER=seu_usuario_fiap
   DB_PASS=sua_senha_fiap
   ```

### Passo 4: Deploy automático
- O Railway detectará o Dockerfile automaticamente
- Clique em "Deploy"
- Aguarde 3-5 minutos
- Seu link será: `https://odin-java-api-production.up.railway.app`

---

## Opção 2: Deploy no Render.com (Alternativa)

### Passo 1: Criar conta
1. Acesse https://render.com
2. Clique em "Get Started"
3. Faça login com GitHub

### Passo 2: Criar Web Service
1. Clique em "New +"
2. Selecione "Web Service"
3. Conecte seu repositório GitHub
4. Configure:
   - **Name**: `odin-java-api`
   - **Root Directory**: `odin-api`
   - **Dockerfile Path**: `odin-api/Dockerfile`
   - **Instance Type**: Free ou Starter

### Passo 3: Adicionar variáveis
Vá para "Environment" e adicione:
```
DB_HOST=oracle.fiap.com.br
DB_PORT=1521
DB_SID=ORCL
DB_USER=seu_usuario_fiap
DB_PASS=sua_senha_fiap
```

### Passo 4: Deploy
- Clique em "Deploy Web Service"
- Seu link será: `https://odin-java-api.onrender.com`

---

## Opção 3: Deploy Local com Docker

### Pré-requisitos
- Docker instalado
- Docker Compose instalado

### Executar localmente
```bash
cd /tmp/odin-java-api

# Configurar variáveis de ambiente
export DB_HOST=oracle.fiap.com.br
export DB_PORT=1521
export DB_SID=ORCL
export DB_USER=seu_usuario_fiap
export DB_PASS=sua_senha_fiap

# Build e run
docker-compose up --build

# Acessar a API
# Swagger: http://localhost:8080/swagger-ui.html
# API Docs: http://localhost:8080/api-docs
```

---

## Verificar se o Deploy foi bem-sucedido

### Testar endpoints
```bash
# Substituir URL pela sua URL de deploy
BASE_URL=https://seu-deploy-url.com

# Health Check
curl $BASE_URL/actuator/health

# Swagger UI
curl $BASE_URL/swagger-ui.html

# API Docs
curl $BASE_URL/api-docs
```

### Endpoints disponíveis
- `GET /api/v1/clientes` - Listar clientes
- `POST /api/v1/clientes` - Criar cliente
- `GET /api/v1/clientes/{id}` - Obter cliente
- `PUT /api/v1/clientes/{id}` - Atualizar cliente
- `DELETE /api/v1/clientes/{id}` - Deletar cliente

---

## Troubleshooting

### Erro: "Build failed"
- Verificar se o Dockerfile está correto
- Verificar se o `build.gradle` tem todas as dependências
- Verificar logs do build

### Erro: "Connection refused"
- Verificar se as variáveis de ambiente estão corretas
- Verificar se o banco de dados está acessível
- Verificar logs da aplicação

### Erro: "Port already in use"
- Mudar a porta no docker-compose.yml
- Ou parar o container anterior: `docker-compose down`

---

## Links Úteis

- Railway: https://railway.app
- Render: https://render.com
- Docker: https://www.docker.com
- Spring Boot: https://spring.io/projects/spring-boot
- Swagger: https://swagger.io

---

## Suporte

Se tiver dúvidas:
1. Verificar os logs do deployment
2. Consultar documentação do Railway/Render
3. Verificar configuração do banco de dados FIAP
