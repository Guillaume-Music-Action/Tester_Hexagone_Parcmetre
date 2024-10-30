package boundedContexts.location.useCases

import org.apache.hc.core5.reactor.Command

data class DemandeDuTicket( val montantEuro: Int) : Commande



interface Commande {}
