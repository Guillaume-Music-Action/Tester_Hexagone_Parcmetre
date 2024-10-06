package location.utilities

import location.behaviors.IJeDonneDesIdentifiants

class LinearIdGenerator : IJeDonneDesIdentifiants {
    var compteur : Int = 0
    override fun idSuivant(): String {
        compteur += 1
        return "FAUX-ID-$compteur"
    }
}