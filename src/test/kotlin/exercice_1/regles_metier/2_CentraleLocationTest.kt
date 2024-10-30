package exercice_1.regles_metier

import io.kotest.core.annotation.AutoScan
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import boundedContexts.location.domain.agregates.BorneLocation
import boundedContexts.universel.valueObjects.Devises
import boundedContexts.universel.valueObjects.Monnaie
import io.nacular.measured.units.Time.Companion.hours
import boundedContexts.location.utilities.LinearIdGenerator
import boundedContexts.location.utilities.UlidGenerateur
import io.kotest.matchers.result.shouldBeSuccess
import io.nacular.measured.units.Time.Companion.seconds

@AutoScan
class `2_CentraleLocationTest` : StringSpec({


    "je veux prendre un ticket à la borne de location pour 30 minutes" .config(enabled = false)  {

        val borneLocation = BorneLocation(UlidGenerateur())

        val ticket  = borneLocation.EmettreTicket(duree = 30 * minutes)

        ticket.dureeDeLocation shouldBe  1800 * seconds
        ticket.Id shouldBe "01JBEE2F630FN3R662Q5HN24M6"
        // pas testable parce que c'est aléatoire
    }

    "je veux prendre un ticket à la borne de location pour 30 minutes avec result" .config(enabled = true)  {

        val borneLocation = BorneLocation(LinearIdGenerator ())


        val ticket2  = borneLocation.EmettreTicketResult(duree = 30 * minutes)

        ticket2.isSuccess shouldBe true
        ticket2.shouldBeSuccess()
        ticket2.getOrNull()?.dureeDeLocation shouldBe 1800 * seconds

    }



    "je veux prendre un ticket au parcemetre pour 240 minutes" .config(enabled = true) {
        val sut =
            BorneLocation(LinearIdGenerator())

        val ticket  = sut.EmettreTicket(argent =  Monnaie(2, Devises.EUROS))

        ticket.dureeDeLocation shouldBe   240 * minutes
        ticket.Id shouldBe "FAUX-ID-1"
    }

    "deux tickets créés ont deux identificants distincts" .config(enabled = true) {
        val sut =
            BorneLocation(LinearIdGenerator())

        val ticket1  = sut.EmettreTicket(argent =  Monnaie(2, Devises.EUROS))
        val ticket2  = sut.EmettreTicket(argent =  Monnaie(2, Devises.EUROS))

        ticket1 shouldNotBe   ticket2
        ticket1.Id shouldNotBe   ticket2.Id
    }


    "pour 2 heures on paye 1 euros" .config(enabled = true) {
        val sut =
            BorneLocation(LinearIdGenerator())

        val ticket2= sut.EmettreTicketResult(duree = 120 * minutes )

        ticket2.isSuccess shouldBe true
        ticket2.getOrNull()?.dureeDeLocation shouldBe  120 * minutes
        ticket2.getOrNull()?.prix shouldBe  Monnaie(1, Devises.EUROS)

      }

    "au delà de 8 heures on paye 4 euros" .config(enabled = true) {
        val sut =
            BorneLocation(LinearIdGenerator())
        val ticket  = sut.EmettreTicketResult(duree = 8 * hours )

        ticket.getOrNull()?.dureeDeLocation shouldBe  8 * hours
        ticket.getOrNull()?.prix shouldBe  Monnaie(4, Devises.EUROS)
    }

    // ATBDX-2024: durée maximum de la location
    "9h n'est pas une duree validee" .config(enabled = true) {
        val sut = BorneLocation(LinearIdGenerator())
        val ticket  = sut.EmettreTicketResult (duree = 9 * hours )

        ticket.isFailure shouldBe true
    }





})