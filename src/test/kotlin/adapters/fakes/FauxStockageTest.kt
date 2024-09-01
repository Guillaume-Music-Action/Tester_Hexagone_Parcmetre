package adapters.fakes

import adapters.StorageSharedTests
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import parcmetre.models.DTOs.TicketDto

class FauxStockageTest : FunSpec({

    val testTicket = TicketDto(1, 2)
    val stockageFactory = {  -> FauxStockage()}

        include( StorageSharedTests.storageSaveAndCount(stockage = stockageFactory()))

        include(StorageSharedTests.storageSaveAndRead(stockage = stockageFactory()))

        test("saveTicket should add a ticket ") {
            val leStockage = stockageFactory()
            leStockage.saveTicket(testTicket)
            ( leStockage  as FauxStockage).listDesTickets.size shouldBe 1
        }

})

