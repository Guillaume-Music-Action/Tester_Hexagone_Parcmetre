package parcmetre.domain.entities

import kotlinx.datetime.LocalDateTime
import ulid.ULID


data class Ticket(
    val id: String = ULID.randomULID(),
    val marqueurEntree : LocalDateTime
)