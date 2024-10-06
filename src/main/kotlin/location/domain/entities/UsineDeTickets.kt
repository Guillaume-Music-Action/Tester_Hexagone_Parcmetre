package location.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import kotlinx.datetime.LocalDateTime
import location.behaviors.IJeDonneDesIdentifiants

class UsineDeTickets(val idGenerateur: IJeDonneDesIdentifiants) {

    fun Creation(heureEntree: LocalDateTime, duree: Measure<Time>): Ticket {
        TODO()
    }

}




//val id = this.idGenerateur.idSuivant()