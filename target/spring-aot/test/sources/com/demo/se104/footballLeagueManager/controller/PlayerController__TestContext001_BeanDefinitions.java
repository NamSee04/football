package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.PlayerService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.TeamService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PlayerController}.
 */
@Generated
public class PlayerController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'playerController'.
   */
  private static BeanInstanceSupplier<PlayerController> getPlayerControllerInstanceSupplier() {
    return BeanInstanceSupplier.<PlayerController>forConstructor(PlayerService.class, TeamService.class, RegulationService.class)
            .withGenerator((registeredBean, args) -> new PlayerController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'playerController'.
   */
  public static BeanDefinition getPlayerControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PlayerController.class);
    beanDefinition.setInstanceSupplier(getPlayerControllerInstanceSupplier());
    return beanDefinition;
  }
}
