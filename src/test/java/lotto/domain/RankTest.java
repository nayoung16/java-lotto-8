package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void Rank_1() {
        assertEquals(Rank.FIRST, Rank.of(6,false));
    }

    @Test
    void Rank_2() {
        assertEquals(Rank.SECOND, Rank.of(5,true));
    }

    @Test
    void Rank_3() {
        assertEquals(Rank.THIRD, Rank.of(5,false));
    }

    @Test
    void Rank_4() {
        assertEquals(Rank.FOURTH, Rank.of(4,false));
    }

    @Test
    void Rank_5() {
        assertEquals(Rank.FIFTH, Rank.of(3,false));
    }

    @Test
    void Rank_MISS() {
        assertEquals(Rank.MISS, Rank.of(2,false));
    }

    @Test
    void 등수별_상금확인() {
        assertEquals(2000000000, Rank.FIRST.getPrize());
        assertEquals(30000000, Rank.SECOND.getPrize());
        assertEquals(1500000, Rank.THIRD.getPrize());
        assertEquals(50000, Rank.FOURTH.getPrize());
        assertEquals(5000, Rank.FIFTH.getPrize());
        assertEquals(0, Rank.MISS.getPrize());
    }

}