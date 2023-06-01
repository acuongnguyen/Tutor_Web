package DAO;

import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Model.UserGS;

public class UserDAO extends DBconnect {
    TaiKhoanDao taikhoanDao = new TaiKhoanDao();
    MonHocDAO monHocDAO = new MonHocDAO();
	public String getNameFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String Name = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT tenGS FROM giasu WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            Name = resultSet.getString("tenGS");
	        }
	        return Name;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
	//lấy email của gia sư theo username
	public String getEmailFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String email = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT email FROM giasu WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            email = resultSet.getString("email");
	        }
	        return email;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
	// Thêm GS
    public void insert(UserGS giaSu) throws SQLException {
        String query = "INSERT INTO giasu (tenGS, gioitinh, diachi, sdt, email, stk, idMH, username, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, giaSu.getTenGS());
        statement.setString(2, giaSu.getGioitinh());
        statement.setString(3, giaSu.getDiachi());
        statement.setString(4, giaSu.getSdt());
        statement.setString(5, giaSu.getEmail());
        statement.setString(6, giaSu.getStk());
        statement.setString(7, giaSu.getMonHoc().getIdMH());
        statement.setString(8, giaSu.getAccount().getUsername());
        statement.setString(9, giaSu.getImg());
        statement.executeUpdate();
    }
    //thêm thông tin mới sau đăng kí
    public void saveGiaSu(UserGS giaSu) {
        try {
            String sql = "INSERT INTO gia_su (tenGS, gioitinh, diachi, sdt, email, username) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement = con.prepareStatement(sql);
            statement.setString(1, giaSu.getTenGS());
            statement.setString(2, giaSu.getGioitinh());
            statement.setString(3, giaSu.getDiachi());
            statement.setString(4, giaSu.getSdt());
            statement.setString(5, giaSu.getEmail());
            statement.setString(6, giaSu.getAccount().getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
  //Lấy tt GS theo username
    public UserGS getByUserName(String username) throws SQLException {
        String query = "SELECT * FROM giasu WHERE username = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            int idGS = resultSet.getInt("idGS");
            return new UserGS(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), taikhoanDao.getByUsername(username));
        }
        return null;
    }
  //Lấy tt GS theo idGS
    public UserGS getById(int idGS) throws SQLException {
        String query = "SELECT * FROM giasu WHERE idGS = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, idGS);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String username = resultSet.getString("username");
            return new UserGS(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), taikhoanDao.getByUsername(username));
        }
        return null;
    }
    
  //Lấy ds tất cả các GS
    public List<UserGS> getAll() throws SQLException {
        String query = "SELECT * FROM giasu";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<UserGS> giaSus = new ArrayList<>();
        while (resultSet.next()) {
            int idGS = resultSet.getInt("idGS");
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String username = resultSet.getString("username");
            UserGS giaSu = new UserGS(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), taikhoanDao.getByUsername(username));
            giaSus.add(giaSu);
        }
        return giaSus;
    }
  //Lấy ds các GS theo lever, truy xuất tt từ bảng giasu và monhoc
    public List<UserGS> getAllByLever(int lever) throws SQLException {
        String query = "SELECT * FROM giasu join monhoc on giasu.idMH = monhoc.idMH where lever = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, lever);

        ResultSet resultSet = statement.executeQuery();
        List<UserGS> giaSus = new ArrayList<>();
        while (resultSet.next()) {
            int idGS = resultSet.getInt("idGS");
            String tenGS = resultSet.getString("tenGS");
            String gioiTinh = resultSet.getString("gioitinh");
            String img = resultSet.getString("img");
            String diaChi = resultSet.getString("diachi");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("stk");
            String idMH = resultSet.getString("idMH");
            String username = resultSet.getString("username");
            UserGS giaSu = new UserGS(idGS, tenGS, gioiTinh, img, diaChi, sdt, email, stk, monHocDAO.getById(idMH), taikhoanDao.getByUsername(username));
            giaSus.add(giaSu);
        }
        return giaSus;
    }

  //Cập nhật tt GS theo idGS
    public void update(UserGS giaSu) throws SQLException {
        String query = "UPDATE giasu SET tenGS = ?, gioitinh = ? , diachi = ?, sdt = ?, email = ?, stk = ?, idMH = ?, img = ? WHERE username = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(9, giaSu.getAccount().getUsername());
        statement.setString(1, giaSu.getTenGS());
        statement.setString(2, giaSu.getGioitinh());
        statement.setString(3, giaSu.getDiachi());
        statement.setString(4, giaSu.getSdt());
        statement.setString(5, giaSu.getEmail());
        statement.setString(6, giaSu.getStk());
        statement.setString(7, giaSu.getMonHoc().getIdMH());
        statement.setString(8, giaSu.getImg());
        statement.executeUpdate();
    }
  //xóa 1 gia su theo username
  	 public void delete(String username) throws SQLException {
  	 	String query = "DELETE FROM giasu WHERE username = ?";
  	 	PreparedStatement statement = con.prepareStatement(query);
  	    statement.setString(1, username);
  	    statement.executeUpdate();
  	 }
}