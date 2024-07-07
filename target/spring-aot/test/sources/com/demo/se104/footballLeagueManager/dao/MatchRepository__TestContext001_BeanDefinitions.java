package com.demo.se104.footballLeagueManager.dao;

import com.demo.se104.footballLeagueManager.entity.MatchEntity;
import java.lang.Class;
import java.lang.Integer;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean__TestContext001_Autowiring10;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Bean definitions for {@link MatchRepository}.
 */
@Generated
public class MatchRepository__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'matchRepository'.
   */
  private static BeanInstanceSupplier<JpaRepositoryFactoryBean> getMatchRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JpaRepositoryFactoryBean>forConstructor(Class.class)
            .withGenerator((registeredBean, args) -> new JpaRepositoryFactoryBean(args.get(0)));
  }

  /**
   * Get the bean definition for 'matchRepository'.
   */
  public static BeanDefinition getMatchRepositoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaRepositoryFactoryBean.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(JpaRepositoryFactoryBean.class, MatchRepository.class, MatchEntity.class, Integer.class));
    beanDefinition.setLazyInit(false);
    beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "com.demo.se104.footballLeagueManager.dao.MatchRepository");
    beanDefinition.getPropertyValues().addPropertyValue("queryLookupStrategyKey", QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND);
    beanDefinition.getPropertyValues().addPropertyValue("lazyInit", false);
    beanDefinition.getPropertyValues().addPropertyValue("namedQueries", new RuntimeBeanReference("jpa.named-queries#10"));
    beanDefinition.getPropertyValues().addPropertyValue("repositoryFragments", new RuntimeBeanReference("jpa.MatchRepository.fragments#0"));
    beanDefinition.getPropertyValues().addPropertyValue("transactionManager", "transactionManager");
    beanDefinition.getPropertyValues().addPropertyValue("entityManager", new RuntimeBeanReference("jpaSharedEM_entityManagerFactory"));
    beanDefinition.getPropertyValues().addPropertyValue("escapeCharacter", '\\');
    beanDefinition.getPropertyValues().addPropertyValue("mappingContext", new RuntimeBeanReference("jpaMappingContext"));
    beanDefinition.getPropertyValues().addPropertyValue("enableDefaultTransactions", true);
    InstanceSupplier<JpaRepositoryFactoryBean> instanceSupplier = getMatchRepositoryInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(JpaRepositoryFactoryBean__TestContext001_Autowiring10::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
