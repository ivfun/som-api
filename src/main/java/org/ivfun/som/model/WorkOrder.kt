package org.ivfun.som.model

import java.time.LocalDateTime

class WorkOrder: Entity() {
    lateinit var order: Order
    lateinit var user: User
    lateinit var dateTimeStart: LocalDateTime
    lateinit var dateTimeEnd: LocalDateTime
    var timeInSeconds: String = ""
    var postscript: String = ""
}