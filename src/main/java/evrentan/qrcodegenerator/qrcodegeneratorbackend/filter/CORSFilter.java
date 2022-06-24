package evrentan.qrcodegenerator.qrcodegeneratorbackend.filter;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CORSFilter class implementing Filter library of Javax Servlet
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 * @since 1.0.0
 */
public class CORSFilter implements Filter {

  /**
   * Generate Byte Array Output Stream according to the given request
   *
   * @param servletRequest HTTP Servlet Request
   * @param servletResponse HTTP Servlet Response
   * @param filterChain filter chain object from servlet container to filter the request
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, PATCH, DELETE, OPTIONS");
    response.setHeader("Access-Control-Max-Age", "3600");

    response.setHeader("Access-Control-Allow-Headers", "Authorization, Origin, Accept, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Collation");
    response.setContentType("application/json");


    if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
        response.getWriter().print(HttpStatus.OK.name());
        response.getWriter().flush();
    } else {
      response.setHeader("Access-Control-Allow-Origin", "*");
      filterChain.doFilter(request, response);
    }
  }
}
