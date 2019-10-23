package management.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Servlet Filter implementation class BaseBackFilter
 */
@WebFilter(
		urlPatterns= {"/*"}
		)
public class BaseBackFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BaseBackFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		System.out.println("BaseBackServlet");
		
		//http://localhost:8080/test/
		String contextPath = req.getServletContext().getContextPath();//形如/test
		System.out.println(contextPath);
		String uri = req.getRequestURI();//形如/test/2432424.jsp?asdasd
		System.out.println(uri);
		uri = StringUtils.remove(uri, contextPath);
		
		if(uri.startsWith("/admin")) {//admin_ProductImage_add
			String servletPath = StringUtils.substringBetween(uri,"_", "_") + "Servlet";
			String method =  StringUtils.substringAfterLast(uri,"_" );//取出方法
			//封装到请求头
			req.setAttribute("method", method);
			System.out.println("/"+servletPath);
			req.getRequestDispatcher("/"+servletPath).forward(req, rep);//请求转发
			return;
		}
		System.out.println("方法放行");
 		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
