package weddingPlanner.plansDeTables

import io.kotest.core.spec.style.BehaviorSpec



data class Table(val number: Number, val capacite : Int )

class MyTests : BehaviorSpec({
    context("je veux des tables equilibrées HF avec alternance au mieux") {

        given("1 table pour 12") {
           val table = Table(1, 12)

            `when`("j'ai 6 hommes et 6 femmes") {
               // val table = Table()
                then("H et F sont en sequence alterné") {
                    // test code

                }
            }
            `when`("j'ai 6 hommes et 3 femmes") {
                then("2h - 1f - 2h - 1f - 2h - 1f ") {
                    // test code
                }
            }
        }

        given("1 table pour 13") {
            `when`("j'ai 6 hommes et 5 femmes") {
                then("H et F sont en sequence alterné") {
                    // test code
                }
            }
        }

    }
})