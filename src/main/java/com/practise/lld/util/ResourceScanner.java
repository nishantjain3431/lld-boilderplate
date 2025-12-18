package com.practise.lld.util;

import com.google.inject.Injector;
import jakarta.ws.rs.Path;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.util.Set;

public class ResourceScanner {

    public static Set<Object> scanResources(String packageName, Injector injector) {
        Reflections reflections = new Reflections(packageName, Scanners.TypesAnnotated);
        Set<Class<?>> resourceClasses = reflections.getTypesAnnotatedWith(Path.class);
        
        return resourceClasses.stream()
                .map(injector::getInstance)
                .collect(java.util.stream.Collectors.toSet());
    }
}
