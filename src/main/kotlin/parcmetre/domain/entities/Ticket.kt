package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.seconds
import io.nacular.measured.units.times
import kotlinx.datetime.*
import ulid.ULID

data class Ticket(

    val heureEntree : LocalDateTime,
    // montant ?
    val dureeDeStationnment : Measure<Time>
)
{
    companion object {
         fun bidon(): Ticket {
            return Ticket(
               // id =  "",
                heureEntree =  LocalDateTime.parse("2000-01-01T00:00:00") ,
                dureeDeStationnment = (0 * seconds)
            )
        }
    }
}

// val id: String ,  //extarnilser la création du Id du ticket