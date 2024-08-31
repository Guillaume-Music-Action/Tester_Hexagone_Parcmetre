package parcmetre.adapteurs

import parcmetre.comportements.ToutesLesHorloges
import java.time.LocalDateTime

class VraieHorloge : ToutesLesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime {
       return LocalDateTime.now()
    }

}
