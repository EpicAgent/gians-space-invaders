package common;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.DefaultTestExecutionListenersPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.test.context.*;

import java.util.List;
import java.util.Set;

public class SpringBootTestContextBootstrapperExtended extends SpringBootTestContextBootstrapper {

    @Override
    protected Set<Class<? extends TestExecutionListener>> getDefaultTestExecutionListenerClasses() {
        Set<Class<? extends TestExecutionListener>> listeners = super.getDefaultTestExecutionListenerClasses();

        BootstrapContext bootstrapContext = super.getBootstrapContext();
        Class<?> testClass = bootstrapContext.getTestClass();

        CacheAwareContextLoaderDelegate cacheAwareContextLoaderDelegate = bootstrapContext.getCacheAwareContextLoaderDelegate();
        //MergedContextConfiguration mergedContextConfiguration = new MergedContextConfiguration();
        //mergedContextConfiguration.
        //cacheAwareContextLoaderDelegate.loadContext(mergedContextConfiguration);

        //MockitoPostProcessor postProcessor = bootstrapContext.getBean(MockitoPostProcessor.class);

        //MockitoTestExecutionListener mockitoTestExecutionListener = new MockitoTestExecutionListener();
        listeners.add(TestTestExecutionListener.class);

        return listeners;
    }

}
