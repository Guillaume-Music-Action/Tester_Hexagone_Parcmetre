package parcmetre.domain.entities

import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times
import parcmetre.behaviors.IJeDonneDesIdentifiants
import parcmetre.domain.valueObjects.Monnaie

private const val prixEnEurosPour30Minutes = 0.25
private  val dureeTrancheHoraire = 30 * minutes

class ParcMetre(val Id: String, val generateurId: IJeDonneDesIdentifiants) {


    fun CreerTicket(argent: Monnaie): Ticket  = Ticket(
        Id =  generateurId.idSuivant(),
        dureeDeStationnment = (argent.valeur / prixEnEurosPour30Minutes ) * dureeTrancheHoraire )





    //que fait il / quelles sont ses responsabilités
    fun CreerTicket(duree: Measure<Time>): Ticket {
        TODO()
    }
}
