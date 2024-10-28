package adapters.exercice_3_adapters_fakes

import boundedContexts.location.ports.ITicketRepository

class FauxStockage : ITicketRepository {


    override fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto): Result<Boolean> {
       TODO()
    }

    override fun cardinalityTickets(): Result<Int> =  TODO()

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> =  TODO()

}


