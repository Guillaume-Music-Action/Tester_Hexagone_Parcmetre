package parcmetre.domain.valueObjects

data class Monnaie(val valeur: Int, val devise: Devises) {

    companion object {
        const val DOLLAR_VERS_EUROS = 2
        fun Euros(value: Int): Monnaie = Monnaie(value, Devises.EUROS)
        fun Dollars(value: Int): Monnaie = Monnaie(value, Devises.DOLLARS)
    }


    override fun equals(other: Any?): Boolean {
        if (other !is Monnaie)
            return false
        if (this.devise == other.devise)
            return (this.valeur == other.valeur)
        if (this.devise == Devises.DOLLARS && other.devise == Devises.EUROS)
            return (this.valeur * DOLLAR_VERS_EUROS == other.valeur)
        return false
    }

    override fun hashCode(): Int {
        var result = valeur
        result = 31 * result + devise.hashCode()
        return result
    }
}

enum class Devises {
    DOLLARS,
    EUROS

}
