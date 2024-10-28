package boundedContexts.location.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import kotlinx.datetime.LocalDateTime
import boundedContexts.location.ports.IJeDonneDesIdentifiants
import boundedContexts.universel.valueObjects.Devises
import boundedContexts.universel.valueObjects.Monnaie

class UsineDeTickets(val idGenerateur: IJeDonneDesIdentifiants) {

    fun Creation(heureEntree: LocalDateTime, duree: Measure<Time>): Ticket =
        Ticket(idGenerateur.idSuivant() ,duree, Monnaie(0, Devises.EUROS) )

}


//val id = this.idGenerateur.idSuivant()