<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>
    <!--Tim-START-->
    <menu:displayMenu name="TimMenu"/>
    <!--Tim-END-->
    <!--Kategorija-START-->
    <menu:displayMenu name="KategorijaMenu"/>
    <!--Kategorija-END-->
    <!--HraniteljskaPorodica-START-->
    <menu:displayMenu name="HraniteljskaPorodicaMenu"/>
    <!--HraniteljskaPorodica-END-->
    <!--Dete-START-->
    <menu:displayMenu name="DeteMenu"/>
    <!--Dete-END-->
</ul>
</menu:useMenuDisplayer>