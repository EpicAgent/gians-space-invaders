package arraylist;

import arraylist.interfaces.IIntList;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LottoGeneratorTest {

    @Test
    void generateLottoNumbers_has_size_of_6() {
        IIntList lottoNumbers = LottoGenerator.generateLottoNumbers();
        assertEquals(6, lottoNumbers.size());
    }

    @Test
    void generateLottoNumbers_all_numbers_are_between_1_and_42() {
        IIntList lottoNumbers = LottoGenerator.generateLottoNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            assertTrue(lottoNumbers.get(i) > 0);
            assertTrue(lottoNumbers.get(i) <= 42);
        }
    }

    @Test
    void sameNumbers_when_generating_then_no_duplicates() {
        IIntList lottoNumbers;
        Set<Integer> uniqueNumbers;
        for (int i = 0; i < 10000000; i++) {
            lottoNumbers = LottoGenerator.generateLottoNumbers();
            uniqueNumbers = new HashSet<>();
            for (int j = 0; j < lottoNumbers.size(); j++) {
                assertTrue(!uniqueNumbers.contains(lottoNumbers.get(j)));
                uniqueNumbers.add(lottoNumbers.get(j));
            }
        }
    }


}