package use_case;

import use_case.select_stat.SelectStatInputBoundary;
import use_case.select_stat.SelectStatInteractor;
import use_case.select_stat.SelectStatOutputBoundary;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SelectDataTest {
    boolean executed = false;

    @Test
    public void successTest(){
        SelectStatOutputBoundary selectStatOutputBoundary = new SelectStatOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                executed = true;
            }
        };
        SelectStatInputBoundary interactor = new SelectStatInteractor(selectStatOutputBoundary);
        interactor.execute();
        assertTrue(executed); //Assert that prepareSuccessView is called properly
    }

}
