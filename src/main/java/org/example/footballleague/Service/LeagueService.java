package org.example.footballleague.Service;

import org.example.footballleague.repositories.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class LeagueService {
    private final TeamRepository teamRepository;

    public LeagueService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
