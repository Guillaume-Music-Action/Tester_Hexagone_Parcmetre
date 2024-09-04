package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.seconds
import io.nacular.measured.units.times
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ulid.ULID

data class Ticket(
    val id: String ,  //extarnilser la création du Id du ticket
    val heureEntree : LocalDateTime,
    val dureeDeStationnment : Measure<Time>
) {
    companion object {
         fun bidon(): Ticket {
            return Ticket(
            id =  ULID.randomULID(),  //générer un id unique à chaque création de ticket
                heureEntree = Clock.System.now().toLocalDateTime(TimeZone.UTC),
                dureeDeStationnment = (0 * seconds)
            )
        }
    }
}

