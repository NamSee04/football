package com.demo.se104.footballLeagueManager;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link FootballLeagueManagerApplication}.
 */
@Generated
public class FootballLeagueManagerApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'footballLeagueManagerApplication'.
   */
  public static BeanDefinition getFootballLeagueManagerApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FootballLeagueManagerApplication.class);
    beanDefinition.setTargetType(FootballLeagueManagerApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(FootballLeagueManagerApplication.class);
    beanDefinition.setInstanceSupplier(FootballLeagueManagerApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
