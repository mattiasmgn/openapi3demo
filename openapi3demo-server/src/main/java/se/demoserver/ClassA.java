package se.demoserver;

import java.util.Date;

public class ClassA implements InterfaceC {
    public String currentTime=new Date().toString();

    public String getType() { return "ClassA"; }
    public String getCurrentTime() {
        return currentTime;
    }
    public String getOnlyInA() { return "Unique to A"; }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
