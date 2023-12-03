package use_case;

import app.Main;
import data_access.MatchDataAccessObject;
import entity.NormalMatchFactory;
import entity.NormalMatchesFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import use_case.CheckMatch.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotNull;

public class CheckMatchTest {

    public void writeCSV() {
        BufferedWriter writer1;
        BufferedWriter writer2;
        try {
            writer1 = new BufferedWriter(new FileWriter("player.csv"));
            writer1.write("kgciw");
            writer1.write('\n');
            writer1.write("wYgo1MfobO6nCnBNflcAbvwrY99y9HFClBrb_I4zeqN9CJx2dyPFCIHDaD87hPpucc2b8rCCLEXRqA");
            writer1.close();

            writer2 = new BufferedWriter(new FileWriter("matchdata.csv"));
            writer2.write("");
            writer2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void successTest() throws IOException {
        writeCSV();

        CheckMatchInputData checkMatchInputData = new CheckMatchInputData("NA1_4847072926");
        CheckMatchDataAccessInterface checkMatchDataAccessObject = new MatchDataAccessObject("matchdata.csv", new NormalMatchFactory(), new NormalMatchesFactory());

        CheckMatchOutputBoundary successPresenter = new CheckMatchOutputBoundary() {
            @Override
            public void prepareSuccessView(CheckMatchOutputdata checkMatchOutputdata) {
                assertNotNull(checkMatchOutputdata.getMatch());
            }
        };

        CheckMatchInputBoundary interactor = new CheckMatchInteractor(successPresenter, checkMatchDataAccessObject, new NormalMatchFactory());
        interactor.execute(checkMatchInputData);

    }
}

