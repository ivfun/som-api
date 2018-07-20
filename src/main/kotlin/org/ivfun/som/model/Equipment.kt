package org.ivfun.som.model

class Equipment: EntityModel() {
    var client: Client? = null
    var model: Model? = null
    var serialNumber: String? = ""
    var description: String? = ""
}