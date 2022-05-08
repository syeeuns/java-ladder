package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;

public class LadderApplication {

  public static void main(String[] args) {
    Players players = Players.of(InputView.getNames());
    int height = InputView.getHeight();

    Ladder ladder = Ladder.of(players.size(), height);
  }
}
