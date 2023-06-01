package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.UserDAO;
import DAO.UserHSDAO;
import Service.GiaSuService;
import Service.LopHocService;
import Model.UserGS;

@WebServlet (urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
	GiaSuService giaSuService = new GiaSuService();
    LopHocService lopHocService = new LopHocService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Kiểm tra xem người dùng đã đăng nhập hay chưa
	    HttpSession session = request.getSession();
	    Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("acc");
	    boolean isLoggedIn = (account != null);

	    // Kiểm tra yêu cầu đăng xuất
	    String logoutParam = request.getParameter("logout");
	    boolean isLogoutRequested = (logoutParam != null && logoutParam.equals("true"));

	    // Xử lý dữ liệu và hiển thị trang chủ
	    if (isLoggedIn && !isLogoutRequested) {
	        // Người dùng đã đăng nhập, hiển thị trang chủ với thông tin người dùng
	        String username = account.getUsername();
	        UserDAO usergs = new UserDAO();
	        UserHSDAO userhs = new UserHSDAO();
	        String Name = null;
	        String email = null;
	        String position = account.getPosition(); // Lấy vai trò của người dùng

	        if (position.equals("giasu")) {
	            // Xử lý thông tin gia sư
	            try {
	                Name = usergs.getNameFromDatabase(username);
	                email = usergs.getEmailFromDatabase(username);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	        } else if (position.equals("hocsinh")) {
	            // Xử lý thông tin học sinh
	        	try {
	                Name = userhs.getNameFromDatabase(username);
	                email = userhs.getEmailFromDatabase(username);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        List<UserGS> list3lv3 = new ArrayList<>();
	        List<UserGS> list4lv3 = new ArrayList<>();
	        List<UserGS> giaSuslv3 = giaSuService.getGiaSusByLever(3);
	        for (int i = 0; i < giaSuslv3.size(); i++) {
	            giaSuslv3.get(i).countLH = lopHocService.countLopByGS(username);
	            if (i < 3) {
	                list3lv3.add(giaSuslv3.get(i));
	            } else if (i < 7) {
	                list4lv3.add(giaSuslv3.get(i));
	            }
	        }

	        List<UserGS> list3lv2 = new ArrayList<>();
	        List<UserGS> list4lv2 = new ArrayList<>();
	        List<UserGS> giaSuslv2 = giaSuService.getGiaSusByLever(2);
	        for (int i = 0; i < giaSuslv2.size(); i++) {
	            giaSuslv2.get(i).countLH = lopHocService.countLopByGS(username);

	            if (i < 3) {
	                list3lv2.add(giaSuslv2.get(i));
	            } else if (i < 7)
	                list4lv2.add(giaSuslv2.get(i));
	        }

	        List<UserGS> list3lv1 = new ArrayList<>();
	        List<UserGS> list4lv1 = new ArrayList<>();
	        List<UserGS> giaSuslv1 = giaSuService.getGiaSusByLever(1);
	        if (giaSuslv1 != null) {
	            for (int i = 0; i < giaSuslv1.size(); i++) {
	                giaSuslv1.get(i).countLH = lopHocService.countLopByGS(username);
	
		            if (i < 3) {
		                list3lv1.add(giaSuslv1.get(i));
		            } else if (i < 7)
		                list4lv1.add(giaSuslv1.get(i));
	            }
	        }
	        request.setAttribute("list3lv3", list3lv3);
	        request.setAttribute("list4lv3", list4lv3);
	        request.setAttribute("list3lv2", list3lv2);
	        request.setAttribute("list4lv2", list4lv2);
	        request.setAttribute("list3lv1", list3lv1);
	        request.setAttribute("list4lv1", list4lv1);
	        request.setAttribute("Name", Name);
	        request.setAttribute("email", email);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/trangchu.jsp");
	        dispatcher.forward(request, response);
	        
	    } else {
	        // Người dùng chưa đăng nhập hoặc yêu cầu đăng xuất, xóa thông tin đăng nhập khỏi session
	        session.removeAttribute("acc");

	        // Chuyển hướng về trang chủ không đăng nhập
	        String jspPath = "/Home.jsp";
	        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
	        rs.forward(request, response);
	    }
	}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
}
