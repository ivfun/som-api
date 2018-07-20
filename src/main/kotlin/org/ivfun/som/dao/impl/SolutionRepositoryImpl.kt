package org.ivfun.som.dao.impl

import org.ivfun.som.dao.SolutionRepository
import org.ivfun.som.model.Solution
import org.springframework.stereotype.Repository

@Repository
class SolutionRepositoryImpl : SolutionRepository {
    override fun add(t: Solution) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun list(): List<Solution> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findBy(id: Number): Solution {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(t: Solution) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(t: Solution) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}