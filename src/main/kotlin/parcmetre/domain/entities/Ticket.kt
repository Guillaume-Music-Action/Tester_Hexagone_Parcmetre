package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import kotlinx.datetime.LocalDateTime
import ulid.ULID

data class Ticket(
    val id: String = ULID.randomULID(),  //extarnilser la création du Id du ticket
    val heureEntree : LocalDateTime,
    val dureeDeStationnment : Measure<Time>
) {
}

class UsineDeTickets(idGenerateur: IdGenerateur) {
    fun Creation(heureEntree: LocalDateTime, dureeMinutes: Int): Ticket {
        TODO()
    }

    fun Creation(heureEntree: LocalDateTime, duree: Measure<Time>): Ticket {
        TODO()
    }

}

object IdGenerateur {

}