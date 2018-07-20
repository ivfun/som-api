package org.ivfun.som.model

import java.time.LocalDateTime

class OrderHistory: EntityModel() {
    lateinit var order: Order
    lateinit var user: User
    lateinit var dateTime: LocalDateTime
    var status: String = ""
    var postscript: String = ""
}