package repositorio;

import model.Cena;
import model.Save;

import java.sql.*;

public class SaveDAO {
    public static Save novoJogo() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql ="INSERT INTO saves(id_cena_atual) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if (generatedKeys.next()){
            save.setIdSave(generatedKeys.getInt(1));
            save.setCenaatual(CenaDAO.FindCenaById(1));

        }
        return save;
    }
    public static Save findSaveById(Integer idSave) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM saves WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Save save = new Save();
            save.setIdSave(rs.getInt("id_save"));

            // Carrega a cena atual associada ao save
            Integer idCenaAtual = rs.getInt("id_cena_atual");
            Cena cenaAtual = CenaDAO.FindCenaById(idCenaAtual);
            save.setCenaatual(cenaAtual);

            return save;
        }

        return null;  // Retorna null se o save não for encontrado
    }

    public static boolean resetSaveToInitialScene(Integer idSave) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "UPDATE saves SET id_cena_atual = 1 WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idSave);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;  // Retorna true se a atualização foi bem-sucedida
    }
    public static boolean saveCurrentGame(Integer idSave, Integer idCenaAtual) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "UPDATE saves SET id_cena_atual = ? WHERE id_save = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCenaAtual); // Atualiza a cena atual no banco
        stmt.setInt(2, idSave);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;  // Retorna true se a atualização foi bem-sucedida
    }
}
