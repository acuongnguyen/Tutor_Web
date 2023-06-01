package Service;

import DAO.UserHSDAO;
import Model.UserHS;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HocSinhService {
    private UserHSDAO hocSinhDAO = new UserHSDAO();


    public void insertHocSinh(UserHS hocSinh) {
        try {
            hocSinhDAO.insert(hocSinh);
            System.out.println("Thêm học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm học sinh: " + e.getMessage());
        }
    }

    public UserHS getHocSinhByUsername(String usernameHS) {
        try {
            UserHS hocSinh = hocSinhDAO.getByUsername(usernameHS);
            if (hocSinh != null) {
                return hocSinh;
            } else {
                System.out.println("Không tìm thấy học sinh có Username: " + usernameHS);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<UserHS> getAllHocSinhs() {
        try {
            List<UserHS> hocSinhs = hocSinhDAO.getAll();
            return hocSinhs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

    public void updateHocSinh(UserHS hocSinh) {
        try {
            hocSinhDAO.update(hocSinh);
            System.out.println("Cập nhật học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật học sinh: " + e.getMessage());
        }
    }

    public void deleteHocSinh(String username) {
        try {
            hocSinhDAO.delete(username);
            System.out.println("Xóa học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa học sinh: " + e.getMessage());
        }
    }
}