package adapters.exercice_3_adapters_fakes

import boundedContexts.location.ports.ITicketRepository

class FauxStockage : ITicketRepository {

    val listDesTickets = mutableListOf<boundedContexts.location.models.DTOs.TicketDto>()

    override fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto) = runCatching {
        listDesTickets.add(ticket)
    }

    override fun cardinalityTickets(): Result<Int> = Result.success(listDesTickets.size)

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> = Result.success( listDesTickets)

}


