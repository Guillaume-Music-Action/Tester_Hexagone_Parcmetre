package parcmetre.domain.entities

import parcmetre.behaviors.UneBaseDeTickets

class ParcMetre(val laBase: UneBaseDeTickets) {

    fun creer(ticket: Ticket) {
        laBase.enregistrer(ticket)
    }

    fun retrouverTous(): List<Ticket> = laBase.retrouver()

}
