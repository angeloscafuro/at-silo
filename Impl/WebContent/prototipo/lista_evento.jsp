<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="atsilo.util.AtsiloConstants,atsilo.application.*,atsilo.entity.*, java.sql.*"%>
<%@
	include file="atsilo_files/header.jsp"
%>

<%
	if (request.getParameter("successo") != null && !temp_nome_chiamante.equals("lista_domanda_confermata.jsp"))  { 
		if (request.getParameter("successo").equals("y")) {
			out.print("<script type=text/javascript>alert('Modifica salvata con successo')</script>");
		}
		else
		{
 			if ((request.getParameter("errore")) != null) {
 				out.print("<script type=text/javascript>alert('"+request.getParameter("errore").toString()+"')</script>");
 		 	} else {
			out.print("<script type=text/javascript>alert('Modifica fallita')</script>");
			}
		}
	}
%>

<script type="text/javascript">
function modificaForm(){
	document.getElementById("frm").setAttribute("action","<%=request.getContextPath()%>/prototipo/modifica_evento.jsp");
	document.getElementById("frm").submit();
}
function inserisciForm(){
	document.getElementById("frm").setAttribute("action","<%=request.getContextPath()%>/prototipo/inserisci_evento.jsp");
	document.getElementById("frm").submit();
}

</script>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td class="breadcrumb " align="left"><p> </a></p>
  <p>&nbsp;</p></td>
</tr>
</tbody></table>
<%@
include file="atsilo_files/autoinclude_sidebar_giusta_tipologia.jsp"%>
<img width="209" border="0" alt="" height="1" src="atsilo_images/clearpixel.gif"></td><td class="content" valign="top" bgcolor="#ffffff">
<table width="100%">
<tbody><tr>
<td>
<%

