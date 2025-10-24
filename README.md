SistemaVendasBolo

Um sistema simples para gerenciamento de vendas de bolos, desenvolvido em Java, utilizando MongoDB Atlas para persistência de dados e Redis Cloud para cache do último bolo cadastrado.

Estrutura do Projeto

SistemaVendasBolo/
├── src/
│   ├── main/
│   │   └── Main.java           # Classe principal com menu interativo
│   ├── dao/
│   │   ├── MongoDAO.java       # Classe de acesso ao MongoDB
│   │   └── RedisDAO.java       # Classe de cache no Redis
│   └── model/
│       └── Bolo.java           # Classe modelo para objetos Bolo

Pacotes





main: Contém a classe Main.java, responsável pelo menu interativo e integração com as camadas de acesso a dados (DAO).



dao: Contém classes responsáveis pela comunicação com o banco de dados (MongoDAO.java para MongoDB) e cache (RedisDAO.java para Redis).



model: Contém a classe Bolo.java, que representa a entidade Bolo com seus atributos.

Funcionalidades





Cadastrar Bolo: Adiciona um novo bolo ao MongoDB e armazena o último bolo cadastrado no Redis para acesso rápido.



Listar Bolos: Exibe todos os bolos cadastrados no MongoDB e o último bolo armazenado no cache Redis.



Atualizar Bolo: Permite atualizar o preço de um bolo existente com base em seu ID.



Deletar Bolo: Remove um bolo do MongoDB pelo ID.



Sair: Encerra a conexão com o Redis e finaliza o sistema.

Tecnologias Utilizadas





Java: Linguagem principal do projeto.



MongoDB Atlas: Banco de dados NoSQL para persistência de dados.



Redis Cloud: Sistema de cache para armazenar o último bolo cadastrado.



Maven: Gerenciador de dependências (recomendado para configurar as bibliotecas do MongoDB e Redis).

Pré-requisitos





JDK 11 ou superior



Conta no MongoDB Atlas com um cluster configurado



Conta no Redis Cloud com instância ativa



Maven para gerenciamento de dependências

Configuração





Configurar MongoDB Atlas:





Crie um cluster no MongoDB Atlas.



Obtenha a string de conexão e configure-a em MongoDAO.java.



Configurar Redis Cloud:





Crie uma instância no Redis Cloud.



Configure as credenciais (host, porta, senha) em RedisDAO.java.



Dependências Maven: Adicione as dependências abaixo ao arquivo pom.xml:

<dependencies>
    <!-- MongoDB Java Driver -->
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongodb-driver-sync</artifactId>
        <version>4.11.0</version>
    </dependency>
    <!-- Jedis (Redis Client) -->
    <dependency>
        <groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
        <version>5.1.0</version>
    </dependency>
</dependencies>



Compilar e Executar:





Compile o projeto: mvn clean install



Execute a aplicação: java -cp target/SistemaVendasBolo.jar main.Main

Uso





Inicie o sistema executando a classe Main.



Use o menu interativo para:





Cadastrar um novo bolo (nome, preço, etc.).



Listar todos os bolos e verificar o cache.



Atualizar o preço de um bolo existente.



Deletar um bolo pelo ID.



Sair do sistema.

Exemplo de Menu

Sistema de Vendas de Bolos
1. Cadastrar Bolo
2. Listar Bolos
3. Atualizar Bolo
4. Deletar Bolo
5. Sair
Escolha uma opção:



🎬🔗 [Link youtube](https://youtu.be/Hq6k5NQPaF8) 

---

## 👨‍💻 Autor  

**Projeto desenvolvido por Marcos André dos Santos Soares**
