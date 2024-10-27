package adapters

import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.behaviors.ITicketRepository
import boundedContexts.location.models.DTOs.TicketDto

object StorageSharedTests
{
    fun storageSaveAndCount(stockage: boundedContexts.location.behaviors.ITicketRepository) = funSpec {
        test("cardinalityTickets should return the number of saved tickets") {

            stockage.saveTicket(boundedContexts.location.models.DTOs.TicketDto(1, 2))
            stockage.cardinalityTickets().getOrNull() shouldBe 1
        }
    }

    fun storageSaveAndRead(stockage: boundedContexts.location.behaviors.ITicketRepository) = funSpec {
        test("getTickets should return the list of saved tickets") {
            val testTicket = boundedContexts.location.models.DTOs.TicketDto(2, 3)
            stockage.saveTicket(testTicket)
            stockage.getTickets().getOrNull()?.first() shouldBe testTicket
        }
    }
}

