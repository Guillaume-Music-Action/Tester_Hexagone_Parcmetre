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
class `2_CentraleLocation_Identifers_Tests` : StringSpec({


    "je veux prendre un ticket et il doit avoir un Id testable" .config(enabled = false)  {

        val borneLocation = BorneLocation(UlidGenerateur())

        val ticket  = borneLocation.EmettreTicket(duree = 30 * minutes)

        ticket.dureeDeLocation shouldBe  1800 * seconds
        ticket.Id shouldBe "01JBEE2F630FN3R662Q5HN24M6"
        // pas testable parce que c'est aléatoire
    }

    "je veux prendre un ticket à la borne pour 240 minutes et il a un Id" .config(enabled = true) {
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







})