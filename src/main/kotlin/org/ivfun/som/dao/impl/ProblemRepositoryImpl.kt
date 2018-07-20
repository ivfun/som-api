package org.ivfun.som.dao.impl

import org.ivfun.som.dao.ProblemRepository
import org.ivfun.som.model.Problem
import org.springframework.stereotype.Repository

@Repository
class ProblemRepositoryImpl : ProblemRepository {
    override fun add(t: Problem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<Problem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): Problem {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: Problem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: Problem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}