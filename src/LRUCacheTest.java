import junit.framework.TestCase;

public class LRUCacheTest extends TestCase{

    private LRUCache testLRUCache;

    public LRUCacheTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
        testLRUCache = new LRUCache(3);
        testLRUCache.put(1, 22);
        testLRUCache.put(2, 23);
        testLRUCache.put(3, 27);
        testLRUCache.put(4, 29);
        testLRUCache.put(5, 28);
        testLRUCache.put(6, 21);
        testLRUCache.put(7, 24);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        testLRUCache = null;
    }

    public void testLRU() {
        System.out.println("=========================================");
        System.out.println("*********** Caching Test Start **********");
        System.out.println("=========================================");

        assert testLRUCache.size() == 3;

        assert testLRUCache.get(1) == -1;

        assert testLRUCache.get(7) == 24;

        System.out.println("=========================================");
        System.out.println("*********** Caching Test End **********");
        System.out.println("=========================================");
    }
}