<#include "../layouts/base.ftl">

<#assign title = "Hello, world">

<#macro page_content>
<h1>${message}</h1>
<h1>The above text is set using a FreeMarkerEngine</h1>
</#macro>

<@display_page/>
