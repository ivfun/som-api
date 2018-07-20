package org.ivfun.som.dao.impl

import org.ivfun.som.dao.ClientRepository
import org.ivfun.som.model.Client
import org.springframework.stereotype.Repository

@Repository
class ClientRepositoryImpl : ClientRepository {
    override fun add(t: Client) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<Client> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: Client) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: Client) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}