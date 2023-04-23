1. Create class : public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor{}
2. Crreate file : \src\main\resources\META-INF\spring.factories :

content in file : 
org.springframework.boot.env.EnvironmentPostProcessor=com.thieu.preconfig.pre_config.CustomEnvironmentPostProcessor

=> with "com.thieu.preconfig.pre_config.CustomEnvironmentPostProcessor" is path class CustomEnvironmentPostProcessor
