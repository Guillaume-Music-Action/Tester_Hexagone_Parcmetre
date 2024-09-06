package exercice_6_monetique.draft;

import draft.AutreExemple;
import draft.Exemple;
import draft.IExemple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExempleTest {
    @Test
    public void Test1(){
        //arrange
        Exemple sut = new Exemple();
        sut.setPrice(2);
        var sut1 = new Exemple();
        sut1.setPrice(2);

        assertNotEquals(sut1, sut);
        assertEquals( sut1.getClass(), sut.getClass()  );
        assertSame(sut1, sut);

        var sut2  = new AutreExemple();
        IExemple monExemple = sut2;

        assertEquals(sut, monExemple);

        monExemple = sut;
        //Object a = null;

        assertEquals(sut, monExemple);

        sut.setPrice(4);

        //act
        sut.augmenter(2);

        //assert
        assertEquals(6, sut.getPrice());
    }

}