package adapters.exercice_3_adapters_fakes

import adapters.StorageSharedTests
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.models.DTOs.TicketDto
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.should

class FauxStockageTest : FunSpec({

    val testTicket = TicketDto("1", 2)
    val fauxStockageFactory = {  -> FauxStockage()}

        include( StorageSharedTests.storageSaveAndCount(stockage = fauxStockageFactory()))

        include(StorageSharedTests.storageSaveAndRead(stockage = fauxStockageFactory()))

        test("sauver le ticket augmente la taille de la liste ") {
            val leStockage = fauxStockageFactory()
            leStockage.saveTicket(testTicket)
            leStockage.listDesTickets.size shouldBe 1
        }

    test("sauver le ticket et les compter ensuite") {
        val leStockage = fauxStockageFactory()
        leStockage.saveTicket(testTicket)
        leStockage.cardinalityTickets() shouldBeSuccess(1)
    }

    test("sauver un ticket qui possede un large nombre de minutes") {
        val leStockage = fauxStockageFactory()
        val largeTicket = TicketDto("1", 445554541)
        leStockage.saveTicket(largeTicket)
        leStockage.cardinalityTickets() shouldBeSuccess(1)
    }


    // //val r3 = repo.saveTicket(boundedContexts.location.models.DTOs.TicketDto(id = "2zzzzz", elapseMinutes = 4455545451))
})

