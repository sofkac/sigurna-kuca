<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="kategorijaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='kategorijaDetail.heading'/>"/>
</head>

<s:form id="kategorijaForm" action="saveKategorija" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="kategorija.idk"/>
    </li>
    <s:textfield key="kategorija.nazk" required="true" maxlength="22" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty kategorija.idk}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Kategorija')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("kategorijaForm"));
</script>
