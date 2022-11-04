package cz.spsmb;

import cz.spsmb.source.DeclaredMethodList;
import cz.spsmb.source.PrivateField;
import cz.spsmb.source.Singleton;

import java.lang.reflect.*;
import java.util.Arrays;

public class ProgramScanner {

   public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        PrivateField privateField = new PrivateField();
        Field[] fields = PrivateField.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(privateField));
        }

        Method[] methods = DeclaredMethodList.class.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getModifiers() == (Modifier.PUBLIC | Modifier.STATIC)) System.out.print("public - ");
            else if (method.getModifiers() == (Modifier.PRIVATE | Modifier.STATIC)) System.out.print("private - ");
            System.out.println(method.getName());
        }

        Constructor[] constructors = Singleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            constructor.newInstance();
        }

        System.out.println(Singleton.getInstanceCount());
    }

}
