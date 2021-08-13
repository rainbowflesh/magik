package is.nijikawa.fozubaoyo.security.config;

import is.nijikawa.fozubaoyo.security.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 拦截器配置
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {// 添加拦截器和放行路径
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login");
    }
}
