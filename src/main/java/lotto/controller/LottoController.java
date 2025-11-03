package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void run() {
        int count = InputView.inputPriceAndCount();
        List<Lotto> lottoList = lottoService.generate(count);
        OutputView.printGeneratedLottos(lottoList);
        Lotto lotto = InputView.inputWinningNum();
        int bonusNum = InputView.inputBonusNum();
        LottoResult lottoResult = lottoService.checkLotto(lottoList, lotto, bonusNum);
        OutputView.printLottoResult(count, lottoResult);
    }
}
