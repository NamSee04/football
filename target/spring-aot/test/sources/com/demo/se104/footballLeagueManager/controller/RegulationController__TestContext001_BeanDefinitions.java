package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.RegulationService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RegulationController}.
 */
@Generated
public class RegulationController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'regulationController'.
   */
  private static BeanInstanceSupplier<RegulationController> getRegulationControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RegulationController>forConstructor(RegulationService.class)
            .withGenerator((registeredBean, args) -> new RegulationController(args.get(0)));
  }

  /**
   * Get the bean definition for 'regulationController'.
   */
  public static BeanDefinition getRegulationControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RegulationController.class);
    beanDefinition.setInstanceSupplier(getRegulationControllerInstanceSupplier());
    return beanDefinition;
  }
}
