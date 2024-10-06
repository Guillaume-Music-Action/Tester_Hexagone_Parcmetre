package metier.objetValeurs


import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import location.domain.valueObjects.Devises
import location.domain.valueObjects.Monnaie
import location.domain.valueObjects.Monnaie.Companion.Dollars
import location.domain.valueObjects.Monnaie.Companion.Euros

class MonnaieTest: StringSpec({


    "je peux acheter une chevre avec des dollars".config(enabled = true) {
        // Arrange
        val laPayeDeChasseurDePrime = Monnaie(500, Devises.DOLLARS)
        val lePrixDuneChevreNoire = Monnaie(500, Devises.DOLLARS)
        //Act

        // Assert
        laPayeDeChasseurDePrime shouldBe lePrixDuneChevreNoire
    }

    "je ne peux pas acheter un spinner avec ma paye".config(enabled = true) {
        // Arrange
        val laPayeDeChasseurDePrime = Monnaie(500, Devises.DOLLARS)
        val lePrixDunSpinner = Monnaie(50000, Devises.DOLLARS)
        //Act

        // Assert
        laPayeDeChasseurDePrime shouldNotBe lePrixDunSpinner
    }

    "je peux echanger des Euros avec des dollars".config(enabled = true) {
        // Arrange
        val unDollar = Dollars(1)
        val deuxEuros = Euros(2)
        //Act

        // Assert
        unDollar shouldBe deuxEuros
    }

    "Monnaie equals and hashCode should work correctly" {

        val monnaie1 = Euros(5 )
        val monnaie2 = Euros(5)
        val monnaie3 = Dollars(5)
        val monnaie4 = Euros(10)

        // Test equality
        monnaie1 shouldBe monnaie2
        monnaie1 shouldNotBe monnaie3
        monnaie1 shouldNotBe monnaie4

        // Test hashCode
        monnaie1.hashCode() shouldBe monnaie2.hashCode()
        monnaie1.hashCode() shouldNotBe monnaie3.hashCode()
        monnaie1.hashCode() shouldNotBe monnaie4.hashCode()
    }

})