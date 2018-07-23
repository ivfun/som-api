package org.ivfun.som.dao.impl

import org.ivfun.som.dao.ClientRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Client
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

class ClientRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : ClientRepository {
    private var queryUtils = QueryUtils("CDT_CLIENT", "DESCRIPTION")

    override fun add(t: Client) {
        var query = this.queryUtils.getInsertQuery()

        var params = hashMapOf<String, Any>()
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Client> {
        var query = this.queryUtils.getListQuery()
        return jdbcTemplate.query(query, hashMapOf<String, Any>(), BeanPropertyRowMapper<Client>())
    }

    override fun findBy(id: Number): Client {
        var query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Client>())[0]
    }

    override fun update(t: Client) {
        var query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Client) {
        var query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}