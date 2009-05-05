<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="deteDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='deteDetail.heading'/>"/>
</head>

<s:form id="deteForm" action="saveDete" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="dete.idde"/>
    </li>
    <s:select key="dete.hraniteljskaPorodica" name="dete.hraniteljskaPorodica.brlkh" list="hraniteljskaPorodicas"
    headerKey="-10" headerValue="--Select Porodica--" listKey="brlkh" listValue="brlkh">
    </s:select>
    <s:textfield key="dete.imede" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="dete.jmbde" required="true" maxlength="255" cssClass="text medium"/>
    <s:select key="dete.kategorija" name="dete.kategorija.idk" list="kategorijas"
    headerKey="-10" headerValue="--Select Kategori--" listKey="idk" listValue="nazk">
    </s:select>
    <s:textfield key="dete.przde" required="true" maxlength="20" cssClass="text medium"/>
    <s:select key="dete.tim" name="dete.tim.idt" list="tims"
    headerKey="-10" headerValue="--Select Tim--" listKey="idt" listValue="idt">
    </s:select>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty dete.idde}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Dete')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("deteForm"));
</script>
