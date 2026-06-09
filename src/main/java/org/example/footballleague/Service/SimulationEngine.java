package org.example.footballleague.Service;

import org.example.footballleague.model.Match;
import org.springframework.stereotype.Service;

@Service
public class SimulationEngine {
    public void runNextRound() {
        // מעביר סטטוס ל-LIVE, נועל הימורים ומריץ טיימר של 30 שניות
    }

    public void calculateMatchOutcome(Match match) {
        // נוסחה המשקללת את ה-Skill Level + גורמים אקראיים (מזג אוויר, פציעות)
        // קביעת התוצאה הסופית מראש ויצירת לוח הזמנים (Timeline) ל-30 שניות
    }

    public void updateTeamSkills(Match match) {
        // עדכון דינמי של רמת המיומנות של הקבוצות בהתאם לתוצאה בסיום המשחק
    }
}
