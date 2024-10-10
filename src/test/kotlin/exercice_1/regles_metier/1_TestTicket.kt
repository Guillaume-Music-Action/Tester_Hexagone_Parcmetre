package exercice_1.regles_metier

import boundedContexts.capitalisme.valueObjects.Monnaie
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.Time.Companion.seconds
import io.nacular.measured.units.times
import kotlinx.datetime.LocalDateTime
import location.domain.entities.Ticket
import location.domain.entities.UsineDeTickets
import location.utilities.UlidGenerateur
import location.utilities.ulidGenerateur

class `1_TestTicket` : StringSpec(
    {

        "le ticket est là".config(enabled = true) {
            var sut = Ticket("", 42 * minutes, Monnaie.Zero())
            sut.dureeDeLocation shouldBe 42 * (60 * seconds)
        }

        "le ticket doit avoir un generateur qui s'occupe de l'ID".config(enabled = true) {
            // remplacer IdGenerateur par un fake+spy  (ca veut dire un contrat derriere => ULID.Suivant())
            // montrer comment hors du test, c'est un UlidGenerateur qui va prendre la place
            var ticketGenerateur = UsineDeTickets(ulidGenerateur)

            val ticket = ticketGenerateur.Creation(
                LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
                Measure(42.0, minutes),
            )

            //  ticket.id shouldNotBe null
            //  ticket.id shouldNotBe "quelque chose de fixe"
            ticket.dureeDeLocation shouldBe 42 * minutes
            //    ticket.heureEntree.year shouldBe 2016
            //  ticket.heureEntree.dayOfMonth shouldBe 15
        }


        "le ticket doit avoir un generateur qui s'occupe de l'ID et garanti que un 2e ticket possede un Id different"
            .config(enabled = true) {

                var ticketGenerateur = UsineDeTickets(ulidGenerateur)

                val ticket1 = ticketGenerateur.Creation(
                    LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
                    Measure(42.0, minutes),
                )

                val ticket2 = ticketGenerateur.Creation(
                    LocalDateTime(2016, 2, 15, 16, 57, 0, 0),
                    Measure(42.0, minutes),
                )

                ticket1.Id shouldNotBe ticket2.Id
            }


        "la durée ne doit pas être inférieure à 30mn".config(enabled = false) {

        }
    },
)




