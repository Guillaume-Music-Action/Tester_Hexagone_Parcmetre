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
    companion object {
        fun Creation(idGenerateur: IdGenerateur, localDateTime: LocalDateTime, i: Int): Ticket {
        TODO()
        }
    }
}

class UsineDeTickets(idGenerateur: IdGenerateur) {
    fun Creation(localDateTime: LocalDateTime, i: Int): Ticket {
        TODO()
    }

}

object IdGenerateur {

}