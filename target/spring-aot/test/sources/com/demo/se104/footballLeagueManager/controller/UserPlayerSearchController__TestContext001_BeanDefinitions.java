package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.PlayerSearchService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserPlayerSearchController}.
 */
@Generated
public class UserPlayerSearchController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userPlayerSearchController'.
   */
  private static BeanInstanceSupplier<UserPlayerSearchController> getUserPlayerSearchControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<UserPlayerSearchController>forConstructor(PlayerSearchService.class)
            .withGenerator((registeredBean, args) -> new UserPlayerSearchController(args.get(0)));
  }

  /**
   * Get the bean definition for 'userPlayerSearchController'.
   */
  public static BeanDefinition getUserPlayerSearchControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserPlayerSearchController.class);
    beanDefinition.setInstanceSupplier(getUserPlayerSearchControllerInstanceSupplier());
    return beanDefinition;
  }
}
