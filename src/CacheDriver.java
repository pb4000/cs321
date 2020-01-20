/**
 * Driver to interact with the Cache
 * @param <T>
 */

public class CacheDriver<T> {
    private int level;
    private Cache<T> cache1, cache2;
    private int size1, size2;
    private int c1Hits, c2Hits;

    public int getLevel() { return level; }

    public Cache<T> getCache1() {
        return cache1;
    }

    public Cache<T> getCache2() {
        return cache2;
    }

    public int getC1Hits() {
        return c1Hits;
    }

    public int getC2Hits() {
        return c2Hits;
    }

    public CacheDriver(int level, int maxSize1) throws IllegalArgumentException {
        if (level < 1 || level > 2 || maxSize1 < 1) {
            throw new IllegalArgumentException("Illegal Parameters");
        }
        this.level = level;

        cache1 = new Cache(maxSize1);
        c1Hits = c2Hits = 0;
    }

    public CacheDriver(int level, int maxSize1, int maxSize2) throws IllegalArgumentException {
        if (level < 1 || level > 2 || maxSize1 < 1 || maxSize1 < 1) {
            throw new IllegalArgumentException("Illegal parameters");
        }
        this.level = level;
        cache1 = new Cache(maxSize1);
        cache2 = new Cache(maxSize2);
        c1Hits = c2Hits = 0;
    }

    /**
     * Search cache1. Move searched object to top of cache1.
     * If there are 2 levels, search cache2. Move searched item to top of cache2.
     * @param object
     * @return
     */
    public void search(T object) {
        if (cache1.search(object) != null) {    // searches for specified object and brings it to top of cache
            c1Hits++;
            if (level == 2) {
                cache2.search(object);
            }
            return;
        } else {
            cache1.addToTop(object);
        }
        if (level == 2 && cache2.search(object) != null) {
            c2Hits++;
        } else {
            cache2.addToTop(object);
        }
    }
}
