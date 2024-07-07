package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.PlayerService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.TeamService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MatchController}.
 */
@Generated
public class MatchController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'matchController'.
   */
  private static BeanInstanceSupplier<MatchController> getMatchControllerInstanceSupplier() {
    return BeanInstanceSupplier.<MatchController>forConstructor(TeamService.class, MatchService.class, PlayerService.class, RegulationService.class)
            .withGenerator((registeredBean, args) -> new MatchController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'matchController'.
   */
  public static BeanDefinition getMatchControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MatchController.class);
    beanDefinition.setInstanceSupplier(getMatchControllerInstanceSupplier());
    return beanDefinition;
  }
}
