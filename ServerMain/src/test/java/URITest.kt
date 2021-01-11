import com.kenvix.web.utils.appendQuery
import org.junit.Assert
import org.junit.Test
import java.net.URI
import kotlin.test.assertEquals

//--------------------------------------------------
// Class URITest
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

class URITest {
    @Test
    fun appendURITest() {
        var uri = URI("/user/login?a=b")
        assertEquals("/user/login?a=b", uri.toString())

        uri = URI("http://kenvix.com/path/to/something/index.php?param1=VALUE1#fragment")
        assertEquals("http://kenvix.com/path/to/something/index.php?param1=VALUE1#fragment", uri.toString())

        uri = uri.appendQuery("param2=AppendedParam")
        assertEquals("http://kenvix.com/path/to/something/index.php?param1=VALUE1&param2=AppendedParam#fragment", uri.toString())

        uri = uri.appendQuery("param3=中文")
        assertEquals("http://kenvix.com/path/to/something/index.php?param1=VALUE1&param2=AppendedParam&param3=中文#fragment", uri.toString())

        uri = uri.appendQuery("param4=空 格")
        uri = uri.appendQuery("param5=~!@#$%^&*()_+-=[]|\\;',./:\"?></")
        assertEquals("http://kenvix.com/path/to/something/index.php?param1=VALUE1&param2=AppendedParam&param3=中文&param4=空%20格&param5=~!@%23\$%25%5E&*()_+-=[]%7C%5C;',./:%22?%3E%3C/#fragment", uri.toString())
    }
}