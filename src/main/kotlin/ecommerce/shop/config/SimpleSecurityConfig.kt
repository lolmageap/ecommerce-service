package ecommerce.shop.config

import ecommerce.shop.domain.customer.service.CustomerDetailService
import ecommerce.shop.enums.ECommerceRole
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.lang.String
import kotlin.Exception
import kotlin.Throws

@Configuration
@EnableWebSecurity
class SimpleSecurityConfig(val customerDetailService: CustomerDetailService) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
                .csrf().disable()
                .cors().disable()

        httpSecurity
                .formLogin()
                .loginPage("/customer/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/customer/login?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                .authorizeHttpRequests(Customizer { authorize: AuthorizeHttpRequestsConfigurer<HttpSecurity>
                .AuthorizationManagerRequestMatcherRegistry ->
                    authorize
                            .antMatchers("/cart/**").hasRole(String.valueOf(ECommerceRole.CUSTOMER))
                            .antMatchers("/checkout/**").hasRole(String.valueOf(ECommerceRole.CUSTOMER))
                            .antMatchers("/customer/my-page*").hasRole(String.valueOf(ECommerceRole.CUSTOMER))
                            .antMatchers("/**").permitAll()
                })

        httpSecurity.exceptionHandling().authenticationEntryPoint(SimpleAuthenticationEntryPoint())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService>(customerDetailService).passwordEncoder(passwordEncoder())
    }

}