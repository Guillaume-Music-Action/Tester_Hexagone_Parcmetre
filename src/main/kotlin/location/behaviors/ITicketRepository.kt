package location.behaviors

import location.models.DTOs.TicketDto

interface ITicketRepository {
    fun saveTicket(ticket: TicketDto): Result<Boolean>
    fun cardinalityTickets(): Result<Int>
    fun getTickets(): Result<List<TicketDto>>
}