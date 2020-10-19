package be.multimedi.jammik.tools;

import java.util.regex.Pattern;

public class StringTool {
    public static boolean validEmail(String email) {
        return Pattern.compile("^([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?$").matcher(email).find();
    }
}
