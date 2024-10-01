<@pp.dropOutputFile />

<@pp.changeOutputFile name = "/src/main/resources/mybatis-config.xml" />
<!--
该文件是mybatis的配置文件,这里不建议修改该文件只是提供一个模板，
如果使用请把文件移到web层配置文件中进行相应的配置修改
-->
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <settings>
        <setting name="logImpl" value="SLF4J"/>
    </settings>

    <typeHandlers>
    </typeHandlers>
    <!-- 自动生成,如需修改请移步 mybatis-config.xml.ftl  -->
    <mappers>
    </mappers>
</configuration>
