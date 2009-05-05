<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="deteList.title"/></title>
    <meta name="heading" content="<fmt:message key='deteList.heading'/>"/>
    <meta name="menu" content="DeteMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editDete.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="detes" class="table" requestURI="" id="deteList" export="true" pagesize="25">
    <display:column property="idde" sortable="true" href="editDete.html" media="html"
        paramId="idde" paramProperty="idde" titleKey="dete.idde"/>
    <display:column property="idde" media="csv excel xml pdf" titleKey="dete.idde"/>
    <display:column property="imede" sortable="true" titleKey="dete.imede"/>
    <display:column property="jmbde" sortable="true" titleKey="dete.jmbde"/>
    <display:column property="przde" sortable="true" titleKey="dete.przde"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="deteList.dete"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="deteList.detes"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="deteList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="deteList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="deteList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("deteList");
</script>
