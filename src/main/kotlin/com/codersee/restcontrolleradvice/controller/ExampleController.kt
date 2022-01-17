package com.codersee.restcontrolleradvice.controller

import com.codersee.restcontrolleradvice.model.FirstCustomException
import com.codersee.restcontrolleradvice.model.FourthCustomException
import com.codersee.restcontrolleradvice.model.SecondCustomException
import com.codersee.restcontrolleradvice.model.ThirdCustomException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {

    @GetMapping("/example-exception-one")
    fun getExampleExceptionOne(): ExampleResponseBody {
        throw FirstCustomException("First exception message")
        return ExampleResponseBody(message = "ok")
    }

    @GetMapping("/example-exception-two")
    fun getExampleExceptionTwo(): ExampleResponseBody {
        throw SecondCustomException("Second exception message")
        return ExampleResponseBody(message = "ok")
    }

    @GetMapping("/example-exception-three")
    fun getExampleExceptionThree(): ExampleResponseBody {
        throw ThirdCustomException("Third exception message")
        return ExampleResponseBody(message = "ok")
    }

    @GetMapping("/example-exception-four")
    fun getExampleExceptionFour(): ExampleResponseBody {
        throw FourthCustomException("Fourth exception message")
        return ExampleResponseBody(message = "ok")
    }

    data class ExampleResponseBody(val message: String)
}