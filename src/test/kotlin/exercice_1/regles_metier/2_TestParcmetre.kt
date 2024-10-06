package exercice_1.regles_metier

import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import location.domain.entities.CentraleLocation
import location.domain.valueObjects.Devises
import location.domain.valueObjects.Monnaie
import location.utilities.GenerateurLineaire

@AutoScan
class `2_TestParcmetre` : StringSpec({


    "je veux prendre un ticket au parcemetre pour 120 minutes" .config(enabled = true) {
        val sut = CentraleLocation("", GenerateurLineaire() )

        val ticket  = sut.CreerTicket(argent =  Monnaie(1, Devises.EUROS))

        ticket.dureeDeLocation shouldBe   120 * minutes
    }

    "je veux prendre un ticket au parcemetre pour 240 minutes" .config(enabled = true) {
        val sut = CentraleLocation("", GenerateurLineaire() )

        val ticket  = sut.CreerTicket(argent =  Monnaie(2, Devises.EUROS))

        ticket.dureeDeLocation shouldBe   240 * minutes
    }

    "deux tickets créés ont deux identificants distincts" .config(enabled = true) {
        val sut = CentraleLocation("", GenerateurLineaire() )

        val ticket1  = sut.CreerTicket(argent =  Monnaie(2, Devises.EUROS))
        val ticket2  = sut.CreerTicket(argent =  Monnaie(2, Devises.EUROS))

        ticket1 shouldNotBe   ticket2
        ticket1.Id shouldNotBe   ticket2.Id
    }









    "je veux prendre un ticket au parcemetre pour 30 minutes a la bonne heure" .config(enabled = false)  {
        val parcmetre = CentraleLocation("00001", GenerateurLineaire() )

        val ticket  = parcmetre.CreerTicket(duree = 30 * minutes)

        ticket.dureeDeLocation shouldBe  30 * minutes

        //ca marchera pas
       // ticket.heureEntree shouldBe Clock.System.now().toLocalDateTime( TimeZone.UTC)


        //    .plus( DateTimePeriod(minutes = 30) , TimeZone.UTC)
    }


    "pour avoir un ticket de 30mn, je dois mettre au moins 1€" .config(enabled = false) {

    }

    /*
    "l' heure de fin de stationnement dépend du montant payé : 1€" {
    }*/
})