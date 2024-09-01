package parcmetre.adapters.storage

import parcmetre.behaviors.ILesHorloges
import java.time.LocalDateTime

class VraieHorloge : ILesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime {
       return LocalDateTime.now()
    }

}
