package interface_adapter.update;

import java.util.ArrayList;

public class UpdateState {
    private String username = "";


    public UpdateState(UpdateState copy) {
        username = copy.username;
    }

    public UpdateState(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
