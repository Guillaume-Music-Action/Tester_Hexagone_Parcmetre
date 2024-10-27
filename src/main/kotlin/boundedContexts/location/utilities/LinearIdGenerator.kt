package boundedContexts.location.utilities

import boundedContexts.location.ports.IJeDonneDesIdentifiants

class LinearIdGenerator : IJeDonneDesIdentifiants {
    var compteur: Int = 0
    override fun idSuivant(): String {
        compteur += 1
        return "FAUX-ID-$compteur"
    }
}