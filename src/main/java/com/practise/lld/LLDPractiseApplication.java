package com.practise.lld;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.practise.lld.util.ResourceScanner;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.util.Set;

public class LLDPractiseApplication extends Application<LLDPractiseConfiguration> {

    private Injector injector;

    public static void main(final String[] args) throws Exception {
        new LLDPractiseApplication().run(args);
    }

    @Override
    public String getName() {
        return "LLDPractise";
    }

    @Override
    public void initialize(final Bootstrap<LLDPractiseConfiguration> bootstrap) {
        injector = Guice.createInjector(new AppModule());
    }

    @Override
    public void run(final LLDPractiseConfiguration configuration,
                    final Environment environment) {
        Set<Object> resources = ResourceScanner.scanResources("com.practise.lld", injector);
        resources.forEach(resource -> environment.jersey().register(resource));
    }

}
