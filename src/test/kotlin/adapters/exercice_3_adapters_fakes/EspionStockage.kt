package adapters.exercice_3_adapters_fakes

import location.behaviors.ITicketRepository
import location.models.DTOs.TicketDto

class EspionStockage : ITicketRepository {
    override fun saveTicket(ticket: TicketDto): Result<Boolean> {
       return Result.success(true)
    }

    override fun cardinalityTickets(): Result<Int> {
        TODO("Not yet implemented")
    }

    override fun getTickets(): Result<List<TicketDto>> {
        TODO("Not yet implemented")
    }
}