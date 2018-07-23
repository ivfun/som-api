package org.ivfun.som.dao.impl

import org.ivfun.som.dao.WorkOrderRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.WorkOrder
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class WorkOrderRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : WorkOrderRepository {
    private var queryUtils = QueryUtils(
            "CDT_WORK_ORDER",
            "ID_ORDER, ID_USER, DT_TM_UTC_START, DT_TM_UTC_END, VL_TIME_IN_SECONDS, POSTSCRIPT"
    )

    override fun add(t: WorkOrder) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["ID_ORDER"] = t.order.id
        params["ID_USER"] = t.user.id
        params["DT_TM_UTC_START"] = t.dateTimeStart
        params["DT_TM_UTC_END"] = t.dateTimeEnd
        params["VL_TIME_IN_SECONDS"] = t.timeInSeconds
        params["POSTSCRIPT"] = t.postscript

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<WorkOrder> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<WorkOrder>())
    }

    override fun findBy(id: Number): WorkOrder {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<WorkOrder>())[0]
    }

    override fun update(t: WorkOrder) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["ID_ORDER"] = t.order.id
        params["ID_USER"] = t.user.id
        params["DT_TM_UTC_START"] = t.dateTimeStart
        params["DT_TM_UTC_END"] = t.dateTimeEnd
        params["VL_TIME_IN_SECONDS"] = t.timeInSeconds
        params["POSTSCRIPT"] = t.postscript

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: WorkOrder) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}