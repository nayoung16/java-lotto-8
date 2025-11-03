package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printGeneratedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String lottoToString = lottoToString(lotto);
            System.out.println(lottoToString);
        }
        System.out.println();
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

    public static void printLottoResult(Integer count, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getCount(lotto.domain.Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getCount(lotto.domain.Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getCount(lotto.domain.Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getCount(lotto.domain.Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getCount(lotto.domain.Rank.FIRST) + "개");
        printYieldResult(count, lottoResult.getTotalPrize());
    }

    public static double printYieldResult(Integer count, long totalPrize) {
        if (count == null || count <= 0) {
            System.out.println("총 수익률은 0.0%입니다.");
            return 0.0;
        }
        double cost = count * 1000.0;
        double yield = (totalPrize / cost) * 100.0;
        double result = Math.round(yield * 10.0) / 10.0;
        if (Double.isNaN(result) || result < 0) result = 0.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result);
        return result;
    }
}
