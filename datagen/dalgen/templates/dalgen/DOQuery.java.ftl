<@pp.dropOutputFile />
<#if gen.doQuery??  && gen.doQuery.hasExistFile=='no'>

<#assign DOQuery =gen.doQuery>
<@pp.changeOutputFile name = "/src/main/java/${DOQuery.classPath}/${DOQuery.className}.java" />

package ${DOQuery.packageName};

public class ${DOQuery.className}{

}
</#if>
