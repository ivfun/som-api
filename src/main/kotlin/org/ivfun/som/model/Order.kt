package org.ivfun.som.model

import java.time.LocalDateTime

class Order: EntityModel() {
    lateinit var equipment: Equipment
    lateinit var dateTimeStart: LocalDateTime
    lateinit var dateTimeEnd: LocalDateTime
    var nfNumber: String = ""
    var status: String = ""
}