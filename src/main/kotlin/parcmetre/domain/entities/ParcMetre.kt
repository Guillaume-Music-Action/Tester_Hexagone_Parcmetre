package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import parcmetre.domain.valueObjects.Monnaie

class ParcMetre(val Id: String) {


    //que fait il / quelles sont ses responsabilités
    fun EditerTicker(duree: Measure<Time>): Ticket {
        TODO()
    }

    fun EditerTicker(argent: Monnaie): Ticket {
        TODO("Not yet implemented")
    }


}
