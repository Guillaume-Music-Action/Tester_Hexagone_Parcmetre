package koin


import io.kotest.core.spec.style.FunSpec
import io.kotest.koin.KoinExtension
import io.kotest.matchers.shouldBe
import boundedContexts.location.ports.IJeDonneDesIdentifiants
import developperMode
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.inject


class InjectionDepencyTest : FunSpec(), KoinTest {

    override fun extensions() = listOf(KoinExtension(developperMode))


    init {
        val userService by inject<IJeDonneDesIdentifiants>( )
        test("use UlidGenerateur") {

            userService.idSuivant().length  shouldBe  26 //Ulid have 26 characters
           // userService.idSuivant()  shouldBe  "01J9KQP70J6QF9VRY5N3W0MS85"
        }
    }


    init {
        val userService by inject<IJeDonneDesIdentifiants>(qualifier = named("deterministic"))
        test("use LinearIdGenerator") {

            userService.idSuivant()  shouldBe "FAUX-ID-1" //linear id renvoit toujours la meme
            userService.idSuivant()  shouldBe "FAUX-ID-2" //linear id renvoit toujours la meme
        }
    }
}
