import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null || color.isBlank()) return false;

        Pattern pattern = Pattern.compile("^#([a-fA-F\\d]{6}|[a-fA-F\\d]{3})$");
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }
}





