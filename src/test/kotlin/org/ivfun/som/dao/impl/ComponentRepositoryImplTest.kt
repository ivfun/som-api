package org.ivfun.som.dao.impl

import org.ivfun.som.SomApiApplication
import org.ivfun.som.dao.ComponentRepository
import org.ivfun.som.model.Component
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import kotlin.test.assertEquals

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [(SomApiApplication::class)])
@ActiveProfiles("test")
class ComponentRepositoryImplTest(private var repository: ComponentRepository) {
    @Test
    fun insertShouldWork() {
        var component = Component()
        component.description = "some description"

        this.repository.add(component)

        val componentFound = this.repository.findBy(3)
\
        assertEquals(component.description, componentFound.description)
    }
}