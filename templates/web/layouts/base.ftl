<#macro page_head>
</#macro>

<#macro page_content>
</#macro>

<#macro page_scripts>
</#macro>

<#macro display_page>
<!doctype html>
<html lang="">
    <head>
        <#include "../shared/_head.ftl">
        <@page_head/>
    </head>
    <body>
        <@page_content/>

        <#include "../shared/_scripts.ftl">
        <@page_scripts/>
    </body>
</html>
</#macro>
