package exercice_2_utils_idGenerateur

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import location.utilities.testableIdGenerateur

class GenerateurIdentifiantTests : StringSpec({

    "le generateur doit delivrer une valeur" .config(enabled = false) {

        val sut = testableIdGenerateur()
        val idObtenu =  sut.idSuivant()

        idObtenu shouldBe "quoi?"
    }






    "le generateur ne peut delivrer deux fois la meme valeur" .config(enabled = false) {

        val sut = testableIdGenerateur()
        val idObtenu1 = sut.idSuivant()
        val idObtenu2 = sut.idSuivant()

        idObtenu1 shouldNotBe idObtenu2
    }
})