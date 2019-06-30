# springboot-ehcache-sample



**访问**
- 只有第一次访问会进行数据库访问

http://localhost:8080/user/1?name=444

**查看当前缓存**

http://localhost:8080/user/caches/list

```
// 缓存对象
Cache: [ name = userCache status = STATUS_ALIVE eternal = false overflowToDisk = false maxEntriesLocalHeap = 100 maxEntriesLocalDisk = 0 memoryStoreEvictionPolicy = LFU timeToLiveSeconds = 300 timeToIdleSeconds = 0 persistence = none diskExpiryThreadIntervalSeconds = 120 cacheEventListeners: ; orderedCacheEventListeners: maxBytesLocalHeap = 0 overflowToOffHeap = false maxBytesLocalOffHeap = 0 maxBytesLocalDisk = 0 pinned = false ]

// 缓存元素
Element: [ key = SimpleKey [1,444], value=SysUser{id=1, username='null', name='444', password='null', salt='null', state=0}, version=1, hitCount=2, CreationTime = 1561903432796, LastAccessTime = 1561903439161 ]
```