package parcmetre.useCases

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import parcmetre.behaviors.IRequestHandler

class AcheterUnTicketAuParcmetre : IRequestHandler<DemandeDuTicket, ReponseALaDemandeDuTicket> {

    override suspend fun handle(demande: DemandeDuTicket): ReponseALaDemandeDuTicket  = coroutineScope {
        println("on demarre le request handler, ca va prendre du temps")

        //launchDotPrinter(150) // c'est un exemple, dans la vraie vie on va appeler le stockage qui est "lent"

        val job1 = async { launchDotPrinter(100, '+') }
        val job2 = async { launchDotPrinter(200, '-') }
        job2.await()
        job1.await()
        println()
        println("on a eu les réponses que l'on attendait!")

         ReponseALaDemandeDuTicket(
            resultat = Result.failure(TODO("faites passer ce test au vert"))
            //resultat = Result.success(Ticket.bidon())
        )
    }

    suspend fun launchDotPrinter( times : Int, char: Char = '.') = coroutineScope {
      println("DotPrinter ${times}")
        repeat(times) {
            delay(10)  // Delay for 10 milliseconds
            print(char)
        }
    }
}



