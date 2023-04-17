package ecommerce.shop.domain.customer.dto

import ecommerce.shop.domain.customer.entity.Customer
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class CustomerDetail(val customer: Customer) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities: MutableList<GrantedAuthority> = ArrayList()

        // 퍼미션 목록
        val permissionAuthority: GrantedAuthority = SimpleGrantedAuthority(customer.permission.name)
        authorities.add(permissionAuthority)

        // 역할 목록
        val roleAuthority: GrantedAuthority = SimpleGrantedAuthority("ROLE_" + customer.role.name)
        authorities.add(roleAuthority)
        return authorities
    }

    override fun getPassword(): String? {
        return customer.password
    }

    override fun getUsername(): String? {
        return customer.name
    }

    override fun isAccountNonExpired(): Boolean {
        return customer.isActivated
    }

    override fun isAccountNonLocked(): Boolean {
        return customer.isActivated
    }

    override fun isCredentialsNonExpired(): Boolean {
        return customer.isActivated
    }

    override fun isEnabled(): Boolean {
        return customer.isActivated
    }
}