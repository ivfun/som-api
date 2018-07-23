package org.ivfun.som.dao.impl

import org.ivfun.som.dao.OrderRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Order
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class OrderRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : OrderRepository {
    private var queryUtils = QueryUtils("CDT_ORDER", "ID_EQUIPMENT, DT_TM_UTC_START, DT_TM_UTC_END, NF_NUMBER, STATUS")

    override fun add(t: Order) {
        var query = this.queryUtils.getInsertQuery()

        var params = hashMapOf<String, Any>()
        params["ID_EQUIPMENT"] = t.equipment.id
        params["DT_TM_UTC_START"] = t.dateTimeStart
        params["DT_TM_UTC_END"] = t.dateTimeEnd
        params["NF_NUMBER"] = t.nfNumber
        params["STATUS"] = t.status

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Order> {
        var query = this.queryUtils.getListQuery()
        return jdbcTemplate.query(query, hashMapOf<String, Any>(), BeanPropertyRowMapper<Order>())
    }

    override fun findBy(id: Number): Order {
        var query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Order>())[0]
    }

    override fun update(t: Order) {
        var query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["ID_EQUIPMENT"] = t.equipment.id
        params["DT_TM_UTC_START"] = t.dateTimeStart
        params["DT_TM_UTC_END"] = t.dateTimeEnd
        params["NF_NUMBER"] = t.nfNumber
        params["STATUS"] = t.status

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Order) {
        var query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}