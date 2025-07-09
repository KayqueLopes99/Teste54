import java.sql.*;

public class RailwayPostgresTeste {

    public static void main(String[] args) {
        // Substitua com os dados reais do seu banco no Railway
        String url = "jdbc:postgresql://containers-us-west-38.railway.app:1234/railway";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {

            Statement stmt = conn.createStatement();

            // Criar tabela
            stmt.execute("CREATE TABLE IF NOT EXISTS jogos (" +
                         "id SERIAL PRIMARY KEY," +
                         "titulo VARCHAR(100)," +
                         "disponivel BOOLEAN)");

            // Inserir jogo
            stmt.execute("INSERT INTO jogos (titulo, disponivel) VALUES ('FIFA 25', true)");

            // Ler dados
            ResultSet rs = stmt.executeQuery("SELECT * FROM jogos");

            System.out.println("=== Lista de Jogos ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Disponível: " + rs.getBoolean("disponivel"));
                System.out.println("----------------------");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
