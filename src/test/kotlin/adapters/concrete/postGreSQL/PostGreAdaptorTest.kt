package adapters.concrete.postGreSQL

import io.kotest.core.spec.style.StringSpec
import org.testcontainers.containers.PostgreSQLContainer
import io.kotest.matchers.*
import parcmetre.adapters.storage.postGreSQL.TicketRepository
import parcmetre.models.DTOs.TicketDto

class PostGreAdaptorTest : StringSpec({

    "simple CRUD avec test container".config(enabled = true) {
        // Arrange
        val postgres = PostgreSQLContainer("postgres:16")
        postgres.start()
        val repo = TicketRepository(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword())
        repo.createTableTicket()
        repo.saveTicket(TicketDto(id = 1, elapseMinutes = 30))
        repo.saveTicket(TicketDto(id = 2, elapseMinutes = 18))

        // Act
        val countTickets = repo.cardinalityTickets()

        postgres.stop()

        // Assert
        countTickets shouldBe 2

    }
})