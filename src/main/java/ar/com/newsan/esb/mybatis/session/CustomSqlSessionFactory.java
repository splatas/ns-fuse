package ar.com.newsan.esb.mybatis.session;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *    https://stackoverflow.com/questions/17578335/alter-session-to-set-date-format-in-mybatis
 */

@Component(value = "sqlSessionFactory")
public class CustomSqlSessionFactory extends DefaultSqlSessionFactory {

    private static Logger sessionLogger = LoggerFactory.getLogger(CustomSqlSessionFactory.class);
    
    public CustomSqlSessionFactory(Configuration configuration) {
        super(configuration);
    }
    
    @Override
    public SqlSession openSession()
    {
        SqlSession session = super.openSession();
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(boolean autoCommit)
    {
        SqlSession session = super.openSession(autoCommit);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(Connection connection)
    {
        SqlSession session = super.openSession(connection);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType)
    {
        SqlSession session = super.openSession(execType);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit)
    {
        SqlSession session = super.openSession(execType, autoCommit);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection)
    {
        SqlSession session = super.openSession(execType, connection);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level)
    {
        SqlSession session = super.openSession(execType, level);
        alterSession(session);
        return session;
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level)
    {
        SqlSession session = super.openSession(level);
        alterSession(session);
        return session;
    }

    // Method to alter session
    private void alterSession(SqlSession session)
    {
    	Statement statement = null;
        try
        {
            statement = session.getConnection().createStatement();
            statement.addBatch("ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY HH24:MI'");
            statement.executeBatch();
            sessionLogger.debug("Altered newly created session parameters.");
        }
        catch (SQLException e)
        {
            sessionLogger.error("Alter session failed!", e);
        }
        finally {
        	try {
        		if (statement != null) {
        			statement.close();
        		}
			
        	} catch (SQLException e) {
				sessionLogger.error("Error closing statement: " + e.getMessage());
			}
        	
        }
    }

}
