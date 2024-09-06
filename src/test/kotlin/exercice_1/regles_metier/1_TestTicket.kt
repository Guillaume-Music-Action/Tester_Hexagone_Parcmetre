package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import kotlinx.datetime.LocalDateTime
import parcmetre.domain.entities.Ticket
import parcmetre.domain.entities.UsineDeTickets
import parcmetre.utilities.UlidGenerateur

class `1_TestTicket` : StringSpec({

    "le ticket ne peut avoir un montant à zero ou négatif" .config(enabled = false) {

        var sut =  Ticket.bidon()

    }













    "le ticket doit avoir un generateur qui s'occupe de l'ID" .config(enabled = false) {
        // remplacer IdGenerateur par un fake+spy  (ca veut dire un contrat derriere => ULID.Suivant())
        // montrer comment hors du test, c'est un UlidGenerateur qui va prendre la place
        var ticketGenerateur=  UsineDeTickets(UlidGenerateur)
        val ticket = ticketGenerateur.Creation(
            LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
            42)

      //  ticket.id shouldNotBe null
      //  ticket.id shouldNotBe "quelque chose de fixe"
        ticket.dureeDeStationnment shouldBe 42 * minutes
        ticket.heureEntree.year shouldBe 2016
        ticket.heureEntree.dayOfMonth shouldBe 15
    }








    "le ticket doit avoir un generateur qui s'occupe de l'ID et garanti que un 2e ticket possede un Id different"
        .config(enabled = false) {

        var ticketGenerateur=  UsineDeTickets(UlidGenerateur)
        val ticket1 = ticketGenerateur.Creation(
            LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
            42)

        val ticket2 = ticketGenerateur.Creation(
            LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
            42)

       // ticket1.id shouldNotBe ticket2.id
    }


    "la durée ne doit pas être inférieure à 30mn" .config(enabled = false) {

    }
}) {

}


