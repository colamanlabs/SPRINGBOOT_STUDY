

incrementer 적용 결과

Run Configuration 으로 ${string_prompt} 를 지정하고

requestDate=20240215

입력하고,

run.id 는 별도로 지정하지 않는다.


잡 파라미터를 지정하지 않았지만 run.id 가 증가한다.



  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m             [2m (v2.7.18)[0;39m

...
Started SpringbootStudy0008Application in 1.092 seconds (JVM running for 1.606)
Running default command line with: [requestDate=20240215]
[MyParameterValidator/validate] BEGIN
[MyParameterValidator/validate] mapParameters.size():[2]
[MyParameterValidator/validate] strKey:[requestDate]	jobParameter:[20240215]
[MyParameterValidator/validate] strKey:[run.id]	jobParameter:[5]
[MyParameterValidator/checkJobParameterRequestDate] BEGIN
[MyParameterValidator/checkJobParameterRequestDate] requestDate:[20240215]
[MyParameterValidator/checkJobParameterRequestDate] jobParameter requestDate:[20240215] is valid.
[MyParameterValidator/checkJobParameterRequestDate] END
[MyParameterValidator/validate] END
Job: [SimpleJob: [name=JOB_0001]] launched with the following parameters: [{requestDate=20240215, run.id=5}]
[MyParameterValidator/validate] BEGIN
[MyParameterValidator/validate] mapParameters.size():[2]
[MyParameterValidator/validate] strKey:[requestDate]	jobParameter:[20240215]
[MyParameterValidator/validate] strKey:[run.id]	jobParameter:[5]
[MyParameterValidator/checkJobParameterRequestDate] BEGIN
[MyParameterValidator/checkJobParameterRequestDate] requestDate:[20240215]
[MyParameterValidator/checkJobParameterRequestDate] jobParameter requestDate:[20240215] is valid.
[MyParameterValidator/checkJobParameterRequestDate] END
[MyParameterValidator/validate] END
Executing step: [STEP_TASKLET_0001]
[MySimpleTasklet0001/execute] BEGIN
[MySimpleTasklet0001/execute] contribution:[[StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=EXECUTING]]
[MySimpleTasklet0001/execute] chunkContext:[ChunkContext: attributes=[], complete=false, stepContext=SynchronizedAttributeAccessor: [scopedTarget.createTasklet0001=com.colamanlabs.springbootstudy.s0008.MySimpleTasklet0001@67484715], stepExecutionContext={batch.taskletType=jdk.proxy3.$Proxy51, batch.stepType=org.springframework.batch.core.step.tasklet.TaskletStep}, jobExecutionContext={}, jobParameters={run.id=5, requestDate=20240215}]
[MySimpleTasklet0001/execute] mapJobParameters:[{run.id=5, requestDate=20240215}]
[MySimpleTasklet0001/execute] END
Step: [STEP_TASKLET_0001] executed in 14ms
Job: [SimpleJob: [name=JOB_0001]] completed with the following parameters: [{requestDate=20240215, run.id=5}] and the following status: [COMPLETED] in 26ms
[SpringbootStudy0007Application/init] BEGIN
[SpringbootStudy0007Application/init] END
...


batch_job_execution_params 테이블을 보면 자동으로 증가하는 것을 알 수 있다.

SELECT a.* FROM batch_job_execution_params a WHERE a.JOB_EXECUTION_ID >= 31 ;


"JOB_EXECUTION_ID"	"TYPE_CD"	"KEY_NAME"	"STRING_VAL"	"DATE_VAL"	"LONG_VAL"	"DOUBLE_VAL"	"IDENTIFYING"
"31"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"31"	"LONG"	"run.id"	""	"1970-01-01 09:00:00.000000"	"1"	"0"	"Y"
"32"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"32"	"LONG"	"run.id"	""	"1970-01-01 09:00:00.000000"	"2"	"0"	"Y"
"33"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"33"	"LONG"	"run.id"	""	"1970-01-01 09:00:00.000000"	"3"	"0"	"Y"
"34"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"34"	"LONG"	"run.id"	""	"1970-01-01 09:00:00.000000"	"4"	"0"	"Y"
"35"	"STRING"	"requestDate"	"20240215"	"1970-01-01 09:00:00.000000"	"0"	"0"	"Y"
"35"	"LONG"	"run.id"	""	"1970-01-01 09:00:00.000000"	"5"	"0"	"Y"


-- 잡 인크리멘터 검토 끝 