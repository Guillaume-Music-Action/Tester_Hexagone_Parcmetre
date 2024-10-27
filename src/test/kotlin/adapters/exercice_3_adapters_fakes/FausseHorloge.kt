package adapters.exercice_3_adapters_fakes

import kotlinx.datetime.LocalDateTime
import boundedContexts.location.ports.ILesHorloges


class FausseHorloge(val leMaintenant: LocalDateTime) : ILesHorloges {

    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}

