package test;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import test.base.BaseSpringTest;

/**
 * @author ChenYanRui
 * @since 2020/3/20
 */
public class DemoTest extends BaseSpringTest {
    /**
     * 在BaseTestConfig里MockBean过，此处Autowired进来的就是mock的对象
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {
        // mock结果跟BaseTestConfig里一致
        String test = redisTemplate.opsForValue().get("test");
        System.out.println(test);

        // 重新mock
        ValueOperations mockValueOps = Mockito.mock(ValueOperations.class);
        Mockito.doReturn(mockValueOps).when(redisTemplate).opsForValue();
        Mockito.doReturn("111").when(mockValueOps).get(Mockito.anyString());
        // 重mock后再次执行
        test = redisTemplate.opsForValue().get("test");

        long count = repository1.count();
        System.out.println(count);
        System.out.println(test);
    }
}
