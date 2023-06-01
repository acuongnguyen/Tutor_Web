package Service;

import DAO.UserDAO;
import Model.UserGS;

import java.sql.SQLException;
import java.util.List;

public class GiaSuService {
    UserDAO giaSuDAO = new UserDAO();
    public void insertGiaSu(UserGS giaSu) {
        try {
            giaSuDAO.insert(giaSu);
            System.out.println("Thêm thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm: " + e.getMessage());
        }
    }

    //Lấy tt GS theo username thông qua giaSuDAO
    public UserGS getGiaSuByUsername(String username) {
        try {
            UserGS GiaSu = giaSuDAO.getByUserName(username);
            if (GiaSu != null) {
                return GiaSu;
            } else {
                System.out.println("Không tìm thấy GS có Username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn: " + e.getMessage());
        }
        return null;
    }

    public List<UserGS> getAllGiaSus() {
        try {
            List<UserGS> giaSus = giaSuDAO.getAll();
            return giaSus;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách : " + e.getMessage());
        }
        return null;
    }

    //Lấy ds GS theo lever thông qua đối tượng giaSuDAO
    public List<UserGS> getGiaSusByLever(int lever) {
        try {
            List<UserGS> giaSus = giaSuDAO.getAllByLever(lever);
            return giaSus;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách : " + e.getMessage());
        }
        return null;
    }

    public void updateGiaSu(UserGS GiaSu) {
        try {
            giaSuDAO.update(GiaSu);
            System.out.println("Cập nhật thông tin thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật thông tin: " + e.getMessage());
        }
    }

//    public void deleteGiaSu(String idGS) {
//        try {
//            giaSuDAO.(idGS);
//            System.out.println("Xóa học sinh thành công!");
//        } catch (SQLException e) {
//            System.out.println("Lỗi khi xóa học sinh: " + e.getMessage());
//        }
//    }
}