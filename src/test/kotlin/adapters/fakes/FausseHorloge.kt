package adapters.fakes

import parcmetre.comportements.ToutesLesHorloges
import java.time.LocalDateTime

class FausseHorloge(val leMaintenant: LocalDateTime) : ToutesLesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}
