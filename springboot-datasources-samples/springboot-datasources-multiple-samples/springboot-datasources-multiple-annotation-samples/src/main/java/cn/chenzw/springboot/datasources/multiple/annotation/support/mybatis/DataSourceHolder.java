package cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis;

/**
 * 线程级数据源持有者
 */
public abstract class DataSourceHolder {

    private static final ThreadLocal<String> dsTL = new ThreadLocal<>();

    /**
     * 设置数据源
     */
    public static void set(String dataSource) {
        dsTL.set(dataSource);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String get() {
        return dsTL.get();
    }

    /**
     * 清除数据源
     */
    public static void clear() {
        dsTL.remove();
    }
}
