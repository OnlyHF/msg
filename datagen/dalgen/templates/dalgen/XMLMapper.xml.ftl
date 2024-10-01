<@pp.dropOutputFile />
<#if gen.xmlMapper?? && gen.doObject.hasExistFile=='no' && gen.dbType=='mysql'>
<#assign xmlMapper =gen.xmlMapper>
<#assign table  = gen.table>
<#assign doMapper =gen.doMapper>
<@pp.changeOutputFile name = "/src/main/resources/${xmlMapper.xmlPath}/${xmlMapper.doMapper.className}.xml" />
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${xmlMapper.doMapper.packageName}.${xmlMapper.doMapper.className}">

    <select id="queryTotalCount" resultType="Integer">
        select count(*) from   ${table.tableName}
        <trim prefix="where" prefixOverrides="and">
        </trim>
    </select>


    <#if gen.page??>
        <#assign page =gen.page>
        <select id="queryPage" parameterType="${page.basePackageName}.PageQuery" resultMap="BaseResultMap">
            select <include refid="Base_Column_List"/>  from  ${table.tableName}
            <if test="condition != null">
                <trim prefix="where" prefixOverrides="and">

                </trim>
            </if>
            limit ${"#"}{startPosition},${"#"}{pageSize}
        </select>

    </#if>


</mapper>
</#if>
