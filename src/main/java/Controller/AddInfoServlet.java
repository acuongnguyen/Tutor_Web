package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDao;
import DAO.UserDAO;
import Model.UserGS;

/**
 * Servlet implementation class AddInfoServlet
 */
@WebServlet(urlPatterns = "/updateGiaSu")
public class AddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO giaSuDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
        giaSuDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
	    Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("accout");
	    TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
		String tenGS = request.getParameter("tenGS");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
	    String username = account.getUsername(); 
        // Tạo một đối tượng GiaSu từ thông tin đã lấy
        UserGS userGS = new UserGS();
        	userGS.setTenGS(tenGS);
        	userGS.setGioitinh(gioiTinh);
        	userGS.setDiachi(diaChi);
        	userGS.setSdt(soDienThoai);
        	userGS.setEmail(email);
        	try {
				userGS.setAccount(taiKhoanDao.getByUsername(username));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        // Lưu dữ liệu vào cơ sở dữ liệu bằng cách gọi phương thức từ DAO
        giaSuDAO.saveGiaSu(userGS);

        // Redirect về trang chính sau khi lưu thành công
        response.sendRedirect("HomeServlet");
	}

}
