package org.ivfun.som.dao.impl

import org.ivfun.som.dao.EquipmentRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Equipment
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class EquipmentRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : EquipmentRepository {
    private var queryUtils = QueryUtils("EQUIPMENT", "ID_CLIENT, ID_MODEL, SERIAL_NUMBER, DESCRIPTION")

    override fun add(t: Equipment) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["ID_CLIENT"] = t.client.id
        params["ID_MODEL"] = t.model.id
        params["SERIAL_NUMBER"] = t.serialNumber
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Equipment> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<Equipment>())
    }

    override fun findBy(id: Number): Equipment {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Equipment>())[0]
    }

    override fun update(t: Equipment) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["ID_CLIENT"] = t.client.id
        params["ID_MODEL"] = t.model.id
        params["SERIAL_NUMBER"] = t.serialNumber
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Equipment) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}