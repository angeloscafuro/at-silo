<%@page import="java.sql.Date"%>
<%@
	include file="atsilo_files/header.jsp"
%>
<%@page import="atsilo.entity.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>

<%@page import="atsilo.application.*"%>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td class="breadcrumb " align="left"><p> </a></p>
  <p>&nbsp;</p></td>
</tr>
</tbody></table>
<%@
include file="atsilo_files/autoinclude_sidebar_giusta_tipologia.jsp"
 %>

<br>
<img width="209" border="0" alt="" height="1" src="atsilo_images/clearpixel.gif"></td><td class="content" valign="top" bgcolor="#ffffff">
<table width="100%">
<tbody><tr>
<td>
<div class="titolopagina">Benvenuto XXX</div>
</td><td class="fasciadxvariabile"></td>
</tr>
</tbody></table>

<table cellspacing="10" cellpadding="0" border="0" width="100%">
<tbody><tr>
<td class="tplHeader">
<h2 align=center >Compila Questionario</h2>

<%
	int id;
	try {
		id = Integer.parseInt(request.getParameter("id"));
	}
	catch (Exception e) {
		id = -1;
	}
	Questionario quest = null;
	
	Questionario quest1 = new Questionario("questa � una prova", "no", "linda � antipatica?", 10, new Date(10,10,2012),  new Date(10,10,2012));
	Questionario quest2 = new Questionario("questa � una prova2", "no", "giulio � antipatico?", 12, new Date(10,10,2012),  new Date(10,10,2012));
	List<Questionario> list = new ArrayList<Questionario>();
	List<DomandaQuestionario> d1 = new ArrayList<DomandaQuestionario>();
	List<CampoDomandaQuestionario> c1 = new ArrayList<CampoDomandaQuestionario>();
	c1.add(new CampoDomandaQuestionario("checkbox","bene","bene",1 ));
	c1.add(new CampoDomandaQuestionario("checkbox","male","male", 1));
	c1.add(new CampoDomandaQuestionario("checkbox","malissimo","malissimo", 1));
	c1.add(new CampoDomandaQuestionario("checkbox","non so","non so",1));
	//DomandaQuestionario d = new DomandaQuestionario(91, quest.getId(), "prova", c1);
	/*
	c1.add(new CampoDomandaQuestionario("checkbox","bene","bene",1 ));
	c1.add(new CampoDomandaQuestionario("checkbox","male","male", 1));
	c1.add(new CampoDomandaQuestionario("checkbox","malissimo","malissimo", 1));
	c1.add(new CampoDomandaQuestionario("checkbox","non so","non so",1));
	List<CampoDomandaQuestionario> c2 = new ArrayList<CampoDomandaQuestionario>();
	c2.add(new CampoDomandaQuestionario("radio","bene","bene", 2));
	c2.add(new CampoDomandaQuestionario("radio","male","male", 2));
	c2.add(new CampoDomandaQuestionario("radio","malissimo","malissimo",2));
	c2.add(new CampoDomandaQuestionario("radio","non so","non so",2));
	quest2.setDomande(d1);
	list.add(quest1);
	list.add(quest2);
	
	/*Questionario quest = null;
	 ControlQuestionario q = null;
	q=q.getIstance();
	List<Questionario> list = q.getAllQuestionari();
	List<Questionario> list = new List<Questionario>();
	list.get(0).getDomande().get(0); 
	for (int i = 0; i < list.size(); i++) {

		if (list.get(i).getId() == id) {
	quest = list.get(i);
	break;
		}
	}
	/*
	if (quest == null) {
		out.println("<center> <img width=200 height=200 src = atsilo_images/errore.jpg><br><br><h2>Nessun questionario corrispondente</h2></center><br><br>");
	}
	else {

		out.println("<form action=\"http://localhost:8080/Atsilo/servletControlSottomettiQuestionario\" method='POST'>");
		out.println("<div id=formdomande>");

		out.println("<H2>Titolo Questionario: " + quest.getNome()+ "</h2><br><br><BR><BR>");
		out.println("Descrizione del questionario: \t<br><br><p style=\"border: 1px solid black; height: 100px\">"
				+ quest.getDescrizione() + "</p><br><br>");
		for (int i = 0; i < quest.getDomande().size(); i++) {
			out.println("<br><br><fieldset>");
			out.println("<table id='parah"+i+"'>");
			out.println("<tr><td><h3>Domanda </h3><td><h3>"
					+ quest.getDomande().get(i).getDescrizione()
					+ "'</h3></td></tr>");
			for (int j = 0; j < quest.getDomande().get(i).getCampi().size(); j++) {
				out.println("<tr><td colspan=2><input type=\""+quest.getDomande().get(i).getCampi().get(j).getTipo() +"\" name=\"opzione"+ i + "[]\">" + quest.getDomande().get(i).getCampi().get(j).getDescrizione() + "</td></tr>");
			}
			out.println("</table><br><br>");
			out.println("</fieldset><br><br>");
		}

		out.println("<center><input type=submit value=\"Sottometti Questionario\"></center>");
		out.println("<input type=hidden name=action value=modify>");
		out.println("</form>");
	}
	*/
%>

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