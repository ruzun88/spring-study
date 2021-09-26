package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtil(request);
    }

    private void printHeaderUtil(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 Start ---");
        System.out.println("[Host 편의 조회]");

        System.out.println("request.getServerName() = " + request.getServerName()); // host header
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println( cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- Req Line Start ---");
        System.out.println("RequestHeaderServlet.printStartLine");

        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("--- Req Line END ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("### Req Header Start ###");
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName = " + headerName);
//        }
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));
        System.out.println("### Req Header END ###");
        System.out.println();
    }
}
