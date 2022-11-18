# Semana Spring + React

O foco deste repositório é salvar os conteúdos deste bootcamp, nele será desenvolvida uma suite contento:

- um projeto frontend usando reactJS e typescript
- um projeto backend usando spring boot

## Criação do Projeto Frontend

Vamos criar o projeto front usando o comando abaixo:

```bash
yarn create vite frontend --template react-ts
```

Este comando usa o yarn para criar o projeto usando como bundler o [vite](https://dev.to/lixeletto/vite-js-o-build-tool-que-vai-facilitar-a-sua-vida-15ho) e indicamos que será feito em typescrupt pelo argumento **react-ts**

### Executar o projeto

Após criado o projeto navegue para a pasta com o nome do projeto usando o seguinte comando:

```bash
cd frontend
```

Em seguida use o comando **yarn** para que sejam instaladas as dependências contidas no arquivo **package.json**. Após feito isso execute o comando abaixo para rodar o projeto de fato:

```bash
yarn dev
```

---

## Criação do Projeto Backend

Para criação do projeto backend vamos utilizar o **[spring initializer](https://start.spring.io/)** tendo as seguites dependências:

- Web
- JPA
- H2
- Security

Feito isto precisamos adicionar um plugin no arquivo pom.xml, a forma como faremos isso é adicionando a seguind chave dentro do grupo build:

```text
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-resources-plugin</artifactId>
    <version>3.1.0</version><!--$NO-MVN-MAN-VER$ -->
</plugin>
```

Feitos os ajustes vamos precisar utilizar o Maven para dar o update no projeto, faremos usando seguindo a seguinte sequência de passos:

Botão direito no projeto -> Maven -> Update project (force update)

### Banco de dados

Após feita a criação da entidade de mapeamento do banco de dados e feitas as seguintes configurações no arquivo **application.properties**:

```bash
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Podemos acessar o banco de daddos pelo endereço: **http://localhost:8080/h2-console**

Note que ao acessar a url acima para conectar na instância do H2 os dados precisam estar iguais aos configurados no arquivo **application.properties**, ou seja:

```text
- JDB URL = jdbc:h2:mem:testdb
- User Name = sa
```

Feito isso clique no botão **Test Connection** para confirmar que os paramêtros estão corretos, você deverá receber uma mensagem de sucesso, com isso conecte no banco de dados de fato.

---

## Deploy no Netlify

Para realizar o deploy na plataforma, será necessário que as seguintes configurações sejam feitas:

```text
- Base directory: frontend
- Build command: yarn build
- Publish directory: frontend/dist
- Variáveis de ambiente: VITE_BACKEND_URL
```

### Configurações adicionais

```text
Site settings -> Domain Management: (colocar o nome que você quiser)
Deploys -> Trigger deploy
```
