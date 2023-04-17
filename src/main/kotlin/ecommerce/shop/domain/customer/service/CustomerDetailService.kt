package ecommerce.shop.domain.customer.service

import ecommerce.shop.domain.customer.dto.CustomerDetail
import ecommerce.shop.domain.customer.entity.Customer
import ecommerce.shop.domain.customer.repository.CustomerRepository
import ecommerce.shop.exception.NotFoundCustomerException
import mu.KotlinLogging
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomerDetailService(private val customerRepository: CustomerRepository) : UserDetailsService {

    private val log = KotlinLogging.logger {}

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        log.info(">>> 회원 정보 찾기, {}", email)

        val customer: Customer = customerRepository.findByEmail(email)
                ?: throw NotFoundCustomerException("회원 정보를 찾을 수 없습니다.$email")

        return CustomerDetail(customer)
    }

}