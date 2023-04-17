package ecommerce.shop.util

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import javax.persistence.Column

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(
        @CreatedBy @Column(updatable = false)
        private var createdBy: String,

        @LastModifiedBy
        @Column(updatable = false)
        private var lastModifiedBy: String,

) : BaseTimeEntity()