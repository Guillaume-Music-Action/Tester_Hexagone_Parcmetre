package adapters.driven.timeProviders

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import boundedContexts.location.ports.ILesHorloges


class VraieHorloge : ILesHorloges {
    override fun quelleHeureEstIl(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.UTC)
    }

}
