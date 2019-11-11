package ch.bbcag.ae.ersteschritte;

import java.util.Arrays;

public class DatentypenUndVariableninitialisierungArray {

    public static void main(String[] args) {
        // a
        int[] foo = {
                11,
                30,
                54,
                21,
                39
        };
        System.out.println(Arrays.toString(foo));

        // b
        int[] bar = new int[100];
        for(int i = 0; i < bar.length; ++i){
            bar[i] = i;
        }
        System.out.println(Arrays.toString(bar));
    }
}
