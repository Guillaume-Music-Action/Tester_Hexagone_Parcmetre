package adapters.exercice_3_adapters_fakes

import adapters.StorageSharedTests
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import parcmetre.models.DTOs.TicketDto

class FauxStockageTest : FunSpec({

    val testTicket = TicketDto(1, 2)
    val fauxStockageFactory = {  -> FauxStockage()}

        include( StorageSharedTests.storageSaveAndCount(stockage = fauxStockageFactory()))

        include(StorageSharedTests.storageSaveAndRead(stockage = fauxStockageFactory()))

        test("saveTicket should add a ticket ") {
            val leStockage = fauxStockageFactory()
            leStockage.saveTicket(testTicket)
            leStockage.listDesTickets.size shouldBe 1
        }

})

