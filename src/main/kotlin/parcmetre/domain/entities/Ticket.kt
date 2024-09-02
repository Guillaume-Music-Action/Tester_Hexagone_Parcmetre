package parcmetre.domain.entities

import kotlinx.datetime.LocalDateTime
import ulid.ULID

data class Ticket(
    val id: String = ULID.randomULID(),  //extarnilser la création du Id du ticket
    val heureEntree : LocalDateTime,
    val dureeDeStationnmentEnMinutes : Int
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