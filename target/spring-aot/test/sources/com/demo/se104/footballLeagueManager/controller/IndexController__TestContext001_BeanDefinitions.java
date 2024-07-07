package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.ChartService;
import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.ReportService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link IndexController}.
 */
@Generated
public class IndexController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'indexController'.
   */
  private static BeanInstanceSupplier<IndexController> getIndexControllerInstanceSupplier() {
    return BeanInstanceSupplier.<IndexController>forConstructor(ChartService.class, MatchService.class, ReportService.class)
            .withGenerator((registeredBean, args) -> new IndexController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'indexController'.
   */
  public static BeanDefinition getIndexControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(IndexController.class);
    beanDefinition.setInstanceSupplier(getIndexControllerInstanceSupplier());
    return beanDefinition;
  }
}
