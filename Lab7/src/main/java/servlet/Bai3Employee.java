package servlet;

import entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.RestIO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/employee/*")
public class Bai3Employee extends HttpServlet {

    private Map<String, Employee> employees = new HashMap<>(Map.of(
            "NV1", new Employee("NV1", "Nguyễn Văn An", true, 500),
            "NV2", new Employee("NV2", "Nguyễn Trọng Tính", true, 700),
            "NV3", new Employee("NV3", "Nguyễn Thị Hồng", false, 1000)
    ));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getPathInfo();
        if(info == null || info.length() == 0) {
            RestIO.writeObject(resp, employees.values());
        } else {
            String id = info.substring(1).trim();
            RestIO.writeObject(resp, employees.get(id));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = RestIO.readObject(req, Employee.class);
        employees.put(employee.getId(), employee);
        RestIO.writeObject(resp, employee);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getPathInfo();
        if (info == null || info.length() <= 1) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String id = info.substring(1).trim();
        Employee employee = RestIO.readObject(req, Employee.class);
        employees.put(id, employee);
        RestIO.writeEmptyObject(resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getPathInfo();
        if (info == null || info.length() <= 1) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String id = info.substring(1).trim();
        employees.remove(id);
        RestIO.writeEmptyObject(resp);
    }
}
