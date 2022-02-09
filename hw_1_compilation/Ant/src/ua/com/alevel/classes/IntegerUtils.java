package ua.com.alevel.classes;
import org.apache.commons.lang3.*;
public class IntegerUtils {
    private IntegerUtils(){

    }

    public static int addRandomNumber(MyNumber number){
        return number.getNumber() + RandomUtils.nextInt();
    }
}
