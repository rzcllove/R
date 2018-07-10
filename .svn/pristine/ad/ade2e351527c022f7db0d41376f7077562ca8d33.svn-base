package top.rzclk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author wangk
 * 多线程参数
 *
 */
//指定扫描该包
@Component
@ConfigurationProperties( prefix = TaskThreadPoolConfig.PREFIX)
public class TaskThreadPoolConfig {
	
	public static final String PREFIX = "Thread";
	
	private int corePoolSize = 10;  
	  
    private int maxPoolSize = 200;  
  
    private int keepAliveSeconds;  
  
    private int queueCapacity = 10;

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public int getKeepAliveSeconds() {
		return keepAliveSeconds;
	}

	public void setKeepAliveSeconds(int keepAliveSeconds) {
		this.keepAliveSeconds = keepAliveSeconds;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}  
    
    

}
