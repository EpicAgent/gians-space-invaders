package arraylist;

import arraylist.interfaces.IIntList;

import java.util.Random;

public class LottoGenerator {
    private static Random random = new Random();
    private static final int AMOUNT_OF_LOTTO_NUMBERS = 6;
    private static final int MAX_LOTTO_NUMBER_VALUE = 42;

    public static IIntList generateLottoNumbers() {
        IIntList lottoNumbers = new IntArrayList();
        while (lottoNumbers.size() < AMOUNT_OF_LOTTO_NUMBERS) {
            int lottoNumber = random.nextInt(MAX_LOTTO_NUMBER_VALUE ) + 1; // +1 because we want an interval from 1-42 instead of 0-41
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
            }
        }
        return lottoNumbers;
    }
}
