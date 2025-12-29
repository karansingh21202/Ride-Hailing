package com.ridehailing.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.io.PrintWriter;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Convert JSON from request body to a Java object
    public static <T> T fromJson(Reader reader, Class<T> clazz) {
        return gson.fromJson(reader, clazz);
    }

    // Send a Java object as JSON response
    public static void sendJson(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(obj));
        out.flush();
    }
}
