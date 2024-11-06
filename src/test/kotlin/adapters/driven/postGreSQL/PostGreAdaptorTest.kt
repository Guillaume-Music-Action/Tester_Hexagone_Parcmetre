package adapters.driven.postGreSQL

import io.kotest.core.spec.style.StringSpec
import org.testcontainers.containers.PostgreSQLContainer
import io.kotest.matchers.*
import adapters.driven.storage.postGreSQL.PostGreTicketRepositoryAdapter

class PostGreAdaptorTest : StringSpec({

    "simple CRUD avec test container".config(enabled = true) {
        // Arrange
        val postgreSQLContainer = PostgreSQLContainer("postgres:16")
        postgreSQLContainer.start()
        val userName = postgreSQLContainer.username
        val password = postgreSQLContainer.password

        val repo = PostGreTicketRepositoryAdapter(postgreSQLContainer.jdbcUrl, userName, password)

        val countTicketsBefore = repo.countTickets()
        countTicketsBefore.getOrThrow() shouldBe 0

        // Act
        val r1  = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "1", amountOfMinutes = 30))
        r1.isSuccess  shouldBe  true
        val r2 =  repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2", amountOfMinutes = 1839))
        r2.isSuccess  shouldBe true

        // Verify
        val countTickets = repo.countTickets()
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
        val repo = PostGreTicketRepositoryAdapter(postgreSQLContainer.jdbcUrl, userName, password)




        val r3 = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2Z", amountOfMinutes = 445554541))
        r3.isFailure  shouldBe false

        // Act
        val countTickets = repo.countTickets()
        // Assert
        countTickets.isSuccess  shouldBe true
        countTickets.getOrThrow() shouldBe 1

        // Tear Down
        postgreSQLContainer.stop()
    }
})