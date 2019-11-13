package arrays.praesi;

import arraylist.IntArrayList;
import arraylist.interfaces.IIntList;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoGenerator {
    private static Random random = new Random();
    private static final int AMOUNT_OF_LOTTO_NUMBERS = 6;
    private static final int MAX_LOTTO_NUMBER_VALUE = 42;

    public static Set<Integer> generateLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < AMOUNT_OF_LOTTO_NUMBERS) {
            int lottoNumber = random.nextInt(MAX_LOTTO_NUMBER_VALUE ) + 1;
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }
}
