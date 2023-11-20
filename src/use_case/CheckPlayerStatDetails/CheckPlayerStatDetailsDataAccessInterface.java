package use_case.CheckPlayerStatDetails;
import entity.PlayerStats;
import java.util.List;

public interface CheckPlayerStatDetailsDataAccessInterface {
    List<PlayerStats> getPlayerMatchStats(String playerId);
}
