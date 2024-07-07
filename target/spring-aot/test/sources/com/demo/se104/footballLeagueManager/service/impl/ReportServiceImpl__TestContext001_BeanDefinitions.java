package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.ReportRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReportServiceImpl}.
 */
@Generated
public class ReportServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'reportServiceImpl'.
   */
  private static BeanInstanceSupplier<ReportServiceImpl> getReportServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<ReportServiceImpl>forConstructor(ReportRepository.class)
            .withGenerator((registeredBean, args) -> new ReportServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'reportServiceImpl'.
   */
  public static BeanDefinition getReportServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ReportServiceImpl.class);
    beanDefinition.setInstanceSupplier(getReportServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
