package exercice_4_uses_cases

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import boundedContexts.location.useCases.AcheterUnTicketDeLocation
import boundedContexts.location.useCases.DemandeDuTicket
import boundedContexts.location.utilities.LinearIdGenerator
import boundedContexts.location.utilities.testableIdGenerateur


class SimpleUsesCasesTests : StringSpec({
    /*A use case is executed from a controller, it may access any external services
    using any of the output ports available to it,
    it often loads one or several aggregates and invokes business logic on them.*/


    "l'utilisateur prend un ticket et celui est enregistré pour de bon" .config(enabled = true) {

        val demande =
            boundedContexts.location.useCases.DemandeDuTicket(immatriculationVehicule = "imma", montantEuro = 5)
        val useCase =
            boundedContexts.location.useCases.AcheterUnTicketDeLocation(generateurId = boundedContexts.location.utilities.LinearIdGenerator())

        coroutineScope {

            val continuation = async { useCase.handle(demande) }
            val res= continuation.await()
            res shouldBeSuccess
            res.getOrNull() shouldNotBe null

        }
        // verifier avec l'adapter que le ticket est bien dedans

    }
})

