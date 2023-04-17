package ecommerce.shop.exception

class DuplicatedAdminUserException(
        override val message: String,
        ) : ServerException(code = 404, message = message)