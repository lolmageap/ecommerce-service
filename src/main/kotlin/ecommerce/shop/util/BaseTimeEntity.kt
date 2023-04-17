package ecommerce.shop.util

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseTimeEntity(

        @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @CreatedDate @Column(updatable = false)
        val createdAt: LocalDateTime? = null,

        @LastModifiedDate
        var updatedAt: LocalDateTime? = null,

        @Column(name = "is_deleted")
        var isDeleted: Boolean = false,

        @Column(name = "is_activated")
        var isActivated: Boolean = true,
        )