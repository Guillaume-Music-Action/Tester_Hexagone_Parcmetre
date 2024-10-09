package koin


import io.kotest.core.spec.style.FunSpec
import io.kotest.koin.KoinExtension
import io.kotest.matchers.shouldBe
import location.behaviors.IJeDonneDesIdentifiants
import productionModule
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.inject
import testModule


class InjectionDepency2Test : FunSpec(), KoinTest {

    override fun extensions() = listOf(KoinExtension(testModule))

    init {
        val userService by inject<IJeDonneDesIdentifiants>()
        test("use LinearIdGenerator") {

            userService.idSuivant()  shouldBe "FAUX-ID-1" //linear id renvoit toujours la meme
            userService.idSuivant()  shouldBe "FAUX-ID-2" //linear id renvoit toujours la meme
        }
    }
}

