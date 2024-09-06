package exercice_1.regles_metier

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import kotlinx.datetime.*
import parcmetre.domain.entities.ParcMetre
import parcmetre.domain.valueObjects.Devises
import parcmetre.domain.valueObjects.Monnaie

class `2_TestParcmetre` : StringSpec({

    "je veux prendre un ticket au parcemetre pour 30 minutes" .config(enabled = false) {
        val parcmetre = ParcMetre("00001" )

        val ticket  = parcmetre.EditerTicker(argent =  Monnaie(1, Devises.EUROS))
        val expected = 30 * minutes
        ticket.dureeDeStationnment shouldBe  expected


    }


    "je veux prendre un ticket au parcemetre pour 30 minutes a la bonne heure" .config(enabled = false)  {
        val parcmetre = ParcMetre("00001" )

        val ticket  = parcmetre.EditerTicker(duree = 30 * minutes)

        ticket.dureeDeStationnment shouldBe  30 * minutes

        //ca marchera pas
        ticket.heureEntree shouldBe Clock.System.now().toLocalDateTime( TimeZone.UTC)


        //    .plus( DateTimePeriod(minutes = 30) , TimeZone.UTC)
    }


    "pour avoir un ticket de 30mn, je dois mettre au moins 1€" .config(enabled = false) {

    }

    /*
    "l' heure de fin de stationnement dépend du montant payé : 1€" {
    }*/
})