package zdraft.parcmetre

import draft.IHorloge
import java.time.LocalDateTime

class FausseHorloge(val dateMaintenant: LocalDateTime) : IHorloge {

    override fun Maintenant(): LocalDateTime {
      // return LocalDateTime.now()
        return dateMaintenant
    }
}
