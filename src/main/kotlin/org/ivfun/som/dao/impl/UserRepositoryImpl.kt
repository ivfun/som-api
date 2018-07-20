package org.ivfun.som.dao.impl

import org.ivfun.som.dao.UserRepository
import org.ivfun.som.model.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    override fun add(t: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}