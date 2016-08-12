package format;

import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.springframework.core.convert.TypeDescriptor;

import play.data.format.Formatters;
import play.i18n.MessagesApi;

@Singleton
public class FormattersFixed extends Formatters {
    @Inject
    public FormattersFixed(MessagesApi messagesApi) {
        super(messagesApi);
    }

    @SuppressWarnings("unchecked")
    public <T> T parse(Field field, String text, Class<T> clazz) {
        return (T) conversion.convert(text, TypeDescriptor.valueOf(String.class), new TypeDescriptor(field));
    }
}
