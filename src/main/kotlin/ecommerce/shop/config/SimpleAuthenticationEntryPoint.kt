package ecommerce.shop.config

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class SimpleAuthenticationEntryPoint : AuthenticationEntryPoint {

    val XML_HTTP_REQUEST_VALUE = "XMLHttpRequest"
    val X_REQUESTED_WITH_HEADER_KEY = "x-requested-with"
    val CUSTOMER_LOGIN = "/customer/login"

    @Throws(IOException::class, ServletException::class)
    override fun commence(request: HttpServletRequest, response: HttpServletResponse, authException: AuthenticationException?) {
        if (XML_HTTP_REQUEST_VALUE == request.getHeader(X_REQUESTED_WITH_HEADER_KEY)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
            return
        }
        response.sendRedirect(CUSTOMER_LOGIN)
    }

}