import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.security.config.HibernateConfig;
import com.spring.security.config.SecurityWebApplicationInitializer;
import com.spring.security.config.WebConfig;
import com.spring.security.config.WebSecurityConfig;
//import com.spring.security.config.WebSecurityConfig;

public class AppInitializer 
  extends AbstractAnnotationConfigDispatcherServletInitializer {
   
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {HibernateConfig.class, WebSecurityConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		  return new String[] { "/" };
	}
}
