package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LottoResultTest {

    @Test
    void addRank_등수_1회_집계() {
        LottoResult r = new LottoResult();
        r.addRank(Rank.FIRST);
        assertEquals(1, r.getCount(Rank.FIRST));
    }

    @Test
    void addRank_MISS_RANK_집계_확인() {
        LottoResult r = new LottoResult();
        r.addRank(Rank.MISS);
        assertEquals(0, r.getCount(Rank.MISS));
    }
}