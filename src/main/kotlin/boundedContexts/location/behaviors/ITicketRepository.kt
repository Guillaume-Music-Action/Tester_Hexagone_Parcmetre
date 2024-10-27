package boundedContexts.location.behaviors

import boundedContexts.location.models.DTOs.TicketDto

interface ITicketRepository {
    fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto): Result<Boolean>
    fun cardinalityTickets(): Result<Int>
    fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>>
}