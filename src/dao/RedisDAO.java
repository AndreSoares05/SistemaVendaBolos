
package dao;



import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;

public class RedisDAO {
    private UnifiedJedis jedis;

    public RedisDAO() {
        // Configuração da conexão com Redis Cloud
        JedisClientConfig config = DefaultJedisClientConfig.builder()
                .user("default") // Substitua pelo usuário correto, se diferente
                .password("yMrvqL0RzZMzbUVOIlmBXJrxYGYe2nP5") // Substitua pela senha correta do Redis Cloud
                .build();

        jedis = new UnifiedJedis(
            new HostAndPort("redis-16389.crce207.sa-east-1-2.ec2.redns.redis-cloud.com", 16389),
            config
        );

        // Teste inicial da conexão
        try {
            String ping = jedis.ping();
            if ("PONG".equals(ping)) {
                System.out.println("Conectado ao Redis Cloud!");
            } else {
                throw new RuntimeException("Falha ao conectar ao Redis: Ping falhou");
            }
        } catch (Exception e) {
            System.err.println("Erro de conexão com Redis: " + e.getMessage());
            throw new RuntimeException("Falha ao conectar ao Redis", e);
        }
    }

    public void cacheBolo(String chave, String valor) {
        jedis.set(chave, valor);
    }

    public String getCachedBolo(String chave) {
        return jedis.get(chave);
    }

    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }
}