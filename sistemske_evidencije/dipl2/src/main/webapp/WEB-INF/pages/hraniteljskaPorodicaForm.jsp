<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="hraniteljskaPorodicaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='hraniteljskaPorodicaDetail.heading'/>"/>
</head>

<s:form id="hraniteljskaPorodicaForm" action="saveHraniteljskaPorodica" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="hraniteljskaPorodica.brlkh"/>
    </li>
    <s:textfield key="hraniteljskaPorodica.imeh" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="hraniteljskaPorodica.przh" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="hraniteljskaPorodica.jmbh" required="true" maxlength="13" cssClass="text medium"/>
    <s:textfield key="hraniteljskaPorodica.adrh" required="true" maxlength="50" cssClass="text medium"/>
    <s:textfield key="hraniteljskaPorodica.gradh" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="hraniteljskaPorodica.ziph" required="true" maxlength="10" cssClass="text medium"/>
    <s:textfield key="hraniteljskaPorodica.telh" required="false" maxlength="15" cssClass="text medium"/>
    
    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty hraniteljskaPorodica.brlkh}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('HraniteljskaPorodica')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("hraniteljskaPorodicaForm"));
</script>
