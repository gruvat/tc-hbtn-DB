import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Connection connect(String urlConexao){
        try {
            return DriverManager.getConnection(urlConexao);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTable(String urlConexao) {
        String SQL = String.format("CREATE TABLE %s (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "nome varchar(255)," +
                    "idade INTEGER," +
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
    public void insert(String url_conexao, Cliente cliente) throws SQLException {
        String SQL = String.format("INSERT INTO '%s' (nome, idade, cpf, rg) VALUES (?, ?, ?, ?)", tableName);
        try {
            Connection conn = connect(url_conexao);
            PreparedStatement stmt = conn.prepareStatement(SQL);
            setStatementValues(stmt, cliente);
            stmt.executeUpdate();
            //Closing database connections
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String SQL = String.format("SELECT * FROM '%s'", tableName);
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
        String SQL = String.format("UPDATE '%s' SET nome = '%s', idade = %d WHERE id = %d", tableName, name, idade, id);
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
        String SQL = String.format("DELETE FROM '%s' WHERE id = %d", tableName, id);
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

        statement.setString(1, cliente.getNome());
        statement.setInt(2, cliente.getIdade());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getRg());

        return statement;
    }

}
