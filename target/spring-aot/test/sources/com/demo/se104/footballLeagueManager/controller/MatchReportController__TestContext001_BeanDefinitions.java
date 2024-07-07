package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.PlayerService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.ReportService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MatchReportController}.
 */
@Generated
public class MatchReportController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'matchReportController'.
   */
  private static BeanInstanceSupplier<MatchReportController> getMatchReportControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MatchReportController>forConstructor(MatchService.class, ReportService.class, PlayerService.class, RegulationService.class)
            .withGenerator((registeredBean, args) -> new MatchReportController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'matchReportController'.
   */
  public static BeanDefinition getMatchReportControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MatchReportController.class);
    beanDefinition.setInstanceSupplier(getMatchReportControllerInstanceSupplier());
    return beanDefinition;
  }
}
