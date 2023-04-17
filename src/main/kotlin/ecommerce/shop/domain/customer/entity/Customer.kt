package ecommerce.shop.domain.customer.entity

import ecommerce.shop.enums.CustomerPermission
import ecommerce.shop.enums.ECommerceRole
import ecommerce.shop.util.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "customers", schema = "ecommerce")
class Customer(

        @Column(name = "name")
        val name: String,

        @Column(name = "phone_number")
        val phoneNumber: String,

        @Column(name = "email")
        val email: String,

        @Column(name = "age")
        val age: Long,

        @Column(name = "password")
        val password: String,

        @Column(name = "address")
        val address: String,

        @Column(name = "role")
        @Enumerated(value = EnumType.STRING)
        val role: ECommerceRole = ECommerceRole.CUSTOMER,

        @Column(name = "permission")
        @Enumerated(value = EnumType.STRING)
        val permission: CustomerPermission

) : BaseTimeEntity() {
}