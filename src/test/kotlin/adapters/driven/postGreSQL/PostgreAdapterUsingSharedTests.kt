package adapters.driven.postGreSQL

import adapters.StorageSharedTests
import adapters.driven.storage.postGreSQL.PostGreTicketRepositoryAdapter
import io.kotest.core.spec.style.FunSpec
import org.testcontainers.containers.PostgreSQLContainer

class PostgreAdapterUsingSharedTests  : FunSpec({

    val postgreSQLContainer = PostgreSQLContainer("postgres:16")

    val fauxStockageFactory = {  -> PostGreTicketRepositoryAdapter(
        postgreSQLContainer.jdbcUrl,
        postgreSQLContainer.username,
        postgreSQLContainer.password) }

    val init = { -> postgreSQLContainer.start()}
    val teardown = { -> postgreSQLContainer.stop()}

    // TESTS PARTAGES 🤓
       include( StorageSharedTests.storageSaveAndCount(getStockage = fauxStockageFactory, init, teardown))



    test("2e CRUD avec test container") {
        postgreSQLContainer.start()
        StorageSharedTests.storageSaveAndRead(stockage = fauxStockageFactory())
        postgreSQLContainer.stop()
    }

   test ("3e CRUD avec test container") {
        postgreSQLContainer.start()
        StorageSharedTests.storageSaveTooLarge(stockage = fauxStockageFactory())
        postgreSQLContainer.stop()
    }
})