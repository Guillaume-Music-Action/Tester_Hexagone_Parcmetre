package parcmetre.metier

import parcmetre.comportements.ToutesLesHorloges
import java.time.LocalDateTime

class Ticket(horloge: ToutesLesHorloges, duree: Int) {

    val heureDebutStationnement: LocalDateTime = horloge.quelleHeureEstIl()

    val heureFinStationnement: LocalDateTime = heureDebutStationnement.plusMinutes(duree.toLong())

}
