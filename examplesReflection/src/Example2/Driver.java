package Example2;

import java.lang.annotation.Annotation;

public class Driver {

    public static void main(String[] args) {
        Class<TestAlpha> obj = TestAlpha.class;
        if (obj.isAnnotationPresent(IssueInfo.class)) {

            Annotation annotation = obj.getAnnotation(IssueInfo.class);
            IssueInfo testerInfo = (IssueInfo) annotation;

            System.out.printf("%nType: %s", testerInfo.type());
            System.out.printf("%nReporter: %s", testerInfo.reporter());
            System.out.printf("%nCreated On: %s%n%n",
                    testerInfo.created());
        }
    }
}