package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.dao.ChartRepository;
import com.demo.se104.footballLeagueManager.service.TeamService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TeamController}.
 */
@Generated
public class TeamController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'teamController'.
   */
  private static BeanInstanceSupplier<TeamController> getTeamControllerInstanceSupplier() {
    return BeanInstanceSupplier.<TeamController>forConstructor(TeamService.class, ChartRepository.class)
            .withGenerator((registeredBean, args) -> new TeamController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'teamController'.
   */
  public static BeanDefinition getTeamControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TeamController.class);
    beanDefinition.setInstanceSupplier(getTeamControllerInstanceSupplier());
    return beanDefinition;
  }
}
