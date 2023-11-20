package use_case.ApplyStats;

import use_case.ApplyStats.ApplyStatsDataAccessInterface;
import entity.PlayerStats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplyStatsInteractor implements ApplyStatsInputBoundary {
    private final ApplyStatsDataAccessInterface dataAccess;
    private final ApplyStatsOutputBoundary outputBoundary;

    public ApplyStatsInteractor(ApplyStatsDataAccessInterface dataAccess, ApplyStatsOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    public void applyStats(List<String> selectedStats) {
        try {
            // Need to create a class that gets all the selected stats
//            List<Statistic> statistics = dataAccess.getStatistics();

            // Process the statistics and prepare the data for the graph
//            Map<String, Double> graphData = processStatistics(statistics);
//            ApplyStatsOutputData outputData = new ApplyStatsOutputData(graphData);
//
//            // Send the processed data to the presenter
//            outputBoundary.updateGraph(outputData);
//        } catch (Exception e) {
//            outputBoundary.handleFailure(e.getMessage());
        } finally {

        }
    }

        private Map<String, Double> processStatistics (List <PlayerStats> statistics) {
            Map<String, Double> graphData = new HashMap<>();
            // Logic to process statistics and prepare graph data
            // This could involve aggregating, averaging, or any other form of data processing
            return graphData;
        }

    @Override
    public void execute(List<String> selectedStats) {

    }
}
