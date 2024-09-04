package parcmetre.adapters.driven

import parcmetre.behaviors.ILesHorloges
import java.time.LocalDateTime

class VraieHorloge : ILesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime {
       return LocalDateTime.now() //todo : replace by kotlinx datetime
    }

}
