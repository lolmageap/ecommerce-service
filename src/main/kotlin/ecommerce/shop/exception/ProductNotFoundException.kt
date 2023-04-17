package ecommerce.shop.exception

import ecommerce.shop.exception.ServerException

class ProductNotFoundException (
        override val message: String
) : ServerException(code = 404, message = message)