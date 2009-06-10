<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="pripadaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='pripadaDetail.heading'/>"/>
</head>

<s:form id="pripadaForm" action="savePripada" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="pripada.idp"/>
    </li>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="pripada.tim" name="pripada.tim.idt" list="tims" headerKey="-10" headerValue="--Select Tim--" listKey="idt" listValue="idt+' '+nazt"></s:select>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="pripada.zanimanje" name="pripada.zanimanje.idzan" list="zanimanjes" headerKey="-10" headerValue="--Select Zanimanje--" listKey="idzan" listValue="nazzan"></s:select>
    <s:textfield key="pripada.brlj" required="true" maxlength="45" cssClass="text medium"/>
    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty pripada.idp}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Pripada')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("pripadaForm"));
</script>
