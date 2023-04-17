package ecommerce.shop.exception

import ecommerce.shop.exception.ServerException

class NotFoundAdminUserException(
        override val message: String
) : ServerException(code = 404, message = message)