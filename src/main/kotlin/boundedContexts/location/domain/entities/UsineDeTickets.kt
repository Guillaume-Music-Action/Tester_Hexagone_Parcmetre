package boundedContexts.location.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import kotlinx.datetime.LocalDateTime
import boundedContexts.location.ports.IJeDonneDesIdentifiants

class UsineDeTickets(val idGenerateur: IJeDonneDesIdentifiants) {

    fun Creation(heureEntree: LocalDateTime, duree: Measure<Time>): boundedContexts.location.domain.entities.Ticket {
        TODO()
    }

}


//val id = this.idGenerateur.idSuivant()