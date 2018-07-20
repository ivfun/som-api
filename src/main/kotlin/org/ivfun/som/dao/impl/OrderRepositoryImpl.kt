package org.ivfun.som.dao.impl

import org.ivfun.som.dao.OrderRepository
import org.ivfun.som.model.Order
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl : OrderRepository {
    override fun add(t: Order) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<Order> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): Order {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: Order) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: Order) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}