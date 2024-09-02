package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.datetime.*
import parcmetre.domain.entities.ParcMetre

class `1_TestParcmetre` : StringSpec({

    "je veux prendre un ticket au parcemetre pour 30 minutes"  {
        val parcmetre = ParcMetre("00001", "CentreVille")

        val ticket  = parcmetre.EditerTicker(duree = 30)

        ticket.dureeDeStationnmentEnMinutes shouldBe  30

        //ca marchera pas
        ticket.heureEntree shouldBe Clock.System.now().toLocalDateTime( TimeZone.UTC)


        //    .plus( DateTimePeriod(minutes = 30) , TimeZone.UTC)
    }

    "Quand  je prends un ticket, alors il est daté au moment où il est demandé ".config(enabled = true) {
        // Arrange / Given

        // Assert / Then
      //  ticket.heureDebutStationnement shouldBe leMaintenant

    }

    "pour avoir un ticket, je dois mettre au moins 1€" {

    }

    "l' heure de fin de stationnement dépend du montant payé : 1€" {

    }
})