package repositorio;

import model.Cena;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenaDAO {
    public static Cena FindCenaById(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cena WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if(rs.next()){
            cena.setIdcena(rs.getInt("id_cena"));
            cena.setDescricao(rs.getNString("descricao"));
            cena.setItens(ItemDAO.FindItensByScena(cena));
        }
        return cena;
    }
    public static void insertCena(Cena cena) throws SQLException {
        Connection connection = Mysql.getConnection();
        String insert = "INSERT INTO cena(descricao) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, cena.getDescricao());
        ps.execute();
    }

    public static List<Cena> findAll() throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from cena;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cena> cenas = new ArrayList<>();
        while (resultSet.next()) {
            Cena cena = new Cena();
            cena.setIdcena(resultSet.getInt("id_cena"));
            cena.setDescricao(resultSet.getString("descricao"));

            cenas.add(cena);
        }
        return cenas;
    }

}
