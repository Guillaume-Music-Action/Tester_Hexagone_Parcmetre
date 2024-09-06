package parcmetre.utilities

import parcmetre.behaviors.IJeDonneDesIdentifiants
import ulid.ULID


class ulidGenerateur : IJeDonneDesIdentifiants   {
    override fun idSuivant(): String = ULID.randomULID()
}

// juste pour la beauté des interfaces fonctionnelles
val UlidGenerateur = IJeDonneDesIdentifiants {
    ULID.randomULID()
}
//probleme: c'est pas facile à tester

object testableIdGenerateur : IJeDonneDesIdentifiants {

    override fun idSuivant(): String {
        TODO("quelque chose de plus facile à tester")
    }

}
