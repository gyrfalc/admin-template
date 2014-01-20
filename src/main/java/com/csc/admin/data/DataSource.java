package com.csc.admin.data;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.csc.admin.util.AdminUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {
	
	/* ====================================================================================
	 * Author
	 * http://syntx.co/languages-frameworks/configuring-c3p0-connection-pooling-with-jdbc/
	 * ====================================================================================
	 */

    /**
    * A singleton that represents a pooled datasource. It is composed of a C3PO
    * pooled datasource. Can be changed to any connect pool provider
    */
    private Properties props;
    private ComboPooledDataSource cpds;
    private static DataSource datasource;
    private static Logger log = Logger.getLogger(DataSource.class);

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        // load datasource properties
        log.info("Reading datasource.properties from classpath");
        props = AdminUtils.readProperties("database.properties");
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(props.getProperty("jdbc.driverClassName"));
        cpds.setJdbcUrl(props.getProperty("jdbc.url"));
        cpds.setUser(props.getProperty("jdbc.username"));
        cpds.setPassword(props.getProperty("jdbc.password"));
        
        if (log.isDebugEnabled()) {
        	log.debug("driver name = " + cpds.getDriverClass());
        	log.debug("jdbc url = " + cpds.getJdbcUrl());
        	log.debug("user name = " + cpds.getUser());
        	log.debug("password = " + cpds.getPassword());
        }

        cpds.setInitialPoolSize(new Integer((String) props.getProperty("conn.initialPoolSize")));
        cpds.setAcquireIncrement(new Integer((String) props.getProperty("conn.acquireIncrement")));
        cpds.setMaxPoolSize(new Integer((String) props.getProperty("conn.maxPoolSize")));
        cpds.setMinPoolSize(new Integer((String) props.getProperty("conn.minPoolSize")));
        cpds.setMaxStatements(new Integer((String) props.getProperty("conn.maxStatements")));

        Connection testConnection = null;
        Statement testStatement = null;

        // test connectivity and initialize pool
        try {
               testConnection = cpds.getConnection();
               testStatement = testConnection.createStatement();
               testStatement.executeQuery("select count(*) from admin_params");
            } catch (SQLException e) {
                throw e;
            } finally {
                testStatement.close();
                testConnection.close();
        }

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
              datasource = new DataSource();
              return datasource;
            } else {
              return datasource;
            }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}
