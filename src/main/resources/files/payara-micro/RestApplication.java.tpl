package [# th:text="${java_package}"/];

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/data")
@ApplicationScoped
public class [# th:text="${application}"/]RestApplication extends Application {
}
