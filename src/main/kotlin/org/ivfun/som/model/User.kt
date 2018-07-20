package org.ivfun.som.model

class User: EntityModel() {
    var name: String = ""
    var password: String = ""
    var email: String = ""
    var timezone: String = ""
    var accessLevel: String = ""
}