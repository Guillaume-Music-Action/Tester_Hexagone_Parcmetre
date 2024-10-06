package location.useCases

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import location.behaviors.IJeDonneDesIdentifiants
import location.behaviors.IRequestHandler
import location.domain.entities.CentraleLocation

@Suppress("UNREACHABLE_CODE")
class AcheterUnTicketDeLocation(val generateurId: IJeDonneDesIdentifiants)  : IRequestHandler<DemandeDuTicket, ReponseALaDemandeDuTicket> {

    override suspend fun handle(demande: DemandeDuTicket): ReponseALaDemandeDuTicket  = coroutineScope {
        println("on demarre le request handler, ca va prendre du temps")

        //faire ici l'appel métier
        // il nous faut un private val generateurId: IJeDonneDesIdentifiants
     //   var centraleLocation = CentraleLocation( generateurId )

        //puis l'appel à l'adapter de stockage
        appelBaseDeDonnees(150) // c'est un exemple, dans la vraie vie on va appeler le stockage qui est "lent"

         ReponseALaDemandeDuTicket(
            resultat = Result.failure(TODO("faites passer ce test au vert"))
            //resultat = Result.success(Ticket.bidon())
        )
    }





    suspend fun appelBaseDeDonnees(times : Int, char: Char = '.') = coroutineScope {
      println("appel long (${times})")
        repeat(times) {
            delay(10)  // Delay for 10 milliseconds
            print(char)
        }
    }
}



