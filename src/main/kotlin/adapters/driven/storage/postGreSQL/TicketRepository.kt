package adapters.driven.storage.postGreSQL

import boundedContexts.location.ports.ITicketRepository
import java.sql.DriverManager


class TicketRepository(jdbcUrl: String, username: String, password: String) :
    ITicketRepository {

    private val storageConnection = DriverManager.getConnection(jdbcUrl, username, password)


    fun createTableTicket() = runCatching {
        val createTableStatement = storageConnection.prepareStatement(
            """ 
                  CREATE TABLE IF NOT EXISTS ticket (
        id VARCHAR PRIMARY KEY,
        park_time_minutes DECIMAL(4, 0)
                )
            """.trimIndent()
        )
        createTableStatement.execute()
    }

    override fun saveTicket(ticket: boundedContexts.location.models.DTOs.TicketDto) = runCatching {
        val insertStatement = storageConnection.prepareStatement(
            "insert into ticket(id, park_time_minutes) values (?, ?)"
        )
        insertStatement.setString(1, ticket.id)
        insertStatement.setInt(2, ticket.elapseMinutes)
        insertStatement.execute()
    }

    override fun cardinalityTickets(): Result<Int> = runCatching {
        val selectStatement = storageConnection.prepareStatement(
            "select count(*) as cardinalityTickets from ticket"
        )
        val result = selectStatement.executeQuery()
        result.next()
        val res = result.getInt("cardinalityTickets")
        return Result.success(res)
    }

    override fun getTickets(): Result<List<boundedContexts.location.models.DTOs.TicketDto>> {
        TODO("Not yet implemented")
    }

    override fun start() {
       createTableTicket()
    }
}