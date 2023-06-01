package DAO;

import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Model.UserHS;

public class UserHSDAO extends DBconnect {
	TaiKhoanDao accountDao = new TaiKhoanDao();
	public String getNameFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String Name = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT tenHS FROM hocsinh WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            Name = resultSet.getString("tenHS");
	        }
	        return Name;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
	public String getEmailFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String email = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT email FROM hocsinh WHERE username = ?";
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
	//thêm mới học sinh
	 public void insert(UserHS hocSinh) throws SQLException {
		 String query = "INSERT INTO hocsinh (tenHS, gioitinh, diachi, sdt, email, stk, username) VALUES (?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement statement = con.prepareStatement(query);	
		 statement.setString(2, hocSinh.getTenHS());
		 statement.setString(3, hocSinh.getGioitinh());
		 statement.setString(4, hocSinh.getDiachi());
		 statement.setString(5, hocSinh.getSdt());
		 statement.setString(6, hocSinh.getEmail());
		 statement.setString(7, hocSinh.getStk());
		 statement.setString(8, hocSinh.getAccount().getUsername());
		 statement.executeUpdate();
	 }
	 // lấy tt học sinh  theo username
	 public UserHS getByUsername(String username) throws SQLException {
	     String query = "SELECT * FROM hocsinh WHERE username = ?";
	     PreparedStatement statement = con.prepareStatement(query);
	     statement.setString(1, username);
	     ResultSet resultSet = statement.executeQuery();
	     if (resultSet.next()) {
	    	 String tenHS = resultSet.getString("tenHS");
	         String gioitinh = resultSet.getString("gioitinh");
	         String diachi = resultSet.getString("diachi");
	         String sdt = resultSet.getString("sdt");
	         String email = resultSet.getString("email");
	         String stk = resultSet.getString("stk");
	         int idHS = resultSet.getInt("idHS");
	         return new UserHS(idHS, tenHS, gioitinh, diachi, sdt, email, stk, accountDao.getByUsername(username));
	     }
	     return null;
	 }
	 //lấy ra danh sách học sinh
	 public List<UserHS> getAll() throws SQLException {
		 String query = "SELECT * FROM hocsinh";
	     PreparedStatement statement = con.prepareStatement(query);
	     ResultSet resultSet = statement.executeQuery();
	     List<UserHS> hocSinhs = new ArrayList<>();
	     while (resultSet.next()) {
	    	 int idHS = resultSet.getInt("idHS");
	         String tenHS = resultSet.getString("tenHS");
	         String gioitinh = resultSet.getString("gioitinh");
	         String diachi = resultSet.getString("diachi");
	         String sdt = resultSet.getString("sdt");
	         String email = resultSet.getString("email");
	         String stk = resultSet.getString("stk");
	         String username = resultSet.getString("username");
	         UserHS hocSinh = new UserHS(idHS, tenHS, gioitinh, diachi, sdt, email, stk, accountDao.getByUsername(username));
	         hocSinhs.add(hocSinh);	
	     }
	     return hocSinhs;	
	 }
	 public void update(UserHS hocSinh) throws SQLException {
		 String query = "UPDATE hocsinh SET tenHS = ?, gioitinh = ?, diachi = ?, sdt = ?, email = ?, stk = ? WHERE username = ?";
	     PreparedStatement statement = con.prepareStatement(query);
	     statement.setString(1, hocSinh.getTenHS());
	     statement.setString(2, hocSinh.getGioitinh());
	     statement.setString(3, hocSinh.getDiachi());
	     statement.setString(4, hocSinh.getSdt());
	     statement.setString(5, hocSinh.getEmail());
	     statement.setString(6, hocSinh.getStk());
	     statement.setString(7, hocSinh.getAccount().getUsername());
	     statement.executeUpdate();
	 }
	 //xóa 1 học sinh theo username
	 public void delete(String username) throws SQLException {
	 	String query = "DELETE FROM hocsinh WHERE username = ?";
	 	PreparedStatement statement = con.prepareStatement(query);
	    statement.setString(1, username);
	    statement.executeUpdate();
	 }
}