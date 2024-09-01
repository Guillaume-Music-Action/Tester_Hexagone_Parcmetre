package adapters.fakes

import parcmetre.behaviors.ILesHorloges
import java.time.LocalDateTime

class FausseHorloge(val leMaintenant: LocalDateTime) : ILesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}
