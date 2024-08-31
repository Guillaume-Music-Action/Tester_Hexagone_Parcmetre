package adapters.fakes

import parcmetre.metier.Ticket
import parcmetre.metier.UneBaseDeTickets

class FauxStockage : UneBaseDeTickets {

    val listDesTickets = mutableListOf<Ticket>()

    override fun enregistrer(ticket: Ticket) {
        listDesTickets.add(ticket)
    }

    override fun retrouver(): List<Ticket> = listDesTickets

}

