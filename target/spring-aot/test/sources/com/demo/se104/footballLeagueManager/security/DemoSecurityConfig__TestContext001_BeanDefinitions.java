package com.demo.se104.footballLeagueManager.security;

import javax.sql.DataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * Bean definitions for {@link DemoSecurityConfig}.
 */
@Generated
public class DemoSecurityConfig__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'demoSecurityConfig'.
   */
  public static BeanDefinition getDemoSecurityConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DemoSecurityConfig.class);
    beanDefinition.setTargetType(DemoSecurityConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(DemoSecurityConfig.class);
    beanDefinition.setInstanceSupplier(DemoSecurityConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'userDetailsManager'.
   */
  private static BeanInstanceSupplier<UserDetailsManager> getUserDetailsManagerInstanceSupplier() {
    return BeanInstanceSupplier.<UserDetailsManager>forFactoryMethod(DemoSecurityConfig.class, "userDetailsManager", DataSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DemoSecurityConfig.class).userDetailsManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'userDetailsManager'.
   */
  public static BeanDefinition getUserDetailsManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserDetailsManager.class);
    beanDefinition.setInstanceSupplier(getUserDetailsManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'filterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getFilterChainInstanceSupplier() {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(DemoSecurityConfig.class, "filterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DemoSecurityConfig.class).filterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'filterChain'.
   */
  public static BeanDefinition getFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setInstanceSupplier(getFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'httpSessionEventPublisher'.
   */
  private static BeanInstanceSupplier<HttpSessionEventPublisher> getHttpSessionEventPublisherInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HttpSessionEventPublisher>forFactoryMethod(DemoSecurityConfig.class, "httpSessionEventPublisher")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DemoSecurityConfig.class).httpSessionEventPublisher());
  }

  /**
   * Get the bean definition for 'httpSessionEventPublisher'.
   */
  public static BeanDefinition getHttpSessionEventPublisherBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HttpSessionEventPublisher.class);
    beanDefinition.setInstanceSupplier(getHttpSessionEventPublisherInstanceSupplier());
    return beanDefinition;
  }
}
