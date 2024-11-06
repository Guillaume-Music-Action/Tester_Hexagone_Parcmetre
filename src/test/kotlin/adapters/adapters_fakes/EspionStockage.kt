package adapters.adapters_fakes

import boundedContexts.location.ports.ITicketRepository

class EspionStockage : ITicketRepository {
    private var compteur = 0

    val SaveCombienDeFois: Int
        get() = compteur

    override fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto): Result<Boolean> {
        compteur++
       return Result.success(true)
    }

    override fun countTickets(): Result<Int> {
        TODO("Not yet implemented")
    }

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> {
        TODO("Not yet implemented")
    }
}