package parcmetre.adapters.driven.storage.postGreSQL

import parcmetre.behaviors.ITicketRepository
import parcmetre.models.DTOs.TicketDto
import java.sql.DriverManager


class TicketRepository(jdbcUrl: String, username: String, password: String) : ITicketRepository {
    private val storageConnection = DriverManager.getConnection(jdbcUrl, username, password)


    fun createTableTicket()  = runCatching {
        val createTableStatement = storageConnection.prepareStatement(
            """ 
                create table if not exists ticket(
                    id decimal(8) primary key,
                    park_time_minutes decimal(4,0)
                )
            """.trimIndent()
        )
        createTableStatement.execute()
    }

    override fun saveTicket(ticket: TicketDto)  = runCatching {
        val insertStatement = storageConnection.prepareStatement(
            "insert into ticket(id, park_time_minutes) values (?, ?)"
        )
        insertStatement.setInt(1, ticket.id)
        insertStatement.setInt(2, ticket.elapseMinutes)
        insertStatement.execute()
    }

    override fun cardinalityTickets(): Result< Int> = runCatching {
        val selectStatement = storageConnection.prepareStatement(
            "select count(*) as cardinalityTickets from ticket"
        )
        val result = selectStatement.executeQuery()
        result.next()
        var res =  result.getInt("cardinalityTickets")
        return Result.success( res)
    }

    override fun getTickets(): Result<List<TicketDto>> {
        TODO("Not yet implemented")
    }
}