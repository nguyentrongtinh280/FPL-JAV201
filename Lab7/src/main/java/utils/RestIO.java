package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;


public class RestIO {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String readJson(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        return buffer.toString();
    }


    public static void writeJson(HttpServletResponse resp, String json) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(json);
        resp.getWriter().flush();
    }

    public static <T> T readObject(HttpServletRequest req, Class<T> clazz) throws IOException {
        String json = RestIO.readJson(req);
        T bean = mapper.readValue(json, clazz);
        return bean;
    }

    public static void writeObject(HttpServletResponse resp, Object data) throws IOException {
        String json = mapper.writeValueAsString(data);
        RestIO.writeJson(resp, json);
    }

    public static void writeEmptyObject(HttpServletResponse resp) throws IOException{
        RestIO.writeObject(resp, Map.of());
    }
}
