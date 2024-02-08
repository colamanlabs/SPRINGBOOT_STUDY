package com.colamanlabs.springbootstudy.s0001;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * @Component
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Component.html
 * 
String
value
The value may indicate a suggestion for a logical component name, to be turned into a Spring bean name in case of an autodetected component.

옵션요소 "value" 지정을 통햐beanName 을 변경할 수 있다.
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[7]:[myComponent0001]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[8]:[myComponent0002]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[9]:[MyComponent0003_value_defined]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[10]:[myComponent0004]]
*/
@Component(value="MyComponent0003_value_defined")

/*
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/ConfigurableBeanFactory.html#SCOPE_SINGLETON
 */
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        
public class MyComponent0003
{
    
}
