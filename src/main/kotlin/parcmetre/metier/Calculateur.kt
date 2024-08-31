package parcmetre.metier

import parcmetre.metier.objetValeurs.Devises
import parcmetre.metier.objetValeurs.Monnaie

private const val TAUX_HORAIRE = 0.1

class Calculateur {
    companion object {

        fun calculerPrix(duree: Float): Monnaie {
            return Monnaie( (duree * TAUX_HORAIRE).toInt() , Devises.EUROS)
        }
    }
}
