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

    include(  StorageSharedTests.storageSaveAndRead(fauxStockageFactory, init, teardown))

    include( StorageSharedTests.storageSaveTooLarge(fauxStockageFactory, init, teardown))


})