package org.ivfun.som.dao.util

class QueryUtils(private val table: String, private val tableColumns: String) {
    fun getInsertQuery(): String {
        var allValuesKeys = this.getValues(tableColumns)
        return "INSERT INTO $table ($tableColumns) VALUES ($allValuesKeys)"
    }

    fun getInsertQuery(valuesKeys: String): String {
        var someValuesKeys = this.getValues(valuesKeys)
        return "INSERT INTO $table ($tableColumns) VALUES ($someValuesKeys)"
    }

    fun getListQuery(): String {
        return "SELECT * FROM $table"
    }

    fun getFindByIdQuery(idColumn: String): String {
        var queryColumnsValues = this.getColumnsValues(idColumn)
        return "SELECT * FROM $table WHERE $queryColumnsValues"
    }

    fun getUpdateQuery(condition: String): String {
        var queryColumnsValues = this.getColumnsValues(this.tableColumns)
        return "UPDATE $table SET $queryColumnsValues WHERE $condition"
    }

    fun getUpdateQuery(queryColumns: String, condition: String): String {
        var queryColumnsValues = this.getColumnsValues(queryColumns)
        return "UPDATE $table SET $queryColumnsValues WHERE $condition"
    }

    fun getDeleteQuery(condition: String): String {
        return "DELETE FROM $table WHERE $condition"
    }

    private fun getValues(values: String): String {
        return ":" + values.replace("""(\s)*,(\s)*""".toRegex(), ",:")
    }

    private fun getColumnsValues(columns: String): String {
        var columnsValues = ""

        for (column in columns.split(",")) {
            columnsValues = "$columnsValues$column=:$column,"
        }

        return columnsValues.dropLast(1)
    }
}