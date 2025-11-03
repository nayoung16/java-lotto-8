package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class LottoService {
    public List<Lotto> generate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoResult checkLotto(List<Lotto> lottoList, Lotto lotto, int bonusNum) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto ticket : lottoList) {
            int match = matchCount(ticket, lotto);
            boolean bonus = containsBonus(ticket, bonusNum);
            Rank rank = Rank.of(match, bonus);
            lottoResult.addRank(rank);
        }
        return lottoResult;
    }

    public int matchCount(Lotto ticket, Lotto winning) {
        int count = 0;
        for (Integer number : ticket.getNumbers()) {
            if (winning.getNumbers().contains(number)) count++;
        }
        return count;
    }

    public boolean containsBonus(Lotto ticket, int bonus) {
        return ticket.getNumbers().contains(bonus);
    }
}
