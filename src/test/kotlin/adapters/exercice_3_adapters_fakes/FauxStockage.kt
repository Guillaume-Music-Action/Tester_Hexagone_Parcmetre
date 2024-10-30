package adapters.exercice_3_adapters_fakes

import boundedContexts.location.domain.entities.Ticket
import boundedContexts.location.models.DTOs.TicketDto
import boundedContexts.location.ports.ITicketRepository
import kotlinx.coroutines.newSingleThreadContext

class FauxStockage : ITicketRepository {

    val listeDeTicket = mutableListOf<TicketDto>()

    override fun saveTicket(ticket: TicketDto): Result<Boolean> {
        listeDeTicket.add(ticket)
        return Result.success(true)
    }

    override fun cardinalityTickets(): Result<Int> =  TODO()

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> =  TODO()

}


