package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.PlayerSearchService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PlayerSearchController}.
 */
@Generated
public class PlayerSearchController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'playerSearchController'.
   */
  private static BeanInstanceSupplier<PlayerSearchController> getPlayerSearchControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PlayerSearchController>forConstructor(PlayerSearchService.class)
            .withGenerator((registeredBean, args) -> new PlayerSearchController(args.get(0)));
  }

  /**
   * Get the bean definition for 'playerSearchController'.
   */
  public static BeanDefinition getPlayerSearchControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlayerSearchController.class);
    beanDefinition.setInstanceSupplier(getPlayerSearchControllerInstanceSupplier());
    return beanDefinition;
  }
}
