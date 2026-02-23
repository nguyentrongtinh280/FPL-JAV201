package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nhanvien")
public class Bai1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String json = "{" +
                "\"manv\":\"Tinh123\", " +
                "\"hoTen\":\"Nguyễn Trọng Tính\", " +
                "\"gioiTinh\":true," +
                "\"luong\":950.5" +
                "}";

        out.print(json);
        out.flush();
    }
}
