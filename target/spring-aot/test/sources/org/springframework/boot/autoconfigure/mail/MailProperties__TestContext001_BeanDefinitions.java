package org.springframework.boot.autoconfigure.mail;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MailProperties}.
 */
@Generated
public class MailProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'mailProperties'.
   */
  public static BeanDefinition getMailPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MailProperties.class);
    beanDefinition.setInstanceSupplier(MailProperties::new);
    return beanDefinition;
  }
}
