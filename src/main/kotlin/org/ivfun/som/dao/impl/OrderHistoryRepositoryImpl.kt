package org.ivfun.som.dao.impl

import org.ivfun.som.dao.OrderHistoryRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.OrderHistory
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class OrderHistoryRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : OrderHistoryRepository {
    private var queryUtils = QueryUtils("CDT_ORDER_HISTORY", "ID_ORDER, ID_USER, DT_TM_UTC, STATUS, POSTSCRIPT")

    override fun add(t: OrderHistory) {
        var query = this.queryUtils.getInsertQuery()

        var params = hashMapOf<String, Any>()
        params["ID_ORDER"] = t.order.id
        params["ID_USER"] = t.user.id
        params["DT_TM_UTC"] = t.dateTime
        params["STATUS"] = t.status
        params["POSTSCRIPT"] = t.postscript

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<OrderHistory> {
        var query = this.queryUtils.getListQuery()
        return jdbcTemplate.query(query, hashMapOf<String, Any>(), BeanPropertyRowMapper<OrderHistory>())
    }

    override fun findBy(id: Number): OrderHistory {
        var query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<OrderHistory>())[0]
    }

    override fun update(t: OrderHistory) {
        var query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["ID_ORDER"] = t.order.id
        params["ID_USER"] = t.user.id
        params["DT_TM_UTC"] = t.dateTime
        params["STATUS"] = t.status
        params["POSTSCRIPT"] = t.postscript

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: OrderHistory) {
        var query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}