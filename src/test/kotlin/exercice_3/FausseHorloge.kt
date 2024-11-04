package exercice_3

import kotlinx.datetime.LocalDateTime
import boundedContexts.location.ports.ILesHorloges


class FausseHorloge(val leMaintenant: LocalDateTime) : ILesHorloges {

    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}

