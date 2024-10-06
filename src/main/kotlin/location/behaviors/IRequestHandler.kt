package location.behaviors

interface IRequestHandler<Tin, Tout> {

   suspend fun handle(demande: Tin) : Tout

}
