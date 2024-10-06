package koin

import io.kotest.core.spec.style.FunSpec
import io.kotest.koin.KoinExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import location.behaviors.IJeDonneDesIdentifiants
import mainModule
import org.junit.Rule
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier


import org.koin.test.KoinTest
import org.koin.test.inject


class KotestAndKoin : FunSpec(), KoinTest {

    override fun extensions() = listOf(KoinExtension(mainModule))


    init {
        val userService by inject<IJeDonneDesIdentifiants>( )
        test("use UlidGenerateur") {

            userService.idSuivant().length  shouldBe  26 //Ulid have 26 characters
        }
    }


    init {
        val userService by inject<IJeDonneDesIdentifiants>(qualifier = named("test"))
        test("use LinearIdGenerator") {

            userService.idSuivant()  shouldBe "FAUX-ID-1" //Ulid have 26 characters
        }
    }
}



/*
class InjectionDepencyTest: KoinTest {

    // Lazy inject property
    val componentB: IJeDonneDesIdentifiants by inject()

    @Test
    fun `should inject my components`() {
        startKoin {
            modules(
                module {
                    single { GenerateurLineaire() }
                    //  single { GenerateurLineaire(get()) }
                })
        }

        // directly request an instance
        val componentA = get<IJeDonneDesIdentifiants>()

        componentA.shouldNotBeNull()
        componentA.idSuivant() shouldBe "true"

    }
}*/