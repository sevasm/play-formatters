package format;

import javax.inject.Inject;
import javax.inject.Provider;

import play.data.format.Formatters;
import play.i18n.MessagesApi;

public class FormatterProvider implements Provider<Formatters> {
    private final MessagesApi messagesApi;

    @Inject
    public FormatterProvider(MessagesApi messagesApi) {
        this.messagesApi = messagesApi;
    }

    @Override
    public Formatters get() {
        Formatters formatters = new Formatters(messagesApi);
        formatters.register(Integer.class, new IntegerFormatter());
        return formatters;
    }
}
