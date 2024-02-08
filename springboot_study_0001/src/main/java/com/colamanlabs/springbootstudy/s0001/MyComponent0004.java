package com.colamanlabs.springbootstudy.s0001;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Qualifier.html
 * 
@Component 에는 @Qualifier 를 지정해도 에러는 없지만, 적용되지 않는다.

[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[7]:[myComponent0001]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[8]:[myComponent0002]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[9]:[MyComponent0003_value_defined]]
[SpringbootStudy0001Application/checkApplicationContext] beanInfo:[arrBeanNames[10]:[myComponent0004]]
 */
@Component
@Qualifier(value="MyComponent0004_qualifier_defined")
public class MyComponent0004
{
    
}
