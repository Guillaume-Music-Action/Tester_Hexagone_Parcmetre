package adapters.adapters_fakes

import boundedContexts.location.models.DTOs.TicketDto
import boundedContexts.location.ports.ITicketRepository

class FauxStockage : ITicketRepository {

    val listeDeTicket = mutableListOf<TicketDto>()

    override fun saveTicket(ticket: TicketDto): Result<Boolean> {
        listeDeTicket.add(ticket)
        return Result.success(true)
    }

    override fun countTickets(): Result<Int> = Result.success(listeDeTicket.size)
    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> =
        Result.success(listeDeTicket)
}




