package adapters.driven.postGreSQL

import io.kotest.core.spec.style.StringSpec
import org.testcontainers.containers.PostgreSQLContainer
import io.kotest.matchers.*
import adapters.driven.storage.postGreSQL.PostGreTicketRepository

class PostGreAdaptorTest : StringSpec({

    "simple CRUD avec test container".config(enabled = true) {
        // Arrange
        val postgreSQLContainer = PostgreSQLContainer("postgres:16")
        postgreSQLContainer.start()
        val userName = postgreSQLContainer.username
        val password = postgreSQLContainer.password

        val repo = PostGreTicketRepository(postgreSQLContainer.jdbcUrl, userName, password)
        // Act
        val r1  =repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "1", amountOfMinutes = 30))
        r1.isSuccess  shouldBe  true
        val r2 = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2", amountOfMinutes = 18394949))
        r2.isSuccess  shouldBe true



        // Act
        val countTickets = repo.cardinalityTickets()
        // Assert
        countTickets.isSuccess  shouldBe true
        countTickets.getOrThrow() shouldBe 2

        // Tear Down
        postgreSQLContainer.stop()
    }














    "grand nombre de minutes dans la duree de location".config(enabled = false) {
        // Arrange
        val postgreSQLContainer = PostgreSQLContainer("postgres:16")
        postgreSQLContainer.start()
        val userName = postgreSQLContainer.username
        val password = postgreSQLContainer.password
        val repo = PostGreTicketRepository(postgreSQLContainer.jdbcUrl, userName, password)




        val r3 = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2Z", amountOfMinutes = 445554541))
        r3.isFailure  shouldBe false

        // Act
        val countTickets = repo.cardinalityTickets()
        // Assert
        countTickets.isSuccess  shouldBe true
        countTickets.getOrThrow() shouldBe 1

        // Tear Down
        postgreSQLContainer.stop()
    }
})