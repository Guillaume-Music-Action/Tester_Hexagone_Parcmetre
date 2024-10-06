package location.useCases

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import location.behaviors.IRequestHandler

@Suppress("UNREACHABLE_CODE")
class AcheterUnTicketDeLocation : IRequestHandler<DemandeDuTicket, ReponseALaDemandeDuTicket> {

    constructor( )

    override suspend fun handle(demande: DemandeDuTicket): ReponseALaDemandeDuTicket  = coroutineScope {
        println("on demarre le request handler, ca va prendre du temps")

        //faire ici l'appel métier
       // var centraleLocation = CentraleLocation( ) -> on l'a déjà

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



