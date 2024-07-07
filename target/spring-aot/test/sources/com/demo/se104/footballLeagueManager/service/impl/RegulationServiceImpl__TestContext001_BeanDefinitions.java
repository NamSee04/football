package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.RegulationRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RegulationServiceImpl}.
 */
@Generated
public class RegulationServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'regulationServiceImpl'.
   */
  private static BeanInstanceSupplier<RegulationServiceImpl> getRegulationServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RegulationServiceImpl>forConstructor(RegulationRepository.class)
            .withGenerator((registeredBean, args) -> new RegulationServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'regulationServiceImpl'.
   */
  public static BeanDefinition getRegulationServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RegulationServiceImpl.class);
    beanDefinition.setInstanceSupplier(getRegulationServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
