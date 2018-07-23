package org.ivfun.som.dao.util

import org.junit.Test

class QueryTest {

    @Test
    fun asdf() {
        var queryUtils = QueryUtils("someTable", "order,user,postscript")
        println(queryUtils.getInsertQuery())
        println(queryUtils.getInsertQuery("order, user"))
        println(queryUtils.getListQuery())
        println(queryUtils.getFindByIdQuery("id"))
        println(queryUtils.getUpdateQuery("id=:id and blabla like 'asdafds'"))
        println(queryUtils.getUpdateQuery("dateTimeStart,dateTimeEnd,timeInSeconds", "id=:id and blabla like 'asdafds'"))
        println(queryUtils.getDeleteQuery("ID=:ID"))
    }
}