package location.useCases

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import location.behaviors.IJeDonneDesIdentifiants
import location.behaviors.IRequestHandler
import location.domain.entities.CentraleLocation
import location.domain.entities.Ticket
import location.domain.valueObjects.Devises
import location.domain.valueObjects.Monnaie

@Suppress("UNREACHABLE_CODE")
class AcheterUnTicketDeLocation(val generateurId: IJeDonneDesIdentifiants)  : IRequestHandler<DemandeDuTicket, Result<Ticket>> {

    override suspend fun handle(demande: DemandeDuTicket): Result<Ticket>  = coroutineScope {
        println("on demarre le request handler, ca va prendre du temps")

        //faire ici l'appel métier
        // il nous faut un private val generateurId: IJeDonneDesIdentifiants
       val centraleLocation = CentraleLocation( generateurId )

       val ticket = centraleLocation.CreerTicket( Monnaie( demande.montantEuro,  Devises.EUROS ))

        //puis l'appel à l'adapter de stockage
        appelBaseDeDonnees(150) // c'est un exemple, dans la vraie vie on va appeler le stockage qui est "lent"


           //Result.failure(TODO("faites passer ce test au vert"))
         Result.success(ticket)

    }





    suspend fun appelBaseDeDonnees(times : Int, char: Char = '.') = coroutineScope {
      println("appel long (${times})")
        repeat(times) {
            delay(10)  // Delay for 10 milliseconds
            print(char)
        }
    }
}



