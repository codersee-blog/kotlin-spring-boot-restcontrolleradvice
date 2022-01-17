package com.codersee.restcontrolleradvice.model

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class FirstCustomException(message: String) : RuntimeException(message)
class SecondCustomException(message: String) : RuntimeException(message)

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ThirdCustomException(message: String) : RuntimeException(message)

class FourthCustomException(message: String) : RuntimeException(message)