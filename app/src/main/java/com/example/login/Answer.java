package com.example.login;
import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("authorization")
    boolean authorization

            ;

    public Answer(boolean authorization) {
        this.authorization = authorization;
    }

    public boolean isAuthorization() {
        return authorization;
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }
}
