package org.ivfun.som.dao.impl

import org.ivfun.som.dao.SolutionRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Solution
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class SolutionRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : SolutionRepository {
    private var queryUtils = QueryUtils("SOLUTION", "DESCRIPTION")

    override fun add(t: Solution) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Solution> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<Solution>())
    }

    override fun findBy(id: Number): Solution {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Solution>())[0]
    }

    override fun update(t: Solution) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Solution) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}