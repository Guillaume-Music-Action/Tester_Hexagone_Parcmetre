package metier.objetValeurs

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import boundedContexts.location.domain.values.DureeDeLocation

class TestDureeDureeDeLocationSpec : StringSpec(
    {

        "la duree est un concept métier".config(enabled = true) {
                val duree = DureeDeLocation.Creer(demiHeures = 2)

            duree.dureeEnMinutes shouldBe 60

        // duree.measure shouldBe 1 * hours // est-il utile (à ce moment) d'exposer la librairie qui permet de traiter toutes les unités
        }

    }
)




