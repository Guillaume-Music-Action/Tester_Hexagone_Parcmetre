package location.domain.agregates

//TODO: enlever cette dépendance et coder notre propre Value Object: "Durée"
import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times

import boundedContexts.capitalisme.valueObjects.Devises
import boundedContexts.capitalisme.valueObjects.Monnaie
import location.behaviors.IJeDonneDesIdentifiants
import location.domain.entities.Ticket

private const val prixEnEurosPour30Minutes = 0.25
private val dureeTrancheHoraire = 30 * minutes
private val dureeTrancheHoraireMinutes = 30

//que fait elle / quelles sont ses responsabilités ?
class BorneLocation(private val generateurId: IJeDonneDesIdentifiants) {


    fun EmettreTicket(argent: Monnaie): Ticket = Ticket(
        Id = generateurId.idSuivant(),
        dureeDeLocation = (argent.valeur / prixEnEurosPour30Minutes) * dureeTrancheHoraire,
        prix = Monnaie.Zero(),
    )


    fun EmettreTicket(duree: Measure<Time>): Ticket = Ticket(
        Id = generateurId.idSuivant(),
        dureeDeLocation = duree,
        prix = when {
            duree.amount <= 240 -> Monnaie(
                ((duree / dureeTrancheHoraireMinutes) * prixEnEurosPour30Minutes).amount.toInt(),
                Devises.EUROS                )
            else -> Monnaie(4, Devises.EUROS)
        }  // prix pour 4 heures au delà de 240 minutes

    )
}
