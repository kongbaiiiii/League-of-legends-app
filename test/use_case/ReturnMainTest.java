package use_case;

import org.junit.Test;
import use_case.return_mainpage.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnMainTest {

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
    public void successTest() throws IOException{
        writeCSV();
        ReturnMainInputData returnMainInputData = new ReturnMainInputData();
        ReturnMainOutputBoundary successPresenter = new ReturnMainOutputBoundary() {
            @Override
            public void prepareSuccessView() {
            }
        };

        ReturnMainInputBoundary interactor = new ReturnMainInteractor(successPresenter);
        interactor.execute();
    }
}
