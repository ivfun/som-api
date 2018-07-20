package org.ivfun.som.dao.impl

import org.ivfun.som.dao.EquipmentRepository
import org.ivfun.som.model.Equipment
import org.springframework.stereotype.Repository

@Repository
class EquipmentRepositoryImpl : EquipmentRepository {
    override fun add(t: Equipment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<Equipment> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): Equipment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: Equipment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: Equipment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}