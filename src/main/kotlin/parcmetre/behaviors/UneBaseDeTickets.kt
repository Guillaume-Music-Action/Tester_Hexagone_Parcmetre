package parcmetre.behaviors

import parcmetre.domain.entities.Ticket

interface UneBaseDeTickets {
    fun enregistrer(ticket: Ticket)
     fun retrouver(): List<Ticket>

}
