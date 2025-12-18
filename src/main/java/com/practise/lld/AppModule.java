package com.practise.lld;

import com.google.inject.AbstractModule;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import jakarta.inject.Singleton;
import java.lang.reflect.Modifier;
import java.util.Set;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        Reflections reflections = new Reflections("com.practise.lld", Scanners.SubTypes);
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);
        
        for (Class<?> clazz : allClasses) {
            if (!Modifier.isAbstract(clazz.getModifiers()) && 
                !clazz.isInterface() &&
                !clazz.isAnnotation() &&
                !clazz.isEnum()) {
                
                if (clazz.isAnnotationPresent(Singleton.class)) {
                    bind(clazz).asEagerSingleton();
                }
            }
        }
    }
}
