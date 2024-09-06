package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import parcmetre.domain.valueObjects.Monnaie

class ParcMetre(val Id: String) {



    fun CreerTicket(argent: Monnaie): Ticket  = Ticket(  dureeDeStationnment = 120 * minutes)





    //que fait il / quelles sont ses responsabilités
    fun CreerTicket(duree: Measure<Time>): Ticket {
        TODO()
    }
}
