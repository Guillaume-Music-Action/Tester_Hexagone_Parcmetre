package parcmetre.utilities

import parcmetre.behaviors.IJeDonneDesIdentifiants

class fauxGenerateur : IJeDonneDesIdentifiants {
    var compteur : Int = 0
    override fun idSuivant(): String {
        compteur += 1
        return "FAUX-ID-$compteur"
    }
}