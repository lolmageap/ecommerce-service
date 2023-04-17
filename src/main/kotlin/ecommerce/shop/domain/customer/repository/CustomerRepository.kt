package ecommerce.shop.domain.customer.repository

import ecommerce.shop.domain.customer.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByEmail(email: String): Customer?

}