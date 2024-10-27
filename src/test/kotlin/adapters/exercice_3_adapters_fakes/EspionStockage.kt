package adapters.exercice_3_adapters_fakes

import boundedContexts.location.behaviors.ITicketRepository
import boundedContexts.location.models.DTOs.TicketDto

class EspionStockage : boundedContexts.location.behaviors.ITicketRepository {
    override fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto): Result<Boolean> {
       return Result.success(true)
    }

    override fun cardinalityTickets(): Result<Int> {
        TODO("Not yet implemented")
    }

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> {
        TODO("Not yet implemented")
    }
}