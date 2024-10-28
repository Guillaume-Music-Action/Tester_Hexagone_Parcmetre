package adapters

import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.ports.ITicketRepository

//TODO : remettre en place les tests partagés et montrer que le Fake doit etre conforme au TestContainer
object StorageSharedTests
{
    fun storageSaveAndCount(stockage: ITicketRepository) = funSpec {
        test("cardinalityTickets should return the number of saved tickets") {

            stockage.saveTicket(boundedContexts.location.models.DTOs.TicketDto("1", 2))
            stockage.cardinalityTickets().getOrNull() shouldBe 1
        }
    }

    fun storageSaveAndRead(stockage: ITicketRepository) = funSpec {
        test("getTickets should return the list of saved tickets") {
            val testTicket = boundedContexts.location.models.DTOs.TicketDto("2", 3)
            stockage.saveTicket(testTicket)
            stockage.getTickets().getOrNull()?.first() shouldBe testTicket
        }
    }
}

