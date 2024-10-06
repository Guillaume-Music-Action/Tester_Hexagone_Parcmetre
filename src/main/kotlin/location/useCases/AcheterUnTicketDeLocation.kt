package location.useCases

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import location.behaviors.IJeDonneDesIdentifiants
import location.behaviors.IRequestHandler
import location.domain.entities.CentraleLocation
import location.domain.entities.Ticket
import location.domain.valueObjects.Devises
import location.domain.valueObjects.Monnaie


class AcheterUnTicketDeLocation(val generateurId: IJeDonneDesIdentifiants) :
    IRequestHandler<DemandeDuTicket, Result<Ticket>> {

    override suspend fun handle(demande: DemandeDuTicket): Result<Ticket> = coroutineScope {
        println("on demarre le request handler, ca va prendre du temps")

        //faire ici l'appel métier
        val centraleLocation = CentraleLocation(generateurId)
        val ticket = centraleLocation.CreerTicket(Monnaie(demande.montantEuro, Devises.EUROS))

        //puis l'appel à l'adapter de stockage
        fauxAppelBaseDeDonnees(150) // c'est un exemple, dans la vraie vie on va appeler le stockage qui est "lent"

        // Block Body Lambda If the lambda body contains multiple statements, the last expression is returned implicitly.
        Result.success(ticket)
        //Result.failure(TODO("faites passer ce test au vert"))
    }


    suspend fun fauxAppelBaseDeDonnees(times: Int, char: Char = '.') = coroutineScope {
        println("appel long (${times})")
        repeat(times) {
            delay(10)  // Delay for 10 milliseconds
            print(char)
        }
    }
}



