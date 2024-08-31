package parcmetre.metier

interface UneBaseDeTickets {
    fun enregistrer(ticket: Ticket)
     fun retrouver(): List<Ticket>

}
