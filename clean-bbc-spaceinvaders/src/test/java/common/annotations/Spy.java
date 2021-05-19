package common.annotations;

import org.junit.jupiter.api.extension.Extension;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Spy {
}

