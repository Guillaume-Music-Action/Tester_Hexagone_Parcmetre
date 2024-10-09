package location.domain.agregates

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import location.behaviors.IJeDonneDesIdentifiants
import location.domain.entities.Ticket
import location.domain.valueObjects.Monnaie

private const val prixEnEurosPour30Minutes = 0.25
private val dureeTrancheHoraire = 30 * minutes

//que fait elle / quelles sont ses responsabilités ?
class BorneLocation(private val generateurId: IJeDonneDesIdentifiants) {


    fun CreerTicket(argent: Monnaie) : Ticket = Ticket(
            Id = generateurId.idSuivant(),
            dureeDeLocation = (argent.valeur / prixEnEurosPour30Minutes) * dureeTrancheHoraire
        )


    fun CreerTicket(duree: Measure<Time>): Ticket {
        TODO()
    }
}
