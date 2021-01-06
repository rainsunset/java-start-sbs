## com.rainsunset 项目模板 ##

### 需要查询总页码的分页配置 ###
- pom
``` xml
<!--分页-->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.2.5</version>
</dependency>
```
- *ServiceImpl.java
``` java
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
......
@Override public PageInfo<Record> getUserRecordPageList(String userId, Integer page, Integer rows)
    throws Exception {
PageHelper.startPage(page, rows, true);
List<Record> recordList = null;
recordList = recordMapper.getRecordListByUserId(userId);
PageInfo<Record> pageInfo = new PageInfo<Record>(recordList);
return pageInfo;
    }
 ......
```