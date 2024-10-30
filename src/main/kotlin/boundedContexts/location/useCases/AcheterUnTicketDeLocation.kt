package boundedContexts.location.useCases

import boundedContexts.location.behaviors.IRequestHandler
import boundedContexts.location.domain.agregates.BorneLocation
import boundedContexts.location.domain.entities.Ticket
import boundedContexts.location.models.DTOs.TicketDto
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import boundedContexts.location.ports.IJeDonneDesIdentifiants
import boundedContexts.location.ports.ITicketRepository
import boundedContexts.universel.valueObjects.Devises
import boundedContexts.universel.valueObjects.Monnaie


class AcheterUnTicketDeLocation(val generateurId: IJeDonneDesIdentifiants, val dataAdapter: ITicketRepository) :
    IRequestHandler<DemandeDuTicket, Result<Ticket>> {


    override  fun handle(demande: DemandeDuTicket): Result<Ticket>   {
        println("on demarre le request handler, ca va prendre du temps")

        //faire ici l'appel métier
        val centraleLocation = BorneLocation(generateurId)
        val ticket = centraleLocation.EmettreTicket(Monnaie(demande.montantEuro, Devises.EUROS))

        //puis l'appel à l'adapter de stockage
        var ticketDto = TicketDto(id = ticket.Id, amountOfMinutes = ticket.dureeDeLocation.amount.toInt())

        val result = dataAdapter.saveTicket(ticketDto)
        //handle dataAdapter failure

        return Result.success(ticket)
    }


}



