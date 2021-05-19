package common;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.util.ReflectionUtils;

public class TestTestExecutionListener extends AbstractTestExecutionListener {

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {

        ApplicationContext applicationContext = testContext.getApplicationContext();


        MockitoPostProcessor postProcessor = applicationContext.getBean(MockitoPostProcessor.class);


        DefaultListableBeanFactory configurableListableBeanFactory = new DefaultListableBeanFactory();
        boolean configurationFrozen = configurableListableBeanFactory.isConfigurationFrozen();
        postProcessor.postProcessBeanFactory(configurableListableBeanFactory);


        System.out.println(postProcessor);

    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        MockitoPostProcessor postProcessor = applicationContext.getBean(MockitoPostProcessor.class);
        System.out.println(postProcessor);
    }

}


        /*if (hasMockitoAnnotations(testContext)) {
            MockitoAnnotations.initMocks(testContext.getTestInstance());
        }
        injectFields(testContext);*/


/*


    private boolean hasMockitoAnnotations(TestContext testContext) {
        //MockitoAnnotationCollection collector = new MockitoAnnotationCollection();
        //ReflectionUtils.doWithFields(testContext.getTestClass(), collector);
        return false;//collector.hasAnnotations();
    }

    private void injectFields(TestContext testContext) {
        /*DefinitionsParser parser = new DefinitionsParser();
        parser.parse(testContext.getTestClass());
        if (!parser.getDefinitions().isEmpty()) {
            injectFields(testContext, parser);
        }
}

    private void injectFields(TestContext testContext, DefinitionsParser parser) {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        MockitoPostProcessor postProcessor = applicationContext
                .getBean(MockitoPostProcessor.class);
        for (Definition definition : parser.getDefinitions()) {
            Field field = parser.getField(definition);
            if (field != null) {
                postProcessor.inject(field, testContext.getTestInstance(), definition);
            }
        }
    }

    /**
     * {@link FieldCallback} to collect Mockito annotations.
     */
/*    private static class MockitoAnnotationCollection implements FieldCallback {

        private final Set<Annotation> annotations = new LinkedHashSet<>();

        @Override
        public void doWith(Field field)
                throws IllegalArgumentException, IllegalAccessException {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().getName().startsWith("org.mockito")) {
                    this.annotations.add(annotation);
                }
            }
        }

        public boolean hasAnnotations() {
            return !this.annotations.isEmpty();
        }

    }
*/
