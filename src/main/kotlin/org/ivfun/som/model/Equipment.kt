package org.ivfun.som.model

class Equipment: EntityModel() {
    lateinit var client: Client
    lateinit var model: Model
    var serialNumber: String = ""
    var description: String = ""
}