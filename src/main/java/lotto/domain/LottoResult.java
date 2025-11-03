package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
    private long totalPrize = 0L;

    public void addRank(Rank rank) {
        if (rank == Rank.MISS) return;
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        totalPrize += rank.getPrize();
    }

    public int getCount(Rank rank) {
        if (rank == null) return 0;
        return rankCount.getOrDefault(rank, 0);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}
