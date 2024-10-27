package boundedContexts.location.ports

import kotlinx.datetime.LocalDateTime


interface ILesHorloges {

    fun quelleHeureEstIl(): LocalDateTime

}
