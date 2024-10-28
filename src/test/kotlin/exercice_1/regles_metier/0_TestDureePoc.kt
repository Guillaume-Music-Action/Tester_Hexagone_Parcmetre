package exercice_1.regles_metier

import boundedContexts.universel.valueObjects.Monnaie
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.Time.Companion.seconds
import io.nacular.measured.units.times
import kotlinx.datetime.LocalDateTime
import boundedContexts.location.domain.entities.Ticket
import boundedContexts.location.domain.entities.UsineDeTickets
import boundedContexts.location.utilities.UlidGenerateur
import boundedContexts.location.utilities.ulidGenerateur
import io.nacular.measured.units.Time.Companion.hours

class `0_TestDureeDureeDeLocationSpec` : StringSpec(
    {

        "la duree est un concept métier".config(enabled = true) {
                val duree =   DureeDeLocation.Creer( demiHeures = 2 )

            duree.dureeEnMinutes shouldBe 60
           // duree.measure shouldBe 1 * hours // est-il utile (à ce moment) d'exposer la librairie qui permet de traiter toutes les unités
        }

    }
)




