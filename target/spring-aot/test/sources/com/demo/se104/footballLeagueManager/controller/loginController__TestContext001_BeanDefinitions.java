package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.service.AdminService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Bean definitions for {@link loginController}.
 */
@Generated
public class loginController__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'loginController'.
   */
  private static BeanInstanceSupplier<loginController> getLoginControllerInstanceSupplier() {
    return BeanInstanceSupplier.<loginController>forConstructor(AdminService.class, JavaMailSender.class)
            .withGenerator((registeredBean, args) -> new loginController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'loginController'.
   */
  public static BeanDefinition getLoginControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(loginController.class);
    beanDefinition.setInstanceSupplier(getLoginControllerInstanceSupplier());
    return beanDefinition;
  }
}
