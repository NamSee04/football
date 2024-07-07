package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.TeamRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TeamServiceImpl}.
 */
@Generated
public class TeamServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'teamServiceImpl'.
   */
  private static BeanInstanceSupplier<TeamServiceImpl> getTeamServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<TeamServiceImpl>forConstructor(TeamRepository.class)
            .withGenerator((registeredBean, args) -> new TeamServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'teamServiceImpl'.
   */
  public static BeanDefinition getTeamServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TeamServiceImpl.class);
    beanDefinition.setInstanceSupplier(getTeamServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
