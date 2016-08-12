package format;

import java.text.ParseException;
import java.util.Locale;

import play.data.format.Formatters.SimpleFormatter;

public class IntegerFormatter extends SimpleFormatter<Integer> {
    @Override
    public Integer parse(String text, Locale locale) throws ParseException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid integer (" + text + ")", 0);
        }
    }

    @Override
    public String print(Integer t, Locale locale) {
        return t == null ? null : t.toString();
    }
}
