import junit.framework.TestCase;

public class LFUCacheTest extends TestCase {

    private LFUCache testLFUCache;

    public LFUCacheTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
        testLFUCache = new LFUCache(5);
        testLFUCache.put(1, 22);
        testLFUCache.put(2, 23);
        testLFUCache.put(3, 27);
        testLFUCache.put(4, 29);
        testLFUCache.put(5, 28);
        testLFUCache.put(6, 21);
        testLFUCache.put(7, 24);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        testLFUCache = null;
    }

    public void testLFU() {
        System.out.println("=========================================");
        System.out.println("*********** Caching Test Start **********");
        System.out.println("=========================================");

        assertEquals(testLFUCache.size(),5);
        assertEquals(testLFUCache.get(1), -1);
        assertEquals(testLFUCache.get(2), -1);
        assertEquals(testLFUCache.get(3), 27);
        assertEquals(testLFUCache.get(4), 29);
        testLFUCache.put(1, 22);
        assertEquals(testLFUCache.get(5), -1);
        testLFUCache.put(2, 23);

        System.out.println("=========================================");
        System.out.println("*********** Caching Test End **********");
        System.out.println("=========================================");
    }

}