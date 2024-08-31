package zdraft.parcmetre

import draft.Ticket
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

import java.time.LocalDateTime
import java.time.Month

class TestTicket : StringSpec({

    ("le ticket doit mentionner l'heure de sortie meme si le paimùent est à 0").config(enabled = true) {
        // Arrange
        var dateEntree = LocalDateTime.of(2016, Month.APRIL, 15, 3, 15)
        var horlogeDeTest = FausseHorloge(dateEntree)

        var sut : Ticket =  Ticket("00-AAA-00", 0.0 , horlogeDeTest)

        // Assert
        sut.DateHeureSortie shouldBe dateEntree
    }

    ("si le paiement est à 0,5€ alors j'ai 1 heure de stationnement").config(enabled = true) {
        // Arrange
        var dateEntree = LocalDateTime.of(2016, Month.APRIL, 15, 3, 15)
        var horlogeDeTest = FausseHorloge(dateEntree)

        var sut : Ticket =  Ticket("00-AAA-00", 0.5, horlogeDeTest)

        // Assert
        sut.DateHeureSortie shouldBe dateEntree.plusHours(1)
    }
})