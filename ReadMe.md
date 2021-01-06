## com.rainsunset 项目模板 ##

### 一、项目说明
> 本项目只作为新建项目模板使用，集成功能的应用案例可参考java-starter-sample
### 二、根据项目生成archetype模板并发布nexus的流程
1. 构建模板前最好先升级项目版本，以免覆盖老版本
```
mvn versions:set -DnewVersion=1.0.0
```
2. 构建模板命令
```
mvn clean compile archetype:create-from-project
```
3. 进入模板根目录
```
cd target/generated-sources/archetype
```
4. 再进入模板源码目录删除掉无关内容，如：.idea/.iml/README.md等，以及删除掉子模块下的.iml文件
```
cd src\main\resources\archetype-resources
```
5. 返回模板根目录
```
cd ../../../..
```
6. 重新打包模板
```
mvn clean package
```
7. 此时模板根目录下target文件夹里已经打好了模板jar包，但因为.gitignore文件没有copy进jar包，所以可以通过压缩工具(winRar之类)手动加进去

8. 将模板jar包手动上传nexus，记得勾选Generate a POM file with these coordinates

9. 打tag
```
# 对某个提交后的快照，打 tag
git tag -a 0.2.7 -m "Release 0.2.7"
git push origin 0.2.7
```

10. 倘若某版本丢失或被覆盖
```bash
# 查看所有版本
git tag

# checkout 到某具体版本
git checkout 0.2.7
```