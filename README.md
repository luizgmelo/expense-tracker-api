<h1 align="center" style="font-weight: bold;">Expense Tracker</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Como rodar o projeto</a> • 
  <a href="#routes">API Endpoints</a>
</p>

<p align="center">
    <b>API para gerenciar despesas</b>
</p>

<h2 id="tech">💻 Tecnologias</h2>

- Java 21
- Spring Boot
- PostgreSQL

<h2 id="started">🚀 Como rodar o projeto</h2>

- Clone esse repositório ou baixe o .zip na sua máquina
- Abra o projeto na sua IDE preferida
- Instale as dependências utilizando Maven
- Rode o projeto


<h3>Ferramentas necessárias</h3>

- Git
- Java 21+
- Maven
- IDE

<h3>Clone o projeto</h3>

Como clonar o projeto

```bash
git clone url-do-github
```

<h2 id="routes">📍 API Endpoints</h2>
​
| rota | descrição 
|----------------------|-----------------------------------------------------

| <kbd>POST /users/register </kbd>     | registra um usuário veja em [detalhes](#post-register-detail)

| <kbd>POST /users/login </kbd>     | faz o login do usuário veja em [detalhes](#post-login-detail)

| <kbd>GET /expenses </kbd>     | lista as despesas opcional filtro por data veja em [detalhes](#get-expenses-detail)

| <kbd>POST /expenses </kbd>     | cria uma nova despesa veja em [detalhes](#post-expenses-detail)

| <kbd>PUT /expenses/{id} </kbd>     | atualiza os dados de uma despesa veja em [detalhes](#put-expenses-detail)

| <kbd>DELETE /expenses/{id} </kbd>     | remove uma despesa veja em [detahles](#delete-expenses-detail)

<h3 id="post-register-detail">POST /users/register</h3>

**REQUEST**
```json
{
  "name": "Luiz Guilherme",
  "email": "luizguilherme@example.com",
  "password": "44444444"
}
```

**RESPONSE**
```json
{
  "id": "uuid-gerado",
  "name": "Luiz Guilherme",
  "email": "luizguilherme@example.com"
}
```

<h3 id="post-login-detail">POST /users/login</h3>

**REQUEST**
```json
{
  "email": "luizguilherme@example.com",
  "password": "44444444"
}
```

**RESPONSE**
```json
{
  "token": "OwoMRHsaQwyAgVoc3OXmL1JhMVUYXGGBbCTK0GBgiYitwQwjf0gVoBmkbuyy0pSi"
}
```

<h3 id="get-expenses-detail">GET /expenses</h3>

- Opcional Query Param startDate e endDate

- Exemplo: GET /expenses?startDate=2025-09-01&endDate=2025-09-30

**RESPONSE**
```json
[
  {
    "id": "uuid-da-despesa-1",
    "description": "Almoço",
    "category": "Alimentação",
    "amount": 35.00,
    "date": "2025-09-28"
  },
  {
    "id": "uuid-da-despesa-2",
    "description": "Uber para reunião",
    "category": "Transporte",
    "amount": 22.80,
    "date": "2025-09-26"
  }
]
```

<h3 id="post-expenses-detail">POST /expenses</h3>

**REQUEST**
```json
{
  "description": "Café da tarde",
  "category": "Alimentação",
  "amount": 15.50,
  "date": "2025-10-01"
}
```

**RESPONSE**
```json
{
  "id": "uuid-da-nova-despesa",
  "description": "Café da tarde",
  "category": "Alimentação",
  "amount": 15.50,
  "date": "2025-10-01",
  "userId": "uuid-do-usuario-logado"
} 
```

<h3 id="put-expenses-detail">PUT /expenses/{id}</h3>

**REQUEST**
```json
{
  "description": "Almoço com cliente", 
  "category": "Alimentação",
  "amount": 85.00,
  "date": "2025-09-28"
}
```

**RESPONSE**
```json
{
  "id": "uuid-despesa",
  "description": "Almoço com cliente",
  "category": "Alimentação",
  "amount": 85.00,
  "date": "2025-09-28",
  "userId": "uuid-do-usuario-logado"
} 
```

<h3 id="delete-expenses-detail">DELETE /expenses/{id}</h3>
StatusCode: 204 No Content
