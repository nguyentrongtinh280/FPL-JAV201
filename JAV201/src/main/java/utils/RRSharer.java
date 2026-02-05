package utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class RRSharer {

    private static Map<Long, HttpServletRequest> requests = new HashMap<>();
    private static Map<Long, HttpServletResponse> responses = new HashMap<>();

    public static void add(HttpServletRequest req, HttpServletResponse resp) {
        requests.put(Thread.currentThread().getId(), req);
        responses.put(Thread.currentThread().getId(), resp);
    }

    public static void remove() {
        requests.remove(Thread.currentThread().getId());
        responses.remove(Thread.currentThread().getId());
    }

    public static HttpServletRequest getRequest() {
        return requests.get(Thread.currentThread().getId());
    }

    public static HttpServletResponse getResponse() {
        return responses.get(Thread.currentThread().getId());
    }
}
