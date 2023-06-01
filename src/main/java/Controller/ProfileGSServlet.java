package Controller;

import DAO.UserDAO;
import Model.UserGS;
import Model.LopHoc;
import Service.GiaSuService;
import Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/profileGS")
public class ProfileGSServlet extends HttpServlet {
    GiaSuService giaSuService = new GiaSuService();
    LopHocService lopHocService = new LopHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("acc");
    	boolean isLoggedIn = (account != null);
    	
    	// Kiểm tra yêu cầu đăng xuất
	    String logoutParam = req.getParameter("logout");
	    boolean isLogoutRequested = (logoutParam != null && logoutParam.equals("true"));

    	// Xử lý dữ liệu và hiển thị trang thông tin
    	if (isLoggedIn && !isLogoutRequested) {
    	    String username = account.getUsername(); // Lấy username của người dùng
    	    String position = account.getPosition(); // Lấy vai trò của người dùng

    	    UserGS giaSu = giaSuService.getGiaSuByUsername(username);
    	    if (giaSu != null && giaSu.getAccount() != null) {
    	        List<LopHoc> lopHocs = lopHocService.getlopHocByUsernameGS(giaSu.getAccount().getUsername());

    	        req.setAttribute("giaSu", giaSu);
    	        req.setAttribute("lopHocs", lopHocs);
    	        RequestDispatcher dispatcher = req.getRequestDispatcher("/profileGiaSu.jsp");
    	        dispatcher.forward(req, resp);
    	    } else {
    	        // Xử lý khi không tìm thấy gia sư hoặc tài khoản
    	    	resp.sendRedirect("/Web_Tutor1/addInfo.jsp");
    	    }
    	}

    }
}