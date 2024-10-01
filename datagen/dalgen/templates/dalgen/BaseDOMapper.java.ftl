<@pp.dropOutputFile />

<#if gen.doMapper??>
<#assign doMapper =gen.doMapper>
<#assign table  = gen.table>
<@pp.changeOutputFile name = "/src/main/java/${doMapper.classPath}/${doMapper.baseClassName}.java" />
package ${doMapper.packageName};

<#list doMapper.importLists as import>
import ${import};
</#list>

import java.util.List;

/**
 * 表名称:  ${table.tableName}
 */
public interface ${doMapper.baseClassName} {

    public int insert(${doMapper.doObject.className} ${doMapper.doObject.className?uncap_first});
    <#if doMapper.primaryKeyFields?? >
        <#list doMapper.primaryKeyFields.fieldsList as fields>
    /**
     * 根据主键 ${fields.name} 删除信息
     */
    public int deleteBy${fields.name?cap_first}(${fields.javaType} ${fields.name});

    /**
     * 根据主键 ${fields.name} 查询信息
     */
    public ${doMapper.doObject.className} getBy${fields.name?cap_first}(${fields.javaType} ${fields.name});

    /**
     * 根据主键 ${fields.name} 更新信息
     * 不建议全量更新表字段, 如果需要更新根据业务进行判空更新
     */
    public int updateBy${fields.name?cap_first}(${doMapper.doObject.className} ${doMapper.doObject.className?uncap_first});
        </#list>
    </#if>
    <#if doMapper.uniqueIndexFields?? >

    <#list doMapper.uniqueIndexFields.fieldsList as fields>
     /**
      * 根据唯一索引 ${fields.name} 删除信息
      */
    public int deleteByUkIndex${fields.name?cap_first}(${fields.javaType} ${fields.name});

    /**
     * 根据唯一索引 ${fields.name} 查询信息
     */
    public ${doMapper.doObject.className} getByUkIndex${fields.name?cap_first}(${fields.javaType} ${fields.name});

    /**
     * 根据唯一索引 ${fields.name} 更新信息
     */
    public int updateByUkIndex${fields.name?cap_first}(${doMapper.doObject.className} ${doMapper.doObject.className?uncap_first});

     </#list>

    </#if>



    /**
     * 根据条件查询数据
     */
    public List<${doMapper.doObject.className}> queryList(${doMapper.doObject.className} ${doMapper.doObject.className?uncap_first});

    /**
     * 查询表中所有信息
     */
    public List<${doMapper.doObject.className}> queryAll();

}

</#if>