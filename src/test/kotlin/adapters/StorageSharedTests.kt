package adapters

import boundedContexts.location.models.DTOs.TicketDto
import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.ports.ITicketRepository
import io.kotest.matchers.result.shouldBeSuccess

// TIPS : remettre en place les tests partagés et montrer que le Fake doit etre conforme au TestContainer
object StorageSharedTests
{
    fun storageSaveAndCount(stockage: ITicketRepository) = funSpec {
        test("cardinalityTickets should return the number of saved tickets") {

            stockage.saveTicket(TicketDto("1", 2))
            stockage.countTickets().getOrNull() shouldBe 1
        }
    }

    fun storageSaveAndRead(stockage: ITicketRepository) = funSpec {
        test("getTickets should return the list of saved tickets") {
            val testTicket = TicketDto("2", 3)
            stockage.saveTicket(testTicket)
            stockage.getTickets().getOrNull()?.first() shouldBe testTicket
        }
    }

    fun storageSaveTooLarge(stockage: ITicketRepository) = funSpec {
        test("sauver un ticket qui possede un large nombre de minutes") {

            val largeTicket = TicketDto("1", 445554541)
            stockage.saveTicket(largeTicket)
            stockage.countTickets() shouldBeSuccess (1)
        }
    }
}

