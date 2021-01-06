package test.base;

import com.rainsunset.dal.db1.repository.JavaStarterRepository1;
import com.rainsunset.dal.db2.repository.JavaStarterRepository2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 在基类中，可对dal层进行公共的mock、stub
 * 针对第三方框架的客户端mock在BaseTestConfig中处理
 */
@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BaseTestConfig.class)
public abstract class BaseSpringTest {

    /**
     * protected修饰则子测试类可用
     */
    @MockBean
    protected JavaStarterRepository1 repository1;
    @MockBean
    protected JavaStarterRepository2 repository2;

    /**
     * 在每一个test单元之前都会初始化一遍，此处主要针对dal层，做一些通用的mock操作
     * 个性化的mock请在各自的test方法内处理（可根据需要复写doReturn的结果，从而覆盖此处定义）
     */
    @Before
    public void commonMockInit() {
        log.info("common mock init...");
        mockRepository();
    }

    private void mockRepository() {
        // mock行为：repository1在count表数据时，不会操作数据库，而是直接返回一个99
        Mockito.doReturn(99L).when(repository1).count();
    }

}
