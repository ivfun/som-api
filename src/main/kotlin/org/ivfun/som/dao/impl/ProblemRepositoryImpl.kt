package org.ivfun.som.dao.impl

import org.ivfun.som.dao.ProblemRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Problem
import org.ivfun.som.model.Solution
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class ProblemRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : ProblemRepository {
    private var queryUtils = QueryUtils("PROBLEM", "DESCRIPTION")

    override fun add(t: Problem) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Problem> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<Problem>())
    }

    override fun findBy(id: Number): Problem {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Problem>())[0]
    }

    override fun update(t: Problem) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Problem) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}