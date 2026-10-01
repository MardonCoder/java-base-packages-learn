import java.util.regex.*;
import java.lang.reflect.*;

public class JavaRegexLearn {
    public static void main(String[] args) {
        String text = "";
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(text);

        while (m.find()){
            System.out.println(m.group());
        }

        boolean isMatch = Pattern.matches("", "");
        System.out.println(isMatch);

        String replaced = text.replaceAll("", "");
        System.out.println(replaced);

        // Рефлексия
        try {
            Class<?> c = Class.forName("java.awt.Dimension");
            Constructor<?>[] constructors = c.getConstructors();
            for (Constructor<?> myConstructor: constructors)
                System.out.println(myConstructor);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //RMI
        
    }
}
