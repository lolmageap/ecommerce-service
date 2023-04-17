package ecommerce.shop.exception

import ecommerce.shop.exception.ServerException

class NotFoundCustomerException(
        override val message: String
) : ServerException(code = 404, message = message)