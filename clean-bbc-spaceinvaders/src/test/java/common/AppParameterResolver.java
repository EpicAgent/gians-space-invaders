package common;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static org.springframework.test.context.junit.jupiter.SpringExtension.getApplicationContext;

public class AppParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return Util.hasMockAnnotationOnParameter(parameterContext) || Util.hasSpyAnnotationOnParameter(parameterContext);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> componentType = parameterContext.getParameter().getType();
        ApplicationContext applicationContext = getApplicationContext(extensionContext);
        Object o = applicationContext.getBean(componentType);
        return o;
    }


}


/*
*
*     private void registerFakes(ParameterContext parameterContext, Class<?> componentType , ApplicationContext applicationContext) {
        Hacker hacker = applicationContext.getBean(Hacker.class);
        if (Util.hasSpyAnnotationOnParameter(parameterContext)) {
            hacker.spyFor(componentType);
        } else if (Util.hasMockAnnotationOnParameter(parameterContext)) {
            hacker.mockFor(componentType);
        }
    }
*
* */
