package boundedContexts.location.useCases

import boundedContexts.location.domain.entities.Ticket

data class ReponseALaDemandeDuTicket(val resultat: Result<boundedContexts.location.domain.entities.Ticket>) {

}