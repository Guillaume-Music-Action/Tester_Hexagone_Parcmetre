import adapters.driven.storage.postGreSQL.TicketRepository
import adapters.driver.httpServer
import boundedContexts.location.ports.IJeDonneDesIdentifiants
import boundedContexts.location.ports.ITicketRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module


fun main() {
    startKoin {
        printLogger()
        modules(developperMode)
    }
    App().start()
}

class App : KoinComponent {
    private val generateurId by inject<IJeDonneDesIdentifiants>()
    private val dataAdapter by inject<ITicketRepository>()

    fun start() {

        httpServer(8818, boundedContexts.location.useCases.AcheterUnTicketDeLocation(generateurId, dataAdapter))
            .start()
    }
}

val developperMode = module {
    single<IJeDonneDesIdentifiants>() { boundedContexts.location.utilities.UlidGenerateur() }
    single<IJeDonneDesIdentifiants>(named("deterministic")) { boundedContexts.location.utilities.LinearIdGenerator() }

    single<ITicketRepository> {  TicketRepository( "jdbc:postgresql://localhost:5432/mydatabase", "postgres",
        "example" ) }
}

val productionMode = module {
    single<IJeDonneDesIdentifiants>() { boundedContexts.location.utilities.UlidGenerateur() }

    single<ITicketRepository> {  TicketRepository( "jdbc:postgresql://instance001.iter.org:5432/prodBase", "SECRET",
        "SECRET" ) }
}

val testModule = module {
    single<IJeDonneDesIdentifiants> { boundedContexts.location.utilities.LinearIdGenerator() }
    // single<ITicketRepository> {  FauxStockage()    }
}