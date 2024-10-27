package adapters.exercice_3_adapters_fakes

import kotlinx.datetime.LocalDateTime
import boundedContexts.location.behaviors.ILesHorloges


class FausseHorloge(val leMaintenant: LocalDateTime) : boundedContexts.location.behaviors.ILesHorloges {

    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}

