package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.ChartRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChartServiceImpl}.
 */
@Generated
public class ChartServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'chartServiceImpl'.
   */
  private static BeanInstanceSupplier<ChartServiceImpl> getChartServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<ChartServiceImpl>forConstructor(ChartRepository.class)
            .withGenerator((registeredBean, args) -> new ChartServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'chartServiceImpl'.
   */
  public static BeanDefinition getChartServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChartServiceImpl.class);
    beanDefinition.setInstanceSupplier(getChartServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
