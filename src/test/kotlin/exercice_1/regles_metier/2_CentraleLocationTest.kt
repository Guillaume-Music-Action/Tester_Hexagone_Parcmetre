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

@AutoScan
class `2_CentraleLocationTest` : StringSpec({


    "je veux prendre un ticket au parcemetre pour 30 minutes" .config(enabled = false)  {
        val parcmetre =
            boundedContexts.location.domain.agregates.BorneLocation(boundedContexts.location.utilities.LinearIdGenerator())

        val ticket  = parcmetre.EmettreTicket(duree = 30 * minutes)

        ticket.dureeDeLocation shouldBe  30 * minutes


    }


    "je veux prendre un ticket au parcemetre pour 120 minutes" .config(enabled = true) {

        val sut =
            boundedContexts.location.domain.agregates.BorneLocation(boundedContexts.location.utilities.LinearIdGenerator())

        val ticket  = sut.EmettreTicket(argent =  Monnaie(1, Devises.EUROS))

        ticket.Id shouldBe "FAUX-ID-1"
        ticket.dureeDeLocation shouldBe   120 * minutes
    }

    "je veux prendre un ticket au parcemetre pour 240 minutes" .config(enabled = true) {
        val sut =
            boundedContexts.location.domain.agregates.BorneLocation(boundedContexts.location.utilities.LinearIdGenerator())

        val ticket  = sut.EmettreTicket(argent =  Monnaie(2, Devises.EUROS))

        ticket.dureeDeLocation shouldBe   240 * minutes
        ticket.Id shouldBe "FAUX-ID-1"
    }

    "deux tickets créés ont deux identificants distincts" .config(enabled = true) {
        val sut =
            boundedContexts.location.domain.agregates.BorneLocation(boundedContexts.location.utilities.LinearIdGenerator())

        val ticket1  = sut.EmettreTicket(argent =  Monnaie(2, Devises.EUROS))
        val ticket2  = sut.EmettreTicket(argent =  Monnaie(2, Devises.EUROS))

        ticket1 shouldNotBe   ticket2
        ticket1.Id shouldNotBe   ticket2.Id
    }


    "pour 2 heures on paye 1 euros" .config(enabled = true) {
        val sut =
            boundedContexts.location.domain.agregates.BorneLocation(boundedContexts.location.utilities.LinearIdGenerator())
        val ticket  = sut.EmettreTicket(duree = 120 * minutes )

        ticket.dureeDeLocation shouldBe  120 * minutes
        ticket.dureeDeLocation.amount shouldBe 120
        ticket.prix shouldBe  Monnaie(1, Devises.EUROS)
    }

    "au delà de 4 heures on paye 4 euros" .config(enabled = true) {
        val sut =
            boundedContexts.location.domain.agregates.BorneLocation(boundedContexts.location.utilities.LinearIdGenerator())
        val ticket  = sut.EmettreTicket(duree = 5 * hours )

        ticket.dureeDeLocation shouldBe  300 * minutes
        ticket.dureeDeLocation shouldBe  5 * hours

        ticket.dureeDeLocation.amount shouldBe 300
        ticket.prix shouldBe  Monnaie(4, Devises.EUROS)
    }


    // TODO: durée maximum de la location   ???


})