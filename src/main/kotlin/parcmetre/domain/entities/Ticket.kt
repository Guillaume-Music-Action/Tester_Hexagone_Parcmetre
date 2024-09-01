package parcmetre.domain.entities

import parcmetre.behaviors.ILesHorloges
import java.time.LocalDateTime

class Ticket(horloge: ILesHorloges, duree: Int) {

    val heureDebutStationnement: LocalDateTime = horloge.quelleHeureEstIl()

    val heureFinStationnement: LocalDateTime = heureDebutStationnement.plusMinutes(duree.toLong())

}
