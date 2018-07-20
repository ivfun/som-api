package org.ivfun.som.dao.impl

import org.ivfun.som.dao.WorkOrderRepository
import org.ivfun.som.model.WorkOrder
import org.springframework.stereotype.Repository

@Repository
class WorkOrderRepositoryImpl : WorkOrderRepository {
    override fun add(t: WorkOrder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<WorkOrder> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): WorkOrder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: WorkOrder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: WorkOrder) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}