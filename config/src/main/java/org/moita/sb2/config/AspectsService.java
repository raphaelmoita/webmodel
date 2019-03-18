package org.moita.sb2.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Aspect
@Configuration
public class AspectsService
{
	
	private final static String SOME_PACKAGES_ALL_CLASSES = "execution(* com.abc.xyz..controller..*(..)) || "
														  + "execution(* com.abc.xyz..service..*(..)) || "
														  + "execution(* com.abc.xyz..dao..*(..))";

	private final static String ALL_PACKAGES_ALL_CLASSES = "execution(* org.moita.sb2..*(..))";

	@PostConstruct
	public void postConstructor() {
		System.out.println("+++++++ ASPECTS ++++++++");
	}

	@Around(ALL_PACKAGES_ALL_CLASSES)
	public Object timeElapsed(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		System.out.println("[executed in " + executionTime + "ms] " + joinPoint.getSignature());
		return proceed;
	}

//	@Around("execution(* org.moita.sb2.service.SimpleCompanyService.getEmployeeById(..))")
//	public Object enrich(ProceedingJoinPoint joinPoint) throws Throwable {
//		Object proceed = joinPoint.proceed(this.enrichItemDescription(joinPoint.getArgs(), 0));
//		return proceed;
//	}
//
//	private Object[] enrichItemDescription(Object[] obj, int argPosition) {
//		Employee employee = Optional.ofNullable(obj)
//							.filter(o -> o[argPosition] instanceof Employee)
//							.map(o -> (Employee) o[argPosition])
//							.orElseThrow(() -> new IllegalStateException("Invalid input argument."));
//		employee.setName(employee.getName() + " the best");
//		return new Object[] {employee};
//	}
}
