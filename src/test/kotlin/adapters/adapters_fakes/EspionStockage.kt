package adapters.adapters_fakes

import boundedContexts.location.ports.ITicketRepository

class EspionStockage : ITicketRepository {
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