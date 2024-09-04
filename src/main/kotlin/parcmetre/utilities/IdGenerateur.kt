package parcmetre.utilities

import parcmetre.behaviors.IJeDonneDesIdentifiants
import ulid.ULID


val UlidGenerator = IJeDonneDesIdentifiants {
    ULID.randomULID()
} // la beauté des interfaces fonctionnelles


object IdGenerateur : IJeDonneDesIdentifiants {

    override fun idSuivant(): String {
        TODO("quelque chose de plus facile à tester")
    }

}
