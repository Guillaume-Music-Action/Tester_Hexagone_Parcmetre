import adapters.driver.httpServer
import boundedContexts.location.ports.IJeDonneDesIdentifiants
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module


fun main() {
    startKoin {
        printLogger()
        modules(productionModule)
    }
    App().start()
}

class App : KoinComponent {
    private val generateurId by inject<IJeDonneDesIdentifiants>()

    fun start() {
        httpServer(8818, boundedContexts.location.useCases.AcheterUnTicketDeLocation(generateurId))
            .start()
    }
}


val productionModule = module {
    single<IJeDonneDesIdentifiants>() { boundedContexts.location.utilities.UlidGenerateur() }
    single<IJeDonneDesIdentifiants>(named("deterministic")) { boundedContexts.location.utilities.LinearIdGenerator() }
}


val testModule = module {
    single<IJeDonneDesIdentifiants> { boundedContexts.location.utilities.LinearIdGenerator() }
}