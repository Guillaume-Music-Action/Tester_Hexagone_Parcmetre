package parcmetre.adapters.storage.postGreSQL

import parcmetre.models.DTOs.TicketDto
import java.sql.DriverManager


class TicketRepository(jdbcUrl: String, username: String, password: String) {
    private val storageConnection = DriverManager.getConnection(jdbcUrl, username, password)
    fun createTableTicket() {
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

    fun saveTicket(ticket: TicketDto) {
        val insertStatement = storageConnection.prepareStatement(
            "insert into ticket(id, park_time_minutes) values (?, ?)"
        )
        insertStatement.setInt(1, ticket.id)
        insertStatement.setInt(2, ticket.elapseMinutes)
        insertStatement.execute()
    }

    fun cardinalityTickets(): Int {
        val selectStatement = storageConnection.prepareStatement(
            "select count(*) as cardinalityTickets from ticket"
        )
        val result = selectStatement.executeQuery()
        result.next()
        return result.getInt("cardinalityTickets")
    }
}