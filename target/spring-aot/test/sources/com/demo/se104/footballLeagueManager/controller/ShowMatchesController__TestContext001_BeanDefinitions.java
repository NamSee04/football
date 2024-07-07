package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.ReportService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ShowMatchesController}.
 */
@Generated
public class ShowMatchesController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'showMatchesController'.
   */
  private static BeanInstanceSupplier<ShowMatchesController> getShowMatchesControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ShowMatchesController>forConstructor(MatchService.class, ReportService.class)
            .withGenerator((registeredBean, args) -> new ShowMatchesController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'showMatchesController'.
   */
  public static BeanDefinition getShowMatchesControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ShowMatchesController.class);
    beanDefinition.setInstanceSupplier(getShowMatchesControllerInstanceSupplier());
    return beanDefinition;
  }
}
