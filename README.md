# SPRINGBOOT_STUDY

 springboot 기술이해를 위한 테스트 소스들 입니다.
 
 
## 1. 0001
-  @EventListener(ApplicationReadyEvent.class)
-  ApplicationContext 
- @Component
- @Configuration, @Bean
- @Value


## 2. 0002
- JdbcTemplate


## 3. 0003 
- SpringBoot + legacy TCP echo server 


## 4. 0004
- SpringBoot + NIO TCP echo server


## 5. 0005
- SpringBatch 테스트
- 환경 구성중 확인한 예제가 동작하지 않아, 진행 중단함
- 원인분석결과 SpringBoot v3 에서는 SpringBatch v5 로 개발해야 함


## 6. 0006
- SpringBatch 테스트
- SpringBoot v3 에서는 SpringBatch v5 로 개발해야 함에 따라, v2 로 지정하는 방법 적용
- job 생성, tasklet 생성, 간단한 start(), next() 를 통한 흐름제어 적용


## 7. 0007
- SpringBatch 테스트
- JobParameters 조회 테스트
- StepScope 테스트(늦은 바인딩 허용)
- JobParametersValidator 를 통한 잡 파라미터 유효성 확인
- CompositeJobParametersValidator 를 통한 복수개의 Validator 지정 방법 확인


## 8. 0008
- SpringBatch 테스트
- RunIdJobIncrementer 테스트


## 9. 0009
- SpringBatch 테스트
- 잡 리스너 적용하기


...

  
(작성중)
