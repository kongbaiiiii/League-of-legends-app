package use_case.update;

import entity.Matches;

public class UpdateOutputData {
    private final Matches matches;

    public UpdateOutputData(Matches matches) {
        this.matches = matches;
    }

    public Matches getMatches(){
        return this.matches;
    }
}
