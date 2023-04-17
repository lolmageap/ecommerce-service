package ecommerce.shop.exception.advice

import ecommerce.shop.exception.ErrorResponse
import ecommerce.shop.exception.ServerException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionAdvice {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(exception: ServerException) : ErrorResponse {
        logger.error { exception.message }
        return ErrorResponse(code = exception.code, message = exception.message)
    }
}