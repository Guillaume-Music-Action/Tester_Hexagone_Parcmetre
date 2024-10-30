package exercice_4_uses_cases

import adapters.exercice_3_adapters_fakes.FauxStockage
import boundedContexts.location.useCases.AcheterUnTicketDeLocation
import boundedContexts.location.useCases.DemandeDuTicket
import boundedContexts.location.utilities.LinearIdGenerator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.shouldNotBe


class SimpleUsesCasesTests : StringSpec({
    /*A use case is executed from a controller, it may access any external services
    using any of the output ports available to it,
    it often loads one or several aggregates and invokes business logic on them.*/


    "l'utilisateur prend un ticket et celui est enregistré pour de bon".config(enabled = true) {

        val demande =   DemandeDuTicket( montantEuro = 5)
        val useCase =
            AcheterUnTicketDeLocation(
                generateurId = LinearIdGenerator(),
                dataAdapter = FauxStockage()
            )

        val res = useCase.handle(demande)

        res shouldBeSuccess
                res.getOrNull() shouldNotBe null

        // verifier avec l'adapter que le ticket est bien dedans
    }
})

