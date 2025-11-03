package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printGeneratedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String lottoToString = lottoToString(lotto);
            System.out.println(lottoToString);
        }
    }

    public static String lottoToString(Lotto lotto) {
        StringBuilder lottoString = new StringBuilder();
        lottoString.append("[");
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(lottoNumbers);
        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottoString.append(lottoNumbers.get(i));
            if (i != lottoNumbers.size() - 1) lottoString.append(", ");
        }
        lottoString.append("]");
        return lottoString.toString();
    }
}
