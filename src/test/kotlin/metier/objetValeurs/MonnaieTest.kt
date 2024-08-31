package metier.objetValeurs


import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import parcmetre.metier.objetValeurs.Devises
import parcmetre.metier.objetValeurs.Monnaie

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
        val unDollar = Monnaie(1, Devises.DOLLARS)
        val deuxEuros = Monnaie(2, Devises.EUROS)
        //Act

        // Assert
        unDollar shouldBe deuxEuros
    }

    "Monnaie equals and hashCode should work correctly" {

        val monnaie1 = Monnaie(5, Devises.EUROS)
        val monnaie2 = Monnaie(5, Devises.EUROS)
        val monnaie3 = Monnaie(5, Devises.DOLLARS)
        val monnaie4 = Monnaie(10, Devises.EUROS)

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