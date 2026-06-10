package org.example.footballleague.init;

import jakarta.annotation.PostConstruct;
import org.example.footballleague.model.Team;
import org.example.footballleague.model.Match;
import org.example.footballleague.model.MatchStatus;
import org.example.footballleague.repositories.MatchRepository;
import org.example.footballleague.repositories.TeamRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public DataInitializer(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @PostConstruct
    @Transactional
    public void initData() {
        // אם כבר יש קבוצות ב-DB — לא ניצור שוב
        if (teamRepository.count() > 0) {
            return;
        }

        // 1. יצירת קבוצות
        List<Team> teams = createTeams();
        teamRepository.saveAll(teams);

        // 2. יצירת משחקים למחזור ראשון
        createFirstRoundMatches(teams);
    }

    private List<Team> createTeams() {
        return Arrays.asList(
                createTeam("מכבי חיפה", 85),
                createTeam("הפועל באר שבע", 82),
                createTeam("מכבי תל אביב", 88),
                createTeam("ריאל מדריד", 92),
                createTeam("ברצלונה", 90),
                createTeam("מנצ'סטר סיטי", 89),
                createTeam("באיירן מינכן", 91),
                createTeam("פ.ס.ז'", 87)
        );
    }

    private Team createTeam(String name, int skillLevel) {
        Team team = new Team();
        team.setName(name);
        team.setSkillLevel(skillLevel);
        team.setPoints(0);
        team.setGoalsFor(0);
        team.setGoalsAgainst(0);
        return team;
    }

    private void createFirstRoundMatches(List<Team> teams) {
        // דוגמה למחזור 1 - 4 משחקים
        List<Match> matches = Arrays.asList(
                createMatch(teams.get(0), teams.get(1), 1),  // מכבי חיפה - הפועל ב"ש
                createMatch(teams.get(2), teams.get(3), 1),  // מכבי ת"א - ריאל
                createMatch(teams.get(4), teams.get(5), 1),  // ברצלונה - מנצ'סטר סיטי
                createMatch(teams.get(6), teams.get(7), 1)   // באיירן - פ.ס.ז
        );

        matchRepository.saveAll(matches);
    }

    private Match createMatch(Team home, Team away, int round) {
        Match match = new Match();
        match.setHomeTeam(home);
        match.setAwayTeam(away);
        match.setRoundNumber(round);
        match.setStatus(MatchStatus.PENDING);
        match.setHomeScore(0);
        match.setAwayScore(0);
        return match;
    }
}