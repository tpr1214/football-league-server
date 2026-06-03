package model;

public class Bet {
    private Long id;
    private User user;
    private Match match;
    private BetOutcome predictedOutcome;
    private Double amount;
    private Double odds;
    private BetStatus status = BetStatus.PENDING;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public BetOutcome getPredictedOutcome() {
        return predictedOutcome;
    }

    public void setPredictedOutcome(BetOutcome predictedOutcome) {
        this.predictedOutcome = predictedOutcome;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public BetStatus getStatus() {
        return status;
    }

    public void setStatus(BetStatus status) {
        this.status = status;
    }
}
