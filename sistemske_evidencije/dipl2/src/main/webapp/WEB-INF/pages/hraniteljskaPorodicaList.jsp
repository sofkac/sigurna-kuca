<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="hraniteljskaPorodicaList.title"/></title>
    <meta name="heading" content="<fmt:message key='hraniteljskaPorodicaList.heading'/>"/>
    <meta name="menu" content="ApplicationMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editHraniteljskaPorodica.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="hraniteljskaPorodicas" class="table" requestURI="" id="hraniteljskaPorodicaList" export="true" pagesize="25">
    <display:column property="brlkh" sortable="true" href="editHraniteljskaPorodica.html" media="html"
        paramId="brlkh" paramProperty="brlkh" titleKey="hraniteljskaPorodica.brlkh"/>
    <display:column property="brlkh" media="csv excel xml pdf" titleKey="hraniteljskaPorodica.brlkh"/>
    <display:column property="imeh" sortable="true" titleKey="hraniteljskaPorodica.imeh"/>
    <display:column property="przh" sortable="true" titleKey="hraniteljskaPorodica.przh"/>
    <display:column property="jmbh" sortable="true" titleKey="hraniteljskaPorodica.jmbh"/>
    <display:column property="adrh" sortable="true" titleKey="hraniteljskaPorodica.adrh"/>
    <display:column property="gradh" sortable="true" titleKey="hraniteljskaPorodica.gradh"/>
    <display:column property="ziph" sortable="true" titleKey="hraniteljskaPorodica.ziph"/>
    <display:column property="telh" sortable="true" titleKey="hraniteljskaPorodica.telh"/>
    

    <display:setProperty name="paging.banner.item_name"><fmt:message key="hraniteljskaPorodicaList.hraniteljskaPorodica"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="hraniteljskaPorodicaList.hraniteljskaPorodicas"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="hraniteljskaPorodicaList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="hraniteljskaPorodicaList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="hraniteljskaPorodicaList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("hraniteljskaPorodicaList");
</script>
