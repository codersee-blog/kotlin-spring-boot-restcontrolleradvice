package com.codersee.restcontrolleradvice.controller

import com.codersee.restcontrolleradvice.model.FirstCustomException
import com.codersee.restcontrolleradvice.model.FourthCustomException
import com.codersee.restcontrolleradvice.model.SecondCustomException
import com.codersee.restcontrolleradvice.model.ThirdCustomException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExampleAdvice {

    @ExceptionHandler(FirstCustomException::class)
    fun handleFirstCustomException() {
        println("FirstCustomException handler")
    }

    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    @ExceptionHandler(SecondCustomException::class)
    fun handleSecondCustomException() {
        println("SecondCustomException handler")
    }

    @ExceptionHandler(ThirdCustomException::class)
    fun handleThirdCustomException(ex: ThirdCustomException) {
        println("ThirdCustomException handler. Exception message: ${ex.message}")
        throw ex
    }

    @ExceptionHandler(FourthCustomException::class)
    fun handleFourthCustomException(
        req: HttpServletRequest,
        ex: FourthCustomException
    ): ExceptionResponseBody {
        println("FourthCustomException handler. Request details: [${req.getHeader("custom-header")}]")
        return ExceptionResponseBody(errorMessage = ex.message)
    }

    data class ExceptionResponseBody(val errorMessage: String?)
}