package com.lukaszsobczak.registerform

import java.io.Serializable

data class Account(
    val prefix: String,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val password: String
): Serializable {
}