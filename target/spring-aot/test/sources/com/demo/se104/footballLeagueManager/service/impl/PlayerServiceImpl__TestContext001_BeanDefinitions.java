package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.PlayerRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PlayerServiceImpl}.
 */
@Generated
public class PlayerServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'playerServiceImpl'.
   */
  private static BeanInstanceSupplier<PlayerServiceImpl> getPlayerServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<PlayerServiceImpl>forConstructor(PlayerRepository.class)
            .withGenerator((registeredBean, args) -> new PlayerServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'playerServiceImpl'.
   */
  public static BeanDefinition getPlayerServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlayerServiceImpl.class);
    beanDefinition.setInstanceSupplier(getPlayerServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
