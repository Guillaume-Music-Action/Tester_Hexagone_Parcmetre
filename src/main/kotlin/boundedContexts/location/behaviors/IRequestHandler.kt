package boundedContexts.location.behaviors

interface IRequestHandler<Tin, Tout> {

    fun handle(demande: Tin): Tout

}
