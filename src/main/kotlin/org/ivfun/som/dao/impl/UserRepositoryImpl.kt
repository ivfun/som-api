package org.ivfun.som.dao.impl

import org.ivfun.som.dao.UserRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.User
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class UserRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : UserRepository {
    private var queryUtils = QueryUtils("USER", "NAME, PASSWORD, EMAIL, TIMEZONE, ACCESS_LEVEL")

    override fun add(t: User) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["NAME"] = t.name
        params["PASSWORD"] = t.password
        params["EMAIL"] = t.email
        params["TIMEZONE"] = t.timezone
        params["ACCESS_LEVEL"] = t.accessLevel

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<User> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<User>())
    }

    override fun findBy(id: Number): User {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<User>())[0]
    }

    override fun update(t: User) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["NAME"] = t.name
        params["PASSWORD"] = t.password
        params["EMAIL"] = t.email
        params["TIMEZONE"] = t.timezone
        params["ACCESS_LEVEL"] = t.accessLevel

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: User) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}