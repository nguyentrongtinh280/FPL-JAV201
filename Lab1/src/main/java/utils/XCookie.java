package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Base64;

public class XCookie {

    //Doc cookie
    public static Cookie getCookie(String name) {
        HttpServletRequest request = RRSharer.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static Cookie addCookie(String name, String value, int expiry) {
        byte[] bytes = value.getBytes();
        String encodedValue = Base64.getEncoder().encodeToString(bytes);
        Cookie cookie = new Cookie(name, encodedValue);
        cookie.setMaxAge(expiry);
        cookie.setPath("/");
        HttpServletResponse response = RRSharer.getResponse();
        response.addCookie(cookie);
        return cookie;
    }

    public static void deleteCookie(String name) {
        XCookie.addCookie(name, "", 0);
    }
}
