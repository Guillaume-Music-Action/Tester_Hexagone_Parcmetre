package adapters.fakes


import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import parcmetre.behaviors.ITicketRepository
import parcmetre.models.DTOs.TicketDto

class FauxStockageTest : FunSpec({

    val testTicket = TicketDto(1, 2)
    lateinit var fauxStockage: ITicketRepository

    beforeTest {
        fauxStockage = FauxStockage()
    }

    test("saveTicket should add a ticket to the list") {

        fauxStockage.saveTicket(testTicket)
        ( fauxStockage  as FauxStockage).listDesTickets.size shouldBe 1
    }

    test("cardinalityTickets should return the size of the list") {

        fauxStockage.saveTicket(testTicket)
        fauxStockage.cardinalityTickets().getOrNull() shouldBe 1
    }
    test("getTickets should return the list of tickets") {


        fauxStockage.saveTicket(testTicket)
        fauxStockage.getTickets().getOrNull()?.first() shouldBe testTicket
    }
})