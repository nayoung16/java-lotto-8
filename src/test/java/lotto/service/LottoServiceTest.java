package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    void 생성된_로또_개수_확인() {
        int count = 4;
        List<Lotto> lottoList = lottoService.generate(count);
        assertEquals(count, lottoList.size());
    }

    @Test
    void 로또_당첨_확인() {
        List<Integer> ticketNum = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNum = Arrays.asList(3,4,5,6,7,8);
        Lotto ticket = new Lotto(ticketNum);
        Lotto winning = new Lotto(winningNum);
        assertEquals(4,lottoService.matchCount(ticket, winning));
    }

    @Test
    void 보너스_확인() {
        List<Integer> ticketNum = Arrays.asList(1,2,3,4,5,6);
        Lotto ticket = new Lotto(ticketNum);
        assertTrue(lottoService.containsBonus(ticket, 5));
    }
}