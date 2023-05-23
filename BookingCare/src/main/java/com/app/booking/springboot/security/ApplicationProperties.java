/**
 * 
 */
package com.app.booking.springboot.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LongNguyen
 *
 */

@Component
public class ApplicationProperties {

	@Value("${spring.datasource.driver.classname}")
	private String driverClassname;

	@Value("${spring.jpa.properties.hibernate.current_session_context_class}")
	private String currentSessionContextClass;

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String datasourceUsername;

	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	@Value("${hikaricp.connectionTimeout}")
	private long hikariCP_ConnectionTimeout;

	@Value("${hikaricp.idleTimeout}")
	private long hikariCP_IdleTimeout;

	@Value("${hikaricp.maxLifetime}")
	private long hikariCP_MaxLifetime;

	@Value("${hikaricp.maximumPoolSize}")
	private int hikariCP_MaximumPoolSize;

	@Value("${hikaricp.minimumIdle}")
	private int hikariCP_MinimumIdle;

	@Value("${hikaricp.cachePrepStmts}")
	private String hikariCP_CachePrepStmts;

	@Value("${hikaricp.cacheResultSetMetadata}")
	private String hikariCP_CacheResultSetMetadata;

	@Value("${hikaricp.cacheServerConfiguration}")
	private String hikariCP_CacheServerConfiguration;

	@Value("${hikaricp.prepStmtCacheSize}")
	private int hikariCP_PrepStmtCacheSize;

	@Value("${hikaricp.prepStmtCacheSqlLimit}")
	private int hikariCP_PrepStmtCacheSqlLimit;

	@Value("${hikaricp.useServerPrepStmts}")
	private String hikariCP_UseServerPrepStmts;

	@Value("${hikaricp.useLocalSessionState}")
	private String hikariCP_UseLocalSessionState;

	@Value("${hikaricp.rewriteBatchedStatements}")
	private String hikariCP_RewriteBatchedStatements;

	@Value("${hikaricp.elideSetAutoCommit}")
	private String hikariCP_ElideSetAutoCommit;

	@Value("${hikaricp.maintainTimeStats}")
	private String hikariCP_MaintainTimeStats;

	public String getDatasourceUrl() {
		return datasourceUrl;
	}

	public String getCurrentSessionContextClass() {
		return currentSessionContextClass;
	}

	public String getDatasourceUsername() {
		return datasourceUsername;
	}

	public String getDatasourcePassword() {
		return datasourcePassword;
	}

	public String getDriverClassname() {
		return driverClassname;
	}

	/**
	 * @return the hikariCP_ConnectionTimeout
	 */
	public long getHikariCP_ConnectionTimeout() {
		return hikariCP_ConnectionTimeout;
	}

	/**
	 * @return the hikariCP_IdleTimeout
	 */
	public long getHikariCP_IdleTimeout() {
		return hikariCP_IdleTimeout;
	}

	/**
	 * @return the hikariCP_MaxLifetime
	 */
	public long getHikariCP_MaxLifetime() {
		return hikariCP_MaxLifetime;
	}

	/**
	 * @return the hikariCP_MaximumPoolSize
	 */
	public int getHikariCP_MaximumPoolSize() {
		return hikariCP_MaximumPoolSize;
	}

	/**
	 * @return the hikariCP_MinimumIdle
	 */
	public int getHikariCP_MinimumIdle() {
		return hikariCP_MinimumIdle;
	}

	/**
	 * @return the hikariCP_CachePrepStmts
	 */
	public String getHikariCP_CachePrepStmts() {
		return hikariCP_CachePrepStmts;
	}

	/**
	 * @return the hikariCP_CacheResultSetMetadata
	 */
	public String getHikariCP_CacheResultSetMetadata() {
		return hikariCP_CacheResultSetMetadata;
	}

	/**
	 * @return the hikariCP_CacheServerConfiguration
	 */
	public String getHikariCP_CacheServerConfiguration() {
		return hikariCP_CacheServerConfiguration;
	}

	/**
	 * @return the hikariCP_PrepStmtCacheSize
	 */
	public int getHikariCP_PrepStmtCacheSize() {
		return hikariCP_PrepStmtCacheSize;
	}

	/**
	 * @return the hikariCP_PrepStmtCacheSqlLimit
	 */
	public int getHikariCP_PrepStmtCacheSqlLimit() {
		return hikariCP_PrepStmtCacheSqlLimit;
	}

	/**
	 * @return the hikariCP_UseServerPrepStmts
	 */
	public String getHikariCP_UseServerPrepStmts() {
		return hikariCP_UseServerPrepStmts;
	}

	/**
	 * @return the hikariCP_RewriteBatchedStatements
	 */
	public String getHikariCP_RewriteBatchedStatements() {
		return hikariCP_RewriteBatchedStatements;
	}

	/**
	 * @return the hikariCP_ElideSetAutoCommit
	 */
	public String getHikariCP_ElideSetAutoCommit() {
		return hikariCP_ElideSetAutoCommit;
	}

	/**
	 * @return the hikariCP_MaintainTimeStats
	 */
	public String getHikariCP_MaintainTimeStats() {
		return hikariCP_MaintainTimeStats;
	}

	public String getHikariCP_UseLocalSessionState() {
		return hikariCP_UseLocalSessionState;
	}

}