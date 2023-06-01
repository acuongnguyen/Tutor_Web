package Controller;

import Model.TaiKhoan;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/lopHoc")
public class LopHocServlet extends HttpServlet {
    LopHocService lopHocService = new LopHocService();
    GiaSuService giaSuService = new GiaSuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TaiKhoan account = (TaiKhoan) session.getAttribute("acc");
        List<LopHoc> lopHocs = new ArrayList<>();
        if (account.getPosition().equals("hv")){
            lopHocs = lopHocService.getByUserNameHS(account.getUsername());
        } else if (account.getPosition().equals("gv")){
            UserGS giaSu = giaSuService.getGiaSuByUsername(account.getUsername());
            lopHocs = lopHocService.getlopHocByIdGS(giaSu.getIdGS());
        }
        req.setAttribute("lopHocs", lopHocs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc.jsp");
        dispatcher.forward(req, resp);
    }
}