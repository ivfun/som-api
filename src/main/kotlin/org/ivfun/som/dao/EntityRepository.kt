package org.ivfun.som.dao

interface EntityRepository<T> {
    fun add(t: T)
    fun list(): List<T>
    fun findBy(id: Number): T
    fun update(t: T)
    fun delete(t: T)
}