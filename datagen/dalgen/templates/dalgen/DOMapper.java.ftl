<@pp.dropOutputFile />

<#if gen.doMapper?? && gen.doObject.hasExistFile=='no'>
<#assign doMapper =gen.doMapper>


<#assign table  = gen.table>
<@pp.changeOutputFile name = "/src/main/java/${doMapper.classPath}/${doMapper.className}.java" />
package ${doMapper.packageName};

    import java.util.List;
    <#list doMapper.importLists as import>
        import ${import};
    </#list>
    import ${doMapper.doQuery.packageName}.${doMapper.doQuery.className};

    /**
 * 表名称:  ${table.tableName}
 */
public interface ${doMapper.className} extends ${doMapper.baseClassName} {

    public int queryTotalCount(${doMapper.doQuery.className} ${doMapper.doQuery.className?uncap_first});


    <#if gen.page??>
    public List<${doMapper.doObject.className}> queryPage(PageQuery<${doMapper.doQuery.className}> page);

     </#if>
}

</#if>