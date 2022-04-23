import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}
