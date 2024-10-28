package boundedContexts.universel.valueObjects.mauvaiseIdee

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.hours
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times

class Temps {

    private  val mesure: Measure<Time>

    constructor(valeur: Int, unité: UniteTemps) {
        when (unité) {
            UniteTemps.minutes -> (minutes * valeur).also { mesure = it }
            UniteTemps.heures -> (hours * valeur).also { mesure = it }
        }
    }

    override fun equals(other: Any?): Boolean {
        when (other) {
            is Temps -> return mesure == other.mesure
            else -> return false
        }
    }

    operator fun compareTo(other: Any?): Int {
        when (other) {
            is Temps -> return mesure.compareTo(other.mesure)
            else -> return -1
        }
    }

    //operator fun plus(temps: Temps): Temps {}
}
