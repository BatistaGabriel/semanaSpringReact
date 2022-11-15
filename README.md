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
