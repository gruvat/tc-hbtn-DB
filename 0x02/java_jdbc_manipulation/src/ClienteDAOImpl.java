import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Connection connect(String urlConexao) throws SQLException {
        return DriverManager.getConnection(urlConexao);
    }

    @Override
    public void createTable(String urlConexao) {
        String SQL = String.format("CREATE TABLE %s (" +
                    "id int," +
                    "nome varchar(255)," +
                    "idade int," +
                    "cpf varchar(255)," +
                    "rg varchar(255)" +
                ")", tableName);
        try {
            Connection conn = connect(urlConexao);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
            //Closing database connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        String SQL = String.format("INSERT INTO %s (id, nome, idade, cpf, rg) VALUES (?, ?, ?, ?, ?)", tableName);
        try {
            Connection conn = connect(url_conexao);
            PreparedStatement stmt = conn.prepareStatement(SQL);
            setStatementValues(stmt, cliente);
            stmt.executeUpdate(SQL);
            //Closing database connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String SQL = String.format("SELECT * FROM %s", tableName);
        try {
            Connection conn = connect(urlConexao);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            //Closing database connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String SQL = String.format("UPDATE %s SET nome=%s idade=%d WHERE id=%d", tableName, name, idade, id);
        try {
            Connection conn = connect(urlConexao);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
            //Closing database connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        String SQL = String.format("DELETE FROM %s WHERE %d", tableName, id);
        try {
            Connection conn = connect(urlConexao);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
            //Closing database connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement setStatementValues(PreparedStatement statement, Cliente cliente) throws SQLException {
        statement.clearParameters();

        statement.setInt(1, cliente.getId());
        statement.setString(2, cliente.getNome());
        statement.setInt(3, cliente.getIdade());
        statement.setString(4, cliente.getCpf());
        statement.setString(5, cliente.getRg());

        return statement;
    }

}
