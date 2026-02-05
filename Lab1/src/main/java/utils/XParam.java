package utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XParam {

    public static String getString(String name, String defaultValue) {
        HttpServletRequest request = RRSharer.getRequest();
        String value = request.getParameter(name);
        if(value == null) {
            return defaultValue;
        }
        return value;
    }

    public static int getInt(String name, int defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Integer.valueOf(value);
    }

    public static double getDouble(String name, double defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Double.valueOf(value);
    }

    public static boolean getBoolean(String name, boolean defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Boolean.valueOf(value);
    }

    public static Date getDate(String name, String pattern) {
        String value = getString(name, null);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getFile(String name, String folder) {
        HttpServletRequest request = RRSharer.getRequest();
        try {
            Part part = request.getPart(name);
            File dir = new File(request.getServletContext().getRealPath(folder));
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir, part.getSubmittedFileName());
            part.write(file.getAbsolutePath());
            return file;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getBean(Class<T> beanClass) {
        DateTimeConverter dtc = new DateConverter(new Date());
        dtc.setPatterns(new String[]{"MM/dd/yyyy", "yyyy-MM-dd"});
        ConvertUtils.register(dtc, Date.class);
        try {
            T bean = beanClass.getDeclaredConstructor().newInstance();
            HttpServletRequest request = RRSharer.getRequest();
            BeanUtils.populate(bean, request.getParameterMap());
            return  bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
