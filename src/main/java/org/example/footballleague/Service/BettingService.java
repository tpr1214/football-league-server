package org.example.footballleague.Service;

import org.example.footballleague.repositories.BetRepository;
import org.example.footballleague.model.Bet;
import org.example.footballleague.model.Match;
import org.springframework.stereotype.Service;

@Service
public class BettingService {
    private final BetRepository betRepository;

    public BettingService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public double calculateOdds(Match match) {
        // חישוב יחס הימור דינמי על בסיס רמות מיומנות הקבוצות
        return 1.5;
    }

    public Bet placeBet(Bet bet) {
        // מאפשר להמר רק אם המשחק בסטטוס PENDING
        return bet;
    }

    public void settleBets(Match match) {
        // נקראת בסיום המשחק, בודקת מי צדק ומעדכנת את ה-balance של המשתמשים שזכו
    }
}
