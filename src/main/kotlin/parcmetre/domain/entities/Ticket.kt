package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.seconds
import io.nacular.measured.units.times
import kotlinx.datetime.*
import ulid.ULID

data class Ticket(
    val Id: String,
    val dureeDeStationnment : Measure<Time>
)
{



}

// val id: String ,  //extarnilser la création du Id du ticket