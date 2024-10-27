package adapters.driven.postGreSQL

import io.kotest.core.spec.style.StringSpec
import org.testcontainers.containers.PostgreSQLContainer
import io.kotest.matchers.*
import adapters.driven.storage.postGreSQL.TicketRepository
import boundedContexts.location.models.DTOs.TicketDto

class PostGreAdaptorTest : StringSpec({

    "simple CRUD avec test container".config(enabled = true) {
        // Arrange
        val postgres = PostgreSQLContainer("postgres:16")
        postgres.start()
        val userName = postgres.getUsername()
        val password = postgres.getPassword()
        val repo = TicketRepository(postgres.getJdbcUrl(), userName, password)

        repo.createTableTicket()
        repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "1", elapseMinutes = 30))
        repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2", elapseMinutes = 18))

        // Act
        val countTickets = repo.cardinalityTickets()
        // Assert
        countTickets.isSuccess  shouldBe true
        countTickets.getOrThrow() shouldBe 2

        // Tear Down
        postgres.stop()



    }
})