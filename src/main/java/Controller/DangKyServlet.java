package Controller;

import DAO.DangKyDAO;
import DAO.UserHSDAO;
import Model.TaiKhoan;
import Model.DangKy;
import Model.UserHS;
import Model.LopHoc;
import Service.LopHocService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/dangKy")
public class DangKyServlet extends HttpServlet {
    DangKyDAO dangKyDAO = new DangKyDAO();
    UserHSDAO hocSinhDAO = new UserHSDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idLH = req.getParameter("id");
        HttpSession session = req.getSession();
        TaiKhoan account = (TaiKhoan) session.getAttribute("account");
        LopHoc lopHoc = new LopHoc();
        lopHoc.setIdLH(idLH);
        try {
            UserHS hocSinh = hocSinhDAO.getByUsername(account.getUsername());
            if (dangKyDAO.checkDangKy(lopHoc.getIdLH(), hocSinh.getAccount().getUsername()) == null) {
                DangKy dangKy = new DangKy(0, new Date(), "new", "new", lopHoc, hocSinh);
                dangKyDAO.insert(dangKy);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        resp.sendRedirect("/lopHoc");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}