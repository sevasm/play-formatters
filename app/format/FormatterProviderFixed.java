package format;

import javax.inject.Inject;
import javax.inject.Provider;

import play.data.format.Formatters;
import play.i18n.MessagesApi;

public class FormatterProviderFixed implements Provider<Formatters> {
    private final MessagesApi messagesApi;

    @Inject
    public FormatterProviderFixed(MessagesApi messagesApi) {
        this.messagesApi = messagesApi;
    }

    @Override
    public Formatters get() {
        Formatters formatters = new FormattersFixed(messagesApi);
        formatters.register(Integer.class, new IntegerFormatter());
        return formatters;
    }
}
