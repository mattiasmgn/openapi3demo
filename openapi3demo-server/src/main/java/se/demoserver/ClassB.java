package se.demoserver;

import java.util.Date;


public class ClassB implements InterfaceC {
    public String currentTime=new Date().toString();

    public String getType() { return "ClassB"; }
    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
