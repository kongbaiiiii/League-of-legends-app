package interface_adapter.check_match;


import entity.Match;

public class CheckMatchState {
    private Match match = null;

    public CheckMatchState(CheckMatchState copy){
        match = copy.match;
    }

    public CheckMatchState(){}

    public Match getMatch(){return  this.match;}
}
