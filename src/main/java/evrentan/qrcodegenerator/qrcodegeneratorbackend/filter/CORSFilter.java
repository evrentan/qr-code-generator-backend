package evrentan.qrcodegenerator.qrcodegeneratorbackend.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

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
   * @param servletRequest  HTTP Servlet Request
   * @param servletResponse HTTP Servlet Response
   * @param filterChain     filter chain object from servlet container to filter the request
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, String.join(",", HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.PUT.name(), HttpMethod.PATCH.name(), HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name()));
    response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, String.join(",", HttpHeaders.AUTHORIZATION, HttpHeaders.ORIGIN, HttpHeaders.ACCEPT, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS));
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

    final String origin = request.getHeader(HttpHeaders.ORIGIN);
    if (Objects.nonNull(origin))
      response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);

    if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
      response.getWriter().print(HttpStatus.OK.name());
      response.getWriter().flush();
    } else {
      filterChain.doFilter(request, response);
    }
  }
}
