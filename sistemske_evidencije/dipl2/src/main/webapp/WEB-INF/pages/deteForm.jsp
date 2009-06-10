<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="deteDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='deteDetail.heading'/>"/>
</head>

<s:form id="deteForm" action="saveDete" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="dete.idde"/>
    </li>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="dete.kategorija" name="dete.kategorija.idk" list="kategorijas" headerKey="-10" headerValue="--Select Kategorija--" listKey="idk" listValue="nazk"></s:select>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="dete.tim" name="dete.tim.idt" list="tims" headerKey="-10" headerValue="--Select Tim--" listKey="idt+' '+nazt"></s:select>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="dete.hraniteljskaPorodica" name="dete.hraniteljskaPorodica.brlkh" list="hraniteljskaPorodicas" listKey="brlkh" listValue="brlkh+' ime: '+imeh'+' prezime: '+przh"></s:select>
    <s:textfield key="dete.imer" required="false" maxlength="20" cssClass="text medium"/>
    <s:textfield key="dete.przr" required="false" maxlength="20" cssClass="text medium"/>
    <s:textfield key="dete.jmbr" required="false" maxlength="13" cssClass="text medium"/>
    <s:textfield key="dete.adrr" required="false" maxlength="50" cssClass="text medium"/>
    <s:textfield key="dete.gradr" required="false" maxlength="20" cssClass="text medium"/>
    <s:textfield key="dete.imede" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="dete.przde" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="dete.jmbde" required="true" maxlength="13" cssClass="text medium"/>
    <s:textfield key="dete.drde" required="true" cssClass="text medium"/>
    
    
    <s:textfield key="dete.telr" required="false" maxlength="15" cssClass="text medium"/>
    <s:textfield key="dete.zipr" required="false" maxlength="10" cssClass="text medium"/>

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
