package adapters.driven

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import boundedContexts.location.behaviors.ILesHorloges


class VraieHorloge : boundedContexts.location.behaviors.ILesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.UTC)
    }

}
