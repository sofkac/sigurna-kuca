<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="kategorijaList.title"/></title>
    <meta name="heading" content="<fmt:message key='kategorijaList.heading'/>"/>
    <meta name="menu" content="KategorijaMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editKategorija.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="kategorijas" class="table" requestURI="" id="kategorijaList" export="true" pagesize="25">
    <display:column property="idk" sortable="true" href="editKategorija.html" media="html"
        paramId="idk" paramProperty="idk" titleKey="kategorija.idk"/>
    <display:column property="idk" media="csv excel xml pdf" titleKey="kategorija.idk"/>
    <display:column property="nazk" sortable="true" titleKey="kategorija.nazk"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="kategorijaList.kategorija"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="kategorijaList.kategorijas"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="kategorijaList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="kategorijaList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="kategorijaList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("kategorijaList");
</script>
