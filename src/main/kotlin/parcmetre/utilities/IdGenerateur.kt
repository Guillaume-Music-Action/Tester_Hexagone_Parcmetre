package parcmetre.utilities

import parcmetre.behaviors.IJeDonneDesIdentifiants
import ulid.ULID


val UlidGenerateur = IJeDonneDesIdentifiants {
    ULID.randomULID()
} // juste pour la beauté des interfaces fonctionnelles


object testableIdGenerateur : IJeDonneDesIdentifiants {

    override fun idSuivant(): String {
        TODO("quelque chose de plus facile à tester")
    }

}
