package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.MatchRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MatchServiceImpl}.
 */
@Generated
public class MatchServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'matchServiceImpl'.
   */
  private static BeanInstanceSupplier<MatchServiceImpl> getMatchServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<MatchServiceImpl>forConstructor(MatchRepository.class)
            .withGenerator((registeredBean, args) -> new MatchServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'matchServiceImpl'.
   */
  public static BeanDefinition getMatchServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MatchServiceImpl.class);
    beanDefinition.setInstanceSupplier(getMatchServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
