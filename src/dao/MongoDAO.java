
package dao;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDAO {
    private MongoCollection<Document> collection;

    public MongoDAO() {
        // URI corrigida com parâmetros padrão do Atlas
        String uri = "mongodb+srv://andresoares:root@cluster0.msxhom1.mongodb.net/vendasBoloDB?retryWrites=true&w=majority";
        String dbName = "vendasBoloDB";
        String collectionName = "bolo";

        try {
            // Criar o cliente MongoDB
            MongoClient mongoClient = MongoClients.create(uri);
            // Acessar o banco de dados
            MongoDatabase database = mongoClient.getDatabase(dbName);
            // Obter a coleção
            collection = database.getCollection(collectionName);
            System.out.println("Conectado ao MongoDB Atlas com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro de conexão com o MongoDB: " + e.getMessage());
            throw new RuntimeException("Falha ao conectar ao MongoDB", e);
        }
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void criarBolo(String nome, double preco, int quantidade) {
        Document doc = new Document()
                .append("nome", nome)
                .append("preco", preco)
                .append("quantidade", quantidade);
        collection.insertOne(doc);
    }

    public void atualizarBolo(String id, double novoPreco) {
        try {
            collection.updateOne(Filters.eq("_id", new ObjectId(id)), Updates.set("preco", novoPreco));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
    }

    public void deletarBolo(String id) {
        try {
            collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
    }
}