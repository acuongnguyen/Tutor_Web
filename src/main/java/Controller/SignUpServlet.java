package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import DAO.SignUpDao;
import Model.TaiKhoan;

/**
 * Servlet implementation class SignUp
 */
@WebServlet(urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 // Phương thức để mã hóa mật khẩu
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

    private byte[] generateSalt() throws NoSuchAlgorithmException {
	    SecureRandom random = SecureRandom.getInstanceStrong();
	    byte[] salt = new byte[16];
	    random.nextBytes(salt);
	    return salt;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mess = request.getParameter("mess");
        if (mess.equals("rePass")){
            mess = "Nhập Lại Mật Khẩu Sai!";
            request.setAttribute("mess", mess);
        } else if (mess.equals("username")){
            mess = "UserName đã có ngươ sử dụng!";
            request.setAttribute("mess", mess);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/signup.jsp");
        dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repass");
		String position = request.getParameter("position");
		try {
			//tạp salt mới
			byte[] salt = generateSalt();
			//mã hóa mật khẩu
			String hashedPassword = hashPassword(pass, salt);
			boolean isGiasu = false;
	        boolean isHocsinh = false;
	        if (position != null) {
	            if (position != null && position.equals("giasu") && !position.isEmpty()) {
	                isGiasu = true;
	            } else {
	                isHocsinh = true;
	            }
	        }
			if(!pass.equals(repass)) {
				String jspPath = "/signup.jsp";
				request.setAttribute("mess", "Mật khẩu không trùng khớp");
				RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				rs.forward(request,response);
			}else {
				SignUpDao sign = new SignUpDao();
				TaiKhoan a = sign.checkAccount(user);
				if(a != null) {
					//duoc sign up
					String jspPath = "/signup.jsp";
					request.setAttribute("mess", "Tài khoản đã tồn tại");
					RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
					rs.forward(request,response);
				} else {
					// day ve trang login
					if(isGiasu) {
						String role = "giasu";
						sign.NewAccount(user, hashedPassword, role, salt);
						String jspPath = "/login.jsp";
//						String jspPath = "/addInfo.jsp";
						RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
						rs.forward(request,response);
					}else if(isHocsinh) {
						String role = "hocsinh";
						sign.NewAccount(user, hashedPassword, role, salt);
						String jspPath = "/login.jsp";
						RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
						rs.forward(request,response);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
	}

}