package adapters.exercice_3_adapters_fakes

import boundedContexts.location.behaviors.ITicketRepository

import boundedContexts.location.models.DTOs.TicketDto

class FauxStockage : boundedContexts.location.behaviors.ITicketRepository {

    val listDesTickets = mutableListOf<boundedContexts.location.models.DTOs.TicketDto>()

    override fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto) = runCatching {
        listDesTickets.add(ticket)
    }

    override fun cardinalityTickets(): Result<Int> = Result.success(listDesTickets.size)

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> = Result.success( listDesTickets)

}


