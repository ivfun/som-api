package org.ivfun.som.dao.impl

import org.ivfun.som.dao.ComponentRepository
import org.ivfun.som.dao.util.QueryUtils
import org.ivfun.som.model.Component
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class ComponentRepositoryImpl(private var jdbcTemplate: NamedParameterJdbcTemplate) : ComponentRepository {
    private var queryUtils = QueryUtils("CDT_COMPONENT", "DESCRIPTION")

    override fun add(t: Component) {
        val query = this.queryUtils.getInsertQuery()

        val params = hashMapOf<String, Any>()
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun list(): List<Component> {
        val query = this.queryUtils.getListQuery()
        return this.jdbcTemplate.query(query, BeanPropertyRowMapper<Component>())
    }

    override fun findBy(id: Number): Component {
        val query = this.queryUtils.getFindByIdQuery("ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = id

        return this.jdbcTemplate.query(query, params, BeanPropertyRowMapper<Component>())[0]
    }

    override fun update(t: Component) {
        val query = this.queryUtils.getUpdateQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id
        params["DESCRIPTION"] = t.description

        this.jdbcTemplate.update(query, params)
    }

    override fun delete(t: Component) {
        val query = this.queryUtils.getDeleteQuery("ID=:ID")

        val params = hashMapOf<String, Any>()
        params["ID"] = t.id

        this.jdbcTemplate.update(query, params)
    }
}