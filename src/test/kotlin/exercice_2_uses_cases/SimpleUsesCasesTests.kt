package exercice_2_uses_cases

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


    "l'utilisateur prend un ticket et celui est enregistré pour de bon'" {

        val demande = DemandeDuTicket(immatriculationVehicule = "imma", montantEuro = 5)
        val useCase = AcheterUnTicketAuParcmetre()


        println("on demarre  la couroutine")
        coroutineScope {

            val continuation = async { useCase.handle(demande) }
            println("dans la couroutine, on n'attends pas le resultat")
            val res= continuation.await()
            res.resultat shouldBeSuccess
             res   .resultat.getOrNull() shouldNotBe null
            println("dans la couroutine, maintenant, on a attendu le resultat")

        }

        println("et c'est fini !")


    }
})

