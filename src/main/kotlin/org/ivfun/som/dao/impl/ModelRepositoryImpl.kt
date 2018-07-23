package org.ivfun.som.dao.impl

import org.ivfun.som.dao.ModelRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Model
import org.ivfun.som.model.Problem
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class ModelRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : ModelRepository {
    private var queryUtils = QueryUtils("CDT_MODEL", "DESCRIPTION")

    override fun add(t: Model) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Model> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<Model>())
    }

    override fun findBy(id: Number): Model {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Model>())[0]
    }

    override fun update(t: Model) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Model) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}