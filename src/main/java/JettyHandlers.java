import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.Callback;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JettyHandlers extends AbstractHandler {
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        System.out.println(request.getRequestURI());
        request.setHandled(true);
        if (request.getRequestURI().equals("/api/account/login")) {
            httpResponse(httpServletResponse, 200, "Вы успешно залогинились в личный кабинет");
        } else if (request.getRequestURI().equals("/api/account/profile")) {
            httpResponse(httpServletResponse, 201, "Это профиль тестового пользователя");
        } else {
            httpResponse(httpServletResponse, 404, "Не знакомый REST API метод");
        }
    }

    private HttpServletResponse httpResponse(HttpServletResponse httpServletResponse, int responseCode, String responseBody) throws IOException {
        httpServletResponse.setStatus(responseCode);
        httpServletResponse.setContentType("text/html; charset=utf-8");
        httpServletResponse.getWriter().println(responseBody);
        return httpServletResponse;
    }
}
///api/account/profile
///api/account/login