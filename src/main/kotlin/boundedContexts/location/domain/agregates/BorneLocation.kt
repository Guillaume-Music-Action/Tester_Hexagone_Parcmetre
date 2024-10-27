package boundedContexts.location.domain.agregates

//TODO: enlever cette dépendance et coder notre propre Value Object: "Durée"
import io.nacular.measured.units.Measure
import io.nacular.measured.units.Time
import io.nacular.measured.units.Time.Companion.minutes
import io.nacular.measured.units.times

import boundedContexts.universel.valueObjects.Devises
import boundedContexts.universel.valueObjects.Monnaie
import boundedContexts.location.ports.IJeDonneDesIdentifiants

private const val prixEnEurosPour30Minutes = 0.25
private val dureeTrancheHoraire = 30 * minutes
private val dureeTrancheHoraireMinutes = 30

//que fait elle / quelles sont ses responsabilités ?
class BorneLocation(private val generateurId: IJeDonneDesIdentifiants) {


    fun EmettreTicket(argent: Monnaie): boundedContexts.location.domain.entities.Ticket =
        boundedContexts.location.domain.entities.Ticket(
            Id = generateurId.idSuivant(),
            dureeDeLocation = (argent.valeur / boundedContexts.location.domain.agregates.prixEnEurosPour30Minutes) * boundedContexts.location.domain.agregates.dureeTrancheHoraire,
            prix = Monnaie.Zero(),
        )


    fun EmettreTicket(duree: Measure<Time>): boundedContexts.location.domain.entities.Ticket =
        boundedContexts.location.domain.entities.Ticket(
            Id = generateurId.idSuivant(),
            dureeDeLocation = duree,
            prix = when {
                duree <= 240 * minutes -> Monnaie(
                    ((duree / boundedContexts.location.domain.agregates.dureeTrancheHoraireMinutes) * boundedContexts.location.domain.agregates.prixEnEurosPour30Minutes).amount.toInt(),
                    Devises.EUROS
                )

                else -> Monnaie(4, Devises.EUROS)
            }  // prix pour 4 heures au delà de 240 minutes

        )
}
