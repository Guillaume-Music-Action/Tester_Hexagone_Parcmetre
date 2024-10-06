package location.adapters.driver


import kotlinx.coroutines.runBlocking
import location.domain.entities.Ticket
import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.ServerFilters.CatchLensFailure
import org.http4k.format.Jackson.auto
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.core.Response
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer
import location.useCases.AcheterUnTicketDeLocation
import location.useCases.DemandeDuTicket
import location.useCases.ReponseALaDemandeDuTicket
import org.http4k.core.Status.Companion.I_M_A_TEAPOT


data class TicketDTO(
    val id: String,
    val heureEntree : String,
    val dureeDeLocation : String,
    val sommePayee: String
)



fun httpServer(port: Int, useCaseReadBalance: AcheterUnTicketDeLocation): Http4kServer =
    locationHttpHandler(useCaseReadBalance).asServer(Jetty(port))

fun locationHttpHandler(useCase: AcheterUnTicketDeLocation): HttpHandler = CatchLensFailure.then(
    routes(
        "/location/ticket/{sommePayee}" bind Method.PUT to { request: Request ->
            //   val accountIdRequest = Query.string().required(name = "sommePayee")
            val sommePayeeString = request.path("sommePayee")!!

            //verifier que c'est un nombre positif (validation)
            when (  val parsedAmount = sommePayeeString.toIntOrNull()) {
                null -> Response(I_M_A_TEAPOT)
                else -> {
                    val demande = DemandeDuTicket(
                        immatriculationVehicule = "",
                        montantEuro = parsedAmount
                    )

                    var reponse: Result<Ticket>
                    runBlocking {
                        reponse = useCase.handle(demande)
                    }

                    when
                    {
                        reponse.isSuccess -> {
                            val ticket = reponse.getOrNull()!!
                            val ticketDTO = TicketDTO(ticket.Id, "", ticket.dureeDeLocation.toString(), sommePayeeString)
                            val bodyJson = Body.auto<TicketDTO>().toLens()
                            Response(OK).with(bodyJson of ticketDTO)
                        }
                        else -> {
                            Response(I_M_A_TEAPOT)
                        }
                    }
                }
            }
        }
    )
)