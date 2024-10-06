import location.adapters.driver.httpServer
import location.useCases.AcheterUnTicketDeLocation

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module


class App : KoinComponent {
    private val helloService by inject<HelloService>()

    fun start() {
        httpServer(0, AcheterUnTicketDeLocation()).start()
    }

}

fun main() {
    startKoin {
        printLogger()
        modules(mainModule)

    }
    App().start()
}

val mainModule = module {
    single(named("foo")) { Greeting("Mr. Foo") }
    single { Greeting("John Doe") }
    single { HelloServiceImpl(get(named("foo"))) as HelloService }
}