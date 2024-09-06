package exercice_4_uses_cases

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import parcmetre.useCases.AcheterUnTicketAuParcmetre
import parcmetre.useCases.DemandeDuTicket


class SimpleUsesCasesTests : StringSpec({
    /*A use case is executed from a controller, it may access any external services
    using any of the output ports available to it,
    it often loads one or several aggregates and invokes business logic on them.*/


    "l'utilisateur prend un ticket et celui est enregistré pour de bon" .config(enabled = false) {

        val demande = DemandeDuTicket(immatriculationVehicule = "imma", montantEuro = 5)
        val useCase = AcheterUnTicketAuParcmetre()

        coroutineScope {

            val continuation = async { useCase.handle(demande) }
            val res= continuation.await()
            res.resultat shouldBeSuccess
            res.resultat.getOrNull() shouldNotBe null

        }
        // verifier avec l'adapter que le ticket est bien dedans

    }
})