String mese = request.getParameter("month");
String giorno = request.getParameter("day");
String anno = request.getParameter("year");
int m = Integer.parseInt(mese);
m +=1;
Date data = new Date(Integer.parseInt(anno),m,Integer.parseInt(giorno));
ControlDatiPersonali crtPers = ControlDatiPersonali.getIstance();
ControlEvento crtEvn = ControlEvento.getIstance();
%>
<h1>Lista degli eventi del <%= giorno %>/<%= ""+m %>/<%=anno %></h1>
<form id="frm" action="<%=request.getContextPath()%>/ServletEventoElimina" method="post" >
<input type="hidden" value="<%= giorno+"/"+m+"/"+anno %>" name="data" />
<div align="center">
<% 
if(tipologia.compareTo(AtsiloConstants.CAT_GENITORE) != 0){
%>
<input type="button" value="Inserisci Nuovo Evento" name="inserisci" id="ins" onclick="inserisciForm()" />
<%} %>
</div>
<table>
<%
	if(tipologia.compareTo(AtsiloConstants.CAT_GENITORE) == 0){
		Utente genitore = crtPers.getValoriUtente(username);
		String cfGen = genitore.getCodiceFiscale();
		java.util.List<Evento> eventiGenitore = crtEvn.getEventiPerGenitoreInData(cfGen, data);
		for(int j=0; j<eventiGenitore.size();j++){
			String pathprint="";
			if(eventiGenitore.get(j).getPath()!=null)
			{
				pathprint = "<a href='"+request.getContextPath()+"/"+eventiGenitore.get(j).getPath()+"'>Allegato</a>";
			}
			out.append("<tr><td>")
			.append("<span style='font-size:14px'><b>"+eventiGenitore.get(j).getNome()+"</b></span>")
			.append("<pre>")
			.append(eventiGenitore.get(j).getDescrizione())
			.append("</pre></td><td>"+pathprint+"</td></tr>");
		}
		
	}
	else{
	
		Utente uAsilo;
			if(tipologia.compareTo(AtsiloConstants.CAT_IMP_ASILO) == 0){
				uAsilo = crtPers.getPersonaleAsiloFromUsername(username);
				out.print("<input type='hidden' name='cfimp' value='"+uAsilo.getCodiceFiscale()+"' />");
			}
			else if(tipologia.compareTo(AtsiloConstants.CAT_PSICOPEDAGOGO) ==0){
				uAsilo = crtPers.getPsicoPedagogoFromUsername(username);	
				out.print("<input type='hidden' name='cfimp' value='"+uAsilo.getCodiceFiscale()+"' />");
			}
			else if(tipologia.compareTo(AtsiloConstants.CAT_EDUCATORE) == 0){
				uAsilo = crtPers.getEducatoreDidatticoFromUsername(username);
				out.print("<input type='hidden' name='cfimp' value='"+uAsilo.getCodiceFiscale()+"' />");
			}
			else{
				out.print("<h2>Non hai i permessi per visualizzare gli eventi");
				return;
			}
		String cfpAsilo = uAsilo.getCodiceFiscale();
		java.util.List<Evento> eventi = crtEvn.getEventiInData(data);
		int nEventi = eventi.size();
		java.util.List<Evento> propriEventi = new ArrayList<Evento>();
		java.util.List<Evento> altriEventi = new ArrayList<Evento>();
		for(int i=0;i<nEventi;i++){
			if(crtEvn.verificaCreatoreEvento(eventi.get(i), cfpAsilo) == true){
				propriEventi.add(eventi.get(i));
			}
			else{
				altriEventi.add(eventi.get(i));
			}
		}
		int pEvenLun = propriEventi.size();
		String checked = "";
			for(int k=0; k<pEvenLun;k++){
				if(k==0){
					checked="checked";
				}
				else{
					checked="";
				}
				String pathprint="";
				if(propriEventi.get(k).getPath()!=null)
				{
					pathprint = "<a href='"+request.getContextPath()+"/"+propriEventi.get(k).getPath()+"'>Allegato</a>";
				}
				out.append("<tr><td>")
					.append("<input type='radio' name='evento' value='")
					.append(""+propriEventi.get(k).getId())
					.append("'"+checked+" />")
					.append("<span style='font-size:14px'><b>"+propriEventi.get(k).getNome()+"</b></span>")
					.append("<pre>")
					.append(propriEventi.get(k).getDescrizione())
					.append("</pre></td><td>"+pathprint+"</td></tr>");
			}
			out.print("</table>");
			if(pEvenLun == 0){
				out.print("<h2>Non ci sono eventi</h2>");
			} 
			else{
				
			
			out.print("<input type='submit' value='Modifica' id='mod' name='modifica' onclick='modificaForm()' />");
			out.print("<input type='submit' value='Elimina' name='elimina' id='mod' />");
		
			int aEvenLun = altriEventi.size();
			out.print("<br /><br /> Resto degli eventi per questa data");
			
			
			for(int j=0; j<aEvenLun;j++){
				String pathprint="";
				if(altriEventi.get(j).getPath()!=null)
				{
					pathprint = "<a href='"+request.getContextPath()+"/"+altriEventi.get(j).getPath()+"'>Allegato</a>";
				}
				out.append("<tr><td>")
				.append("<span style='font-size:14px'><b>"+altriEventi.get(j).getNome()+"</b></span>")
				.append("<pre>")
				.append(altriEventi.get(j).getDescrizione())
				.append("</pre></td><td>"+pathprint+"</td></tr>");
			}
		}
	
	} //Fine Eventi Impiegato Asilo


%>
</form>
</td><td class="fasciadxvariabile"></td>
</tr>
</tbody></table>

<table cellspacing="10" cellpadding="0" border="0" width="100%">
<tbody><tr>
<td class="tplHeader">


<p><strong><br />
</strong></p>
<p>&nbsp;</p></td>
</tr>
<tr>
<td>
<table cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td class="tplTitolo"><b></b></td>
</tr>
</tbody></table>
</td>
</tr>
<tr>
<td>
<table cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td>
<table width="598" cellspacing="0" cellpadding="0" border="0"></table>
</td>
</tr>
<tr>
<td><img border="0" alt="" height="20" width="1" src="atsilo_files/clearpixel.gif"></td>
</tr>
</tbody></table>
</td>
</tr>
<tr>
<td class="tplHeader"></td>
</tr>
</tbody></table>
</td><td class="fasciadxvariabile"></td>
</tr>
<tr>
<td class="bottom" width="209">&nbsp;2012 &copy; Unisa</td><td align="right" class="bottom"></td>
</tr>
</tbody></table>


</body>
</html>