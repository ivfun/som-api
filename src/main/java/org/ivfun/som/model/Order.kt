package org.ivfun.som.model

import java.time.LocalDateTime

class Order: Entity() {
    lateinit var equipment: Equipment
    var nfNumber: String = " "
    lateinit var dateTimeStart: LocalDateTime
    lateinit var dateTimeEnd: LocalDateTime
    var status: String = ""
}