package parcmetre.metier

class ParcMetre(val laBase: UneBaseDeTickets) {

    fun creer(ticket: Ticket) {
        laBase.enregistrer(ticket)
    }

    fun retrouverTous(): List<Ticket> = laBase.retrouver()

}
