package adapters.exercice_3_adapters_fakes

import adapters.StorageSharedTests
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.models.DTOs.TicketDto
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.should

class FauxStockageTest : FunSpec({

    val testTicket = TicketDto("1", 2)
    val fauxStockageFactory = {  -> FauxStockage() }

    // TODO: à garder pour la fin
        include( StorageSharedTests.storageSaveAndCount(stockage = fauxStockageFactory()))
        include(StorageSharedTests.storageSaveAndRead(stockage = fauxStockageFactory()))

        test("sauver le ticket....") {
            val leStockage = fauxStockageFactory()

            // à vous de jouer
        }


})

