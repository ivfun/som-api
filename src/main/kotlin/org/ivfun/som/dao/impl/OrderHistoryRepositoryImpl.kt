package org.ivfun.som.dao.impl

import org.ivfun.som.dao.OrderHistoryRepository
import org.ivfun.som.model.OrderHistory
import org.springframework.stereotype.Repository

@Repository
class OrderHistoryRepositoryImpl : OrderHistoryRepository {
    override fun add(t: OrderHistory) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<OrderHistory> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): OrderHistory {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: OrderHistory) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: OrderHistory) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}