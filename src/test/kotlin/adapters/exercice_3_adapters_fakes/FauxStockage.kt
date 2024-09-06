package adapters.exercice_3_adapters_fakes

import parcmetre.behaviors.ITicketRepository

import parcmetre.models.DTOs.TicketDto

class FauxStockage : ITicketRepository {

    val listDesTickets = mutableListOf<TicketDto>()

    override fun saveTicket(ticket: TicketDto) = runCatching {
        listDesTickets.add(ticket)
    }

    override fun cardinalityTickets(): Result<Int> = Result.success(listDesTickets.size)

    override fun getTickets(): Result<List<TicketDto>> = Result.success( listDesTickets)

}


