package inject;

import play.data.format.Formatters;

import com.google.inject.AbstractModule;

import format.FormatterProviderFixed;

public class FormatterModuleFixed extends AbstractModule {
    @Override
    protected void configure() {
        bind(Formatters.class).toProvider(FormatterProviderFixed.class);
    }
}
