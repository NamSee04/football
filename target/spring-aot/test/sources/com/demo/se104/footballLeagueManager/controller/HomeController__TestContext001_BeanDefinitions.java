package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.TeamService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HomeController}.
 */
@Generated
public class HomeController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'homeController'.
   */
  private static BeanInstanceSupplier<HomeController> getHomeControllerInstanceSupplier() {
    return BeanInstanceSupplier.<HomeController>forConstructor(TeamService.class, MatchService.class)
            .withGenerator((registeredBean, args) -> new HomeController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'homeController'.
   */
  public static BeanDefinition getHomeControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HomeController.class);
    beanDefinition.setInstanceSupplier(getHomeControllerInstanceSupplier());
    return beanDefinition;
  }
}
