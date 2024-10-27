package adapters.driven.postGreSQL

import io.kotest.core.spec.style.StringSpec
import org.testcontainers.containers.PostgreSQLContainer
import io.kotest.matchers.*
import adapters.driven.storage.postGreSQL.TicketRepository

class PostGreAdaptorTest : StringSpec({

    "simple CRUD avec test container".config(enabled = true) {
        // Arrange
        val postgres = PostgreSQLContainer("postgres:16")
        postgres.start()
        val userName = postgres.getUsername()
        val password = postgres.getPassword()
        val repo = TicketRepository(postgres.getJdbcUrl(), userName, password)

        repo.createTableTicket()
        val r1  =repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "1", amountOfMinutes = 30))
        r1.isSuccess  shouldBe  true
        val r2 = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2", amountOfMinutes = 18))
        r2.isSuccess  shouldBe true
        //val r3 = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2Z", elapseMinutes = 445554541))
        //r3.isFailure  shouldBe false

        // Act
        val countTickets = repo.cardinalityTickets()
        // Assert
        countTickets.isSuccess  shouldBe true
        countTickets.getOrThrow() shouldBe 2

        // Tear Down
        postgres.stop()



    }
})