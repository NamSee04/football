package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.PlayerRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PlayerSearchServiceImpl}.
 */
@Generated
public class PlayerSearchServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'playerSearchServiceImpl'.
   */
  private static BeanInstanceSupplier<PlayerSearchServiceImpl> getPlayerSearchServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PlayerSearchServiceImpl>forConstructor(PlayerRepository.class)
            .withGenerator((registeredBean, args) -> new PlayerSearchServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'playerSearchServiceImpl'.
   */
  public static BeanDefinition getPlayerSearchServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlayerSearchServiceImpl.class);
    beanDefinition.setInstanceSupplier(getPlayerSearchServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
