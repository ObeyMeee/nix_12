package ua.com.alevel.start.main;

import ua.com.alevel.config.DBConfig;
import ua.com.alevel.start.ProgramStart;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            DBConfig.getInstance().configure(args[0]);
            ProgramStart.run();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
