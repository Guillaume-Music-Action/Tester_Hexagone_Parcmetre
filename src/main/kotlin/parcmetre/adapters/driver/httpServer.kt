package parcmetre.adapters.driver


import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.ServerFilters.CatchLensFailure
import org.http4k.format.Jackson.auto
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer
import parcmetre.useCases.AcheterUnTicketAuParcmetre


data class TicketDTO(
    val id: String,
    val heureEntree : String,
    val dureeDeStationnment : String,
    val sommePayee: String
)

fun httpServer(port: Int, useCaseReadBalance: AcheterUnTicketAuParcmetre): Http4kServer =
    parcmetreHttpHandler(useCaseReadBalance).asServer(Jetty(port))

fun parcmetreHttpHandler(useCase: AcheterUnTicketAuParcmetre): HttpHandler = CatchLensFailure.then(
    routes(
        "/parcemetre/ticket/{sommePayee}" bind Method.PUT to { request: Request ->
            //   val accountIdRequest = Query.string().required(name = "sommePayee")
            val sommePayeeString = request.path("sommePayee")!!
            //verifier que c'est un nombre positif (validation)

           // val result = useCase.handle(  )   <-- faut faire la tuyauterie

            val ticketDTO = TicketDTO("", "", "", "")
            // ^^-- à partir du result, on remplit le DTO
            // faut gérer les cas d'erreurs aussi

            val bodyJson = Body.auto<TicketDTO>().toLens()
            ticketDTO.let { Response(OK).with(bodyJson of it) }
        }
    )
)