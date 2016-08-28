<#include "../layouts/base.ftl">

<#assign title = "Hello, world">

<#macro page_content>
<h1>${message}</h1>
<h2>The above text is set using a FreeMarkerEngine</h2>
</#macro>

<@display_page/>
