package cz.spsmb;

import cz.spsmb.source.LicenceServer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Applicatin {

    public static void main(String[] args) throws IllegalAccessException {
        Boolean bool = true;
        Field[] fields = LicenceServer.class.getFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.get(bool);
        }
        LicenceServer.startGame();
    }
}
