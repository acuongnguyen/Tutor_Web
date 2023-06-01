package DAO;

import Model.DangKy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DangKyDAO extends DBconnect {
    LopHocDAO lopHocDAO = new LopHocDAO();
    UserHSDAO hocSinhDAO = new UserHSDAO();

    public void insert(DangKy dangKy) throws SQLException {
        String query = "INSERT INTO dangky (thoigianhoc, trangthai, mota, idLH, usernameHS) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setDate(1, new java.sql.Date(dangKy.getThoigian().getTime()));
        statement.setString(2, dangKy.getTrangthai());
        statement.setString(3, dangKy.getMota());
        statement.setString(4, dangKy.getLopHoc().getIdLH());
        statement.setString(5, dangKy.getHocSinh().getAccount().getUsername());
        statement.executeUpdate();
    }
    // lấy thông tin đăng ký lớp học theo idDK
    public DangKy getById(int idDK) throws SQLException {
        String query = "SELECT * FROM dangky WHERE idDK = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, idDK);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String idLH = resultSet.getString("idLH");
            String usernameHS = resultSet.getString("usernameHS");
            Date date = resultSet.getDate("thoigian");
            String trangthai = resultSet.getString("trangthai");
            String mota = resultSet.getString("mota");
            return new DangKy(idDK, date, trangthai, mota, lopHocDAO.getById(idLH), hocSinhDAO.getByUsername(usernameHS));
        }
        return null;
    }
    public DangKy checkDangKy(String idLH, String username) throws SQLException {
        String query = "SELECT * FROM dangky WHERE idLH = ? and usernameHS = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, idLH);
        statement.setString(2, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int idDK = resultSet.getInt("idDK");
            Date date = resultSet.getDate("thoigian");
            String trangthai = resultSet.getString("trangthai");
            String mota = resultSet.getString("mota");
            return new DangKy(idDK, date, trangthai, mota, lopHocDAO.getById(idLH), hocSinhDAO.getByUsername(username));
        }
        return null;
    }

    public List<DangKy> getAll() throws SQLException {
        String query = "SELECT * FROM dangky";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<DangKy> dangKys = new ArrayList<>();
        while (resultSet.next()) {
            int idDK = resultSet.getInt("idDK");
            String idLH = resultSet.getString("idLH");
            String username = resultSet.getString("usernameHS");
            Date date = resultSet.getDate("thoigian");
            String trangthai = resultSet.getString("trangthai");
            String mota = resultSet.getString("mota");
            DangKy dangKy =  new DangKy(idDK, date, trangthai, mota, lopHocDAO.getById(idLH), hocSinhDAO.getByUsername(username));
            dangKys.add(dangKy);
        }
        return dangKys;
    }

    public void update(DangKy dangKy) throws SQLException {
        String query = "UPDATE dangky SET thoigian = ?, trangthai = ?, mota = ?, idLH = ?, usernameHS = ? WHERE idDK = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setDate(1, new java.sql.Date(dangKy.getThoigian().getTime()));
        statement.setString(2, dangKy.getTrangthai());
        statement.setString(3, dangKy.getMota());
        statement.setString(4, dangKy.getLopHoc().getIdLH());
        statement.setString(5, dangKy.getHocSinh().getAccount().getUsername());
        statement.setInt(6, dangKy.getIdDK());
        statement.executeUpdate();
    }


    public void delete(int idDK) throws SQLException {
        String query = "DELETE FROM dangky WHERE idDK = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, idDK);
        statement.executeUpdate();
    }
}
