package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.datetime.LocalDateTime
import parcmetre.domain.entities.IdGenerateur
import parcmetre.domain.entities.UsineDeTickets

class TestTicket : StringSpec({


    "le ticket doit avoir un generateur qui s'occupe de l'ID" {
        // remplacer IdGenerateur par un fake+spy  (ca veut dire un contrat derriere => ULID.Suivant())
        // montrer comment hors du test, c'est un UlidGenerateur qui va prendre la place
        var ticketGenateur=  UsineDeTickets(IdGenerateur)
        val ticket = ticketGenateur.Creation(
            LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
            42)

        ticket.id shouldNotBe null
        ticket.id shouldNotBe ""
        ticket.dureeDeStationnmentEnMinutes shouldBe 42
        ticket.heureEntree.year shouldBe 2016
        ticket.heureEntree.dayOfMonth shouldBe 15
    }

    "le ticket doit avoir un generateur qui s'occupe de l'ID et garanti que un 2e ticket possede un Id different" {
        var ticketGenateur=  UsineDeTickets(IdGenerateur)
        val ticket1 = ticketGenateur.Creation(
            LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
            42)

        val ticket2 = ticketGenateur.Creation(
            LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
            42)

        ticket1.id shouldNotBe ticket2.id
    }


    "la durée ne doit pas être inférieure à 30mn" {

    }
}) {

}


