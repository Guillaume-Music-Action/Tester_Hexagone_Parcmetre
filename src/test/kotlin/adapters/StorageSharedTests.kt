package adapters

import io.kotest.core.spec.style.funSpec
import io.kotest.matchers.shouldBe
import parcmetre.behaviors.ITicketRepository
import parcmetre.models.DTOs.TicketDto

object StorageSharedTests
{
    fun storageSaveAndCount(stockage: ITicketRepository) = funSpec {
        test("cardinalityTickets should return the number of saved tickets") {

            stockage.saveTicket(TicketDto(1, 2))
            stockage.cardinalityTickets().getOrNull() shouldBe 1
        }
    }

    fun storageSaveAndRead(stockage: ITicketRepository) = funSpec {
        test("getTickets should return the list of saved tickets") {
            val testTicket = TicketDto(2, 3)
            stockage.saveTicket(testTicket)
            stockage.getTickets().getOrNull()?.first() shouldBe testTicket
        }
    }
}

