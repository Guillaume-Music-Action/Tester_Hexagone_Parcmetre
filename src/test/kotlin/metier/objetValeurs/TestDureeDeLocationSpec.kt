package metier.objetValeurs

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.domain.values.DureeDeLocation

class TestDureeDeLocationSpec : StringSpec(
    {

        "la duree est un concept métier".config(enabled = true) {
                val duree = DureeDeLocation.Creer(demiHeures = 2)

            duree.dureeEnMinutes shouldBe 60

        // duree.measure shouldBe 1 * hours // est-il utile (à ce moment) d'exposer la librairie qui permet de traiter toutes les unités
        }

        "la duree ne peut pas être inférieure à une demi heure".config(enabled = true) {
                val duree = DureeDeLocation.Creer(demiHeures = 0)

            duree.dureeEnMinutes shouldBe 0
        }

        "la duree ne peut pas être supérieure à 8 heures".config(enabled = true) {
            val duree = DureeDeLocation.Creer(demiHeures = 17)

            // TODO: passer en Result
        }



    }
)




