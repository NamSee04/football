package com.demo.se104.footballLeagueManager.service.impl;

import com.demo.se104.footballLeagueManager.dao.AdminRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AdminServiceImpl}.
 */
@Generated
public class AdminServiceImpl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'adminServiceImpl'.
   */
  private static BeanInstanceSupplier<AdminServiceImpl> getAdminServiceImplInstanceSupplier() {
    return BeanInstanceSupplier.<AdminServiceImpl>forConstructor(AdminRepository.class)
            .withGenerator((registeredBean, args) -> new AdminServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'adminServiceImpl'.
   */
  public static BeanDefinition getAdminServiceImplBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AdminServiceImpl.class);
    beanDefinition.setInstanceSupplier(getAdminServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
