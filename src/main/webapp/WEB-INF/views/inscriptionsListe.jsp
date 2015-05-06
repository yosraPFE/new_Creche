<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<h>Liste des Inscriptions</h>
<div id="tableInscription" class="cadre" >

<table class="tab1">

<tr>
<th>ID</th><th>ANNEE</th><th>DATE INSCRIPTION</th><th>TARIF INSCRIPTION</th><th>REMISE</th>
</tr>
<c:forEach items="${inscriptions}" var="insc">
<tr>

<td>${insc.idinscription}</td>
<td>${insc.annee}</td>
<td>${insc.dateInscription}</td>
<td>${insc.tarifInscription}</td>
<td>${insc.remise}</td>


<td><a href="supprimerListeInscription?idInscription=${insc.idinscription}">Supprimer<a/></td>
<td><a href="modifierListeInscription?idInscription=${insc.idinscription}">Modifier<a/></td>
</tr>
</c:forEach>

</table>

<div>

<c:forEach begin="0" end="${nbrPages-1}" var="p">



<c:choose>

<c:when test="${p==page}">
<span>Page ${p}</span>
</c:when>
<c:otherwise>

<span>
<a href="indexPage?page=${p}">Page ${p}</a>
</span>

</c:otherwise>

</c:choose>
</c:forEach>

</div>



</div>
<c:if  test="${inscription.idinscription!=0}">
<div id="formInsc" class="cadre"> 
  
    <f:form modelAttribute="inscription" action="validerModificationInscr" method="post"> 
   
      
      <table>
          <tr>
           <td>ID</td>
           <td><f:input path="idinscription"/></td>
           <td><f:errors path="idinscription" cssClass="errors"/></td>
           </tr>
          
           
       
           <tr>
           <td>Annee:</td>
           <td><f:input path="annee"/></td>
           <td><f:errors path="annee" cssClass="errors"/></td>
           </tr>
           
           
           <fmt:formatDate value="<%= new java.util.Date()%>" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>
			
	
           <f:input type="hidden" path="dateInscription" value="${myDate}" />
           <f:errors type="hidden" path="dateInscription" cssClass="errors"/>
           
           
           <tr>
           <td>Tarif Inscription:</td>
           <td><f:input path="tarifInscription"/></td>
           <td><f:errors path="tarifInscription" cssClass="errors"/></td>
           </tr>
           
           <tr>
           <td>Remise</td>
            <td><f:input  path="remise"/></td>
           <td><f:errors path="remise" cssClass="errors"/>
           </tr>
           
          
          
           
           <tr>
           <td><input type="submit" value="Enregistrer Modification"/></td>
           </tr>
        
     </table>
      
     
    </f:form>
   

</div>
</c:if>
