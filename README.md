# github-api-jgit

- https://stackoverflow.com/questions/36301008/git-pull-add-commit-and-push-in-java
- https://git-scm.com/book/en/v2
- https://stackoverflow.com/questions/19475042/how-to-push-and-pull-java-files-into-git
- https://segmentfault.com/p/1210000013305124
- https://www.wty90.com/2018/02/18/git-auto-commit/
- http://blog.51cto.com/5162886/2094475
- https://www.cnblogs.com/songshu120/p/6180747.html
- https://github.com/centic9/jgit-cookbook
 
 ## 依賴
 
```xml
<dependency>
    <groupId>org.eclipse.jgit</groupId>
    <artifactId>org.eclipse.jgit</artifactId>
    <version>3.5.0.201409260305-r</version>
</dependency>
```

```java
Repository rep = new FileRepository("E:\\learing_code\\github-api-jgit\\.git");
Git git = new Git(rep);
PersonIdent defaultCommitter = new PersonIdent(git.getRepository());
PersonIdent committer = new PersonIdent(defaultCommitter, Date);
git.commit().setMessage("auto commit").setCommitter(committer).call();
```