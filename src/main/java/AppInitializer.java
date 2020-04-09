import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.security.config.SecSecurityConfig;

public abstract class AppInitializer 
  extends AbstractAnnotationConfigDispatcherServletInitializer {
   
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SecSecurityConfig.class};
    }
}
