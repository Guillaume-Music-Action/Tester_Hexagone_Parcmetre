package boundedContexts.location.domain.agregates

//TODO: enlever cette dépendance et coder notre propre Value Object: "Durée"
import boundedContexts.location.domain.entities.Ticket
import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times

import boundedContexts.universel.valueObjects.Devises
import boundedContexts.universel.valueObjects.Monnaie
import boundedContexts.location.ports.IJeDonneDesIdentifiants
import io.nacular.measured.units.Time.Companion.hours

private const val prixEnEurosPour30Minutes = 0.25
private val dureeTrancheHoraire = 30 * minutes
private val dureeTrancheHoraireMinutes = 30

//que fait elle / quelles sont ses responsabilités ?
class BorneLocation(private val generateurId: IJeDonneDesIdentifiants) {


    fun EmettreTicket(argent: Monnaie): Ticket =
        Ticket(
            Id = generateurId.idSuivant(),
            dureeDeLocation = (argent.valeur / prixEnEurosPour30Minutes) * dureeTrancheHoraire,
            prix = Monnaie.Zero(),
        )


    fun EmettreTicket(duree: Measure<Time>): Ticket =
        Ticket(
            Id = generateurId.idSuivant(),
            dureeDeLocation = duree,
            prix = when {
                duree <= 240 * minutes -> Monnaie(
                    ((duree / dureeTrancheHoraireMinutes) * prixEnEurosPour30Minutes).amount.toInt(),
                    Devises.EUROS
                )
                else -> Monnaie(4, Devises.EUROS)
            }  // prix pour 4 heures au delà de 240 minutes

        )

    fun EmettreTicketResult(duree: Measure<Time>): Result<Ticket>  {
        if ( duree > 8 * hours)
            return Result.failure(  Exception("durée limitée à 8 heures maximum"))
        val ticket =  EmettreTicket(duree)
        return Result.success(ticket)
    }
}
