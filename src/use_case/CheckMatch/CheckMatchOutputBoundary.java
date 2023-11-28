package use_case.CheckMatch;

import entity.Match;

public interface CheckMatchOutputBoundary {
    void prepareSuccessView(CheckMatchOutputdata checkMatchOutputdata);

    void prepareFailView(String error);
}
