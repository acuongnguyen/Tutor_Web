package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import DAO.TaiKhoanDao;
import Model.TaiKhoan;

/**
 * Servlet implementation class TaiKhoanServelet
 */
@WebServlet(urlPatterns = "/TaiKhoanServlet")
public class TaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaiKhoanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// khi form đăng nhập ấn nút submit thì nó sẽ truyền về servlet này
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		try {
			TaiKhoanDao acc = new TaiKhoanDao();
			//lấy salt từ csdl
			byte[] encode = acc.getSaltFromDB(user);
			if(encode != null) {
				//mã hóa password dựa trên salt
				String hashedPassword = hashPassword(pass, encode);
				//lấy password đã mã hóa từ csdl để kiểm tra
				String password = acc.getPasswordFromDB(user);
				String position = acc.getPositionFromDB(user);
				TaiKhoan a = acc.checklogin(user, hashedPassword);
				if (a == null) {
				    String jspPath = "/login.jsp";
				    request.setAttribute("mess", "Tài khoản không tồn tại");
				    RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				    rs.forward(request, response);
				} else {
				    HttpSession session = request.getSession();
				    session.setAttribute("acc", a);
				    if (position.equals("admin")) {
				        // Phân quyền cho admin
				        String jspPath = "/Dashboard.jsp";
				        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				        rs.forward(request, response);
				    } else if (position.equals("giasu")) {
				        // Phân quyền cho gia sư
//				    	response.sendRedirect("HomeServlet");
				        String jspPath = "/HomeServlet";
				        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				        rs.forward(request, response);
				    } else if (position.equals("hocsinh")) {
				        // Phân quyền cho học sinh
//				    	response.sendRedirect("HomeServlet");
				        String jspPath = "/HomeServlet";
				        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				        rs.forward(request, response);
				    }else {
				    	String jspPath = "/login.jsp";
				    	request.setAttribute("mess", "Tài khoản không tồn tại");
					    RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
					    rs.forward(request, response);
				    }
				}
			}
			else {
				String jspPath = "/login.jsp";
				RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				rs.forward(request,response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}