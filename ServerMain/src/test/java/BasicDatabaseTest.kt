import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.server.WebServer
import kotlinx.coroutines.runBlocking
import org.jooq.exception.DataAccessException
import org.junit.Test
import org.slf4j.LoggerFactory
import java.sql.SQLException


class BasicDatabaseTest {
    @Test
    fun raiseErrorTest() {
        runBlocking {
            try {
                WebServer.startMySQLDatabasePool()
                Routines.raiseError(AppConstants.jooqConfiguration, "TestRaiseError", 1234)
                throw AssertionError("Expected a exception")
            } catch (e: DataAccessException) {
                if (e.cause != null && e.cause is SQLException) {
                    println("OK: SQLSTATE ${e.sqlState()}: ${(e.cause as SQLException).errorCode} - ${e.cause!!.message}")
                }

            }
        }
    }
}