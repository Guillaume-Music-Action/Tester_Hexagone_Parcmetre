import location.adapters.driver.httpServer
import location.behaviors.IJeDonneDesIdentifiants
import location.useCases.AcheterUnTicketDeLocation
import location.utilities.LinearIdGenerator
import location.utilities.UlidGenerateur
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module


class App : KoinComponent {
    private val generateurId by inject<IJeDonneDesIdentifiants>()

    fun start() {
        httpServer(8818, AcheterUnTicketDeLocation(generateurId)).start()
    }

}

fun main() {
    startKoin {
        printLogger()
        modules(productionModule)
    }
    App().start()
}

val productionModule = module {
    single<IJeDonneDesIdentifiants>() { UlidGenerateur() }

    single<IJeDonneDesIdentifiants>(named("test")) { LinearIdGenerator() }
}


val testModule = module {
    single<IJeDonneDesIdentifiants> { LinearIdGenerator() }
}