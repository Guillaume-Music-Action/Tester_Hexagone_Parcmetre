package boundedContexts.location.ports

interface ITicketRepository {

    fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto): Result<Boolean>

    fun countTickets(): Result<Int>

    fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>>

}