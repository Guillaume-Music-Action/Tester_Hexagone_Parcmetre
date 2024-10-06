package location.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time

data class Ticket(
    val Id: String,
    val dureeDeLocation : Measure<Time>
)