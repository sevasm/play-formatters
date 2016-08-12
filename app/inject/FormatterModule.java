package inject;

import play.data.format.Formatters;

import com.google.inject.AbstractModule;

import format.FormatterProvider;

public class FormatterModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Formatters.class).toProvider(FormatterProvider.class);
    }
}
