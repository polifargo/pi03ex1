package br.senac.tads.pi03.dao;

import br.senac.tads.pi03.db.utils.ConnectionUtils;
import br.senac.tads.pi03.models.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoContato {

    public static void inserir(String nomeContato, String nascContato,
            String telefoneContato, String emailContato, String horario) 
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO contatos (nome, nascimento, telefone, email, horario) VALUES (?, ?, ?, ?, ?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, nomeContato);
            preparedStatement.setString(2, nascContato);
            preparedStatement.setString(3, telefoneContato);
            preparedStatement.setString(4, emailContato);
            preparedStatement.setString(5, horario);

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
        public static ArrayList<Contato> getListaContatos() {
        ArrayList<Contato> listaContatos = new ArrayList<Contato>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM contatos ORDER BY nome";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Contato contato;
            while (rs.next()) {
                contato = new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("nascimento"),
                        rs.getString("telefone"), rs.getString("email"), rs.getString("horario"));
                listaContatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaContatos;
    }
}
