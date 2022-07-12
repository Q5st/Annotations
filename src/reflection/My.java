package reflection;

import java.lang.annotation.*;

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)

public @interface My {
    int param1();
    int param2();
}