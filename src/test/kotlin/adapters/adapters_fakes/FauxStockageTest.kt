package adapters.adapters_fakes

import adapters.StorageSharedTests
import io.kotest.core.spec.style.FunSpec
import boundedContexts.location.models.DTOs.TicketDto

class FauxStockageTest : FunSpec({

    val testTicket = TicketDto("1", 2)
    val fauxStockageFactory = {  -> FauxStockage() }

        test("sauver le ticket....") {
            val leStockage = fauxStockageFactory()
            // à vous de jouer
        }

    // TESTS PARTAGES 🤓
    include( StorageSharedTests.storageSaveAndCount(stockage = fauxStockageFactory()))
    include(StorageSharedTests.storageSaveAndRead(stockage = fauxStockageFactory()))
    include(StorageSharedTests.storageSaveTooLarge(stockage = fauxStockageFactory()))
})

