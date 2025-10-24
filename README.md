SistemaVendasBolo

📌 Descrição do Projeto

O SistemaVendasBolo é um sistema simples e robusto para gerenciamento de vendas de bolos, desenvolvido em Java, utilizando MongoDB Atlas para persistência de dados e Redis Cloud para cache do último bolo cadastrado. O sistema foi aprimorado para suportar categorias de bolos, oferecer melhor tratamento de erros e apresentar um menu interativo mais intuitivo.

📂 Estrutura do Projeto

SistemaVendasBolo/
├── src/
│   │   │   ├── main/
│   │   │   │   └── Main.java          # Classe principal com menu interativo
│   │   │   ├── dao/
│   │   │   │   ├── MongoDAO.java      # Classe de acesso ao MongoDB
│   │   │   │   └── RedisDAO.java      # Classe de cache no Redis
│   │   │   └── model/
│   │   │       └── Bolo.java          # Classe modelo para objetos Bolo
│   │   └── resources/
│   │       └── config.properties      # Configurações de conexão (MongoDB e Redis)
└── README.md                              # Documentação do projeto

🗄️ Pacotes





main: Contém Main.java, responsável pelo menu interativo e integração com as camadas de acesso a dados (DAO).



dao: Contém MongoDAO.java (comunicação com MongoDB Atlas) e RedisDAO.java (cache com Redis Cloud).



model: Contém Bolo.java, que representa a entidade Bolo com atributos como ID, nome, preço, descrição e categoria.

🌟 Funcionalidades





Cadastrar Bolo:





Adiciona um novo bolo ao MongoDB com nome, preço, descrição e categoria.



Armazena o último bolo cadastrado no Redis para acesso rápido.



Listar Bolos:





Exibe todos os bolos cadastrados no MongoDB, organizados por categoria.



Mostra o último bolo armazenado no cache Redis.



Atualizar Bolo:





Permite atualizar nome, preço, descrição ou categoria de um bolo existente com base em seu ID.



Deletar Bolo:





Remove um bolo do MongoDB pelo ID.



Sair:





Encerra a conexão com MongoDB e Redis, finalizando o sistema.

🚀 Tecnologias Utilizadas





Java: Linguagem principal (JDK 11 ou superior).



MongoDB Atlas: Banco de dados NoSQL para persistência.



Redis Cloud: Sistema de cache para o último bolo cadastrado.



Conta no MongoDB Atlas com um cluster configurado.



Conta no Redis Cloud com instância ativa.




🎮 Uso





Inicie o sistema executando a classe Main.



Use o menu interativo para:





Cadastrar um novo bolo (nome, preço, descrição, categoria).



Listar todos os bolos e verificar o cache.



Atualizar um bolo existente pelo ID.



Deletar um bolo pelo ID.



Sair do sistema.

📜 Exemplo de Menu

Sistema de Vendas de Bolos Plus
1. Cadastrar Bolo
2. Listar Bolos
3. Atualizar Bolo
4. Deletar Bolo
5. Sair
Escolha uma opção: 


🎬🔗 [Link youtube](https://youtu.be/9goh9xX4v5k) 

---

## 👨‍💻 Autor  

**Projeto desenvolvido por Marcos André dos Santos Soares**
