package org.ivfun.som.configuration.dao

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class NamedParameterJdbcTemplateImpl(@Qualifier(value = "dataSource") dataSource: DataSource): NamedParameterJdbcTemplate(dataSource)