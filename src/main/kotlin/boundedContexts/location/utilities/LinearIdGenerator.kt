package boundedContexts.location.utilities

import boundedContexts.location.behaviors.IJeDonneDesIdentifiants

class LinearIdGenerator : boundedContexts.location.behaviors.IJeDonneDesIdentifiants {
    var compteur: Int = 0
    override fun idSuivant(): String {
        compteur += 1
        return "FAUX-ID-$compteur"
    }
}