## Desenvolvimento de uma API para cadastro de clientes com Autenticação e Segurança nas Rotas

Este projeto envolve a criação de uma API para cadastro de clientes e contatos, onde será possível, cadastrar, editar, consultar e excluir. Para acesso a aplicação deve-se implementar o método de autenticação [JWT](https://jwt.io/).

### Requisitos Essenciais

- Utilizar framework NestJs do node.js com Typescript;
- Utilizar banco relacional, preferencialmente postgreSQL;
- Utilizar algum ORM, preferencialmente Prisma.io;
- Integrar com API do [ViaCep](https://viacep.com.br/);
- Instruções de instalação e configuração no arquivo README.md;

### Requisitos Funcionais

- Ser possível cadastro um usuário com nome, e-email, CPF e senha;
- Cada usuário pode cadastrar um cliente composto por nome, cpf/cnpj, email, endereço e contatos;
- Para cadastro de endereço informar apenas CEP, número residencial e complemento (opcional). Para as demais informações pegar do retorno da API;
- Cada cliente pode ter vários contatos;
- Cada cliente pode ter apenas um usuário;
- Cada usuário pode visualizar apenas seus clientes;
- Não permitir CPF ou CNPJ duplicados;

## Critérios de Avaliação:

- Estrutura e arquitetura adotadas para o desenvolvimento do desafio;
- Clareza e qualidade do código fonte;
- Desempenho e funcionalidade do produto final;
- Conformidade com os padrões RESTfull;

### Pontos Extras

- Padrão de projeto utilizando DDD (Domain Driven Design);
- Endpoints mapeados no Postman;
- Documentação da API com Swagger;
- Uso de variáveis de ambiente específicas para cada ambiente de execução;
- Front-end com React;

### Docs de apoio

- [Typescript](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)
- [NestJs](https://docs.nestjs.com/)
- [Prisma](https://docs.nestjs.com/recipes/prisma)
- [Postman](https://www.postman.com/downloads/)
- [ViaCep](https://viacep.com.br/)