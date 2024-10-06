package adapters.exercice_3_adapters_fakes

import kotlinx.datetime.LocalDateTime
import location.behaviors.ILesHorloges


class FausseHorloge(val leMaintenant: LocalDateTime) : ILesHorloges {

    override fun quelleHeureEstIl(): LocalDateTime = leMaintenant

}

