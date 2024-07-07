package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.ChartService;
import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChartController}.
 */
@Generated
public class ChartController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'chartController'.
   */
  private static BeanInstanceSupplier<ChartController> getChartControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ChartController>forConstructor(ChartService.class, MatchService.class, RegulationService.class)
            .withGenerator((registeredBean, args) -> new ChartController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'chartController'.
   */
  public static BeanDefinition getChartControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChartController.class);
    beanDefinition.setInstanceSupplier(getChartControllerInstanceSupplier());
    return beanDefinition;
  }
}
