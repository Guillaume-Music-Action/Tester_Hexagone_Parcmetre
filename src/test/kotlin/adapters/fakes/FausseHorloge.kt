package adapters.fakes

import kotlinx.datetime.LocalDateTime
import parcmetre.behaviors.ILesHorloges


class FausseHorloge(val leMaintenant: LocalDateTime) : ILesHorloges {

    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}

