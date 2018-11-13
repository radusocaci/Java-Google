package Example2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IssueInfo {

    public enum Type {
        BUG, IMPROVEMENT, FEATURE
    }

    Type type() default Type.BUG;

    String reporter() default "ReporterX";

    String created() default "10/01/2018";
}