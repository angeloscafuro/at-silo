<%@
	include file="atsilo_files/header.jsp"
%>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td class="breadcrumb " align="left"><p> </a></p>
  <p>&nbsp;</p></td>
</tr>
</tbody></table>
<%@
include file="atsilo_files/sidebar_genitore.jsp"
 %>
 
<img width="209" border="0" alt="" height="1" src="atsilo_images/clearpixel.gif"></td><td class="content" valign="top" bgcolor="#ffffff"><%@ page
		import="java.util.*,atsilo.application.*,atsilo.entity.*"%>
 <% // setto select bambino
		ControlDatiPersonali cdt= ControlDatiPersonali.getIstance();
	   	Utente utente=cdt.getValoriUtente(username);
	  	Genitore genitore_richiedente=cdt.getDatiGenitore(utente.getCodiceFiscale());//genitore richiedente
	  	List<Bambino> figli= new ArrayList<Bambino>();
	  	figli= cdt.getFigli(genitore_richiedente.getCodiceFiscale()); //lista dei figli 
			%>
			 <%
	 //setta campi form una volta selezionato il nome del bambino
	  String cfb=null;
	 if (request.getParameter("select_bambini")!=null )
	  cfb=(String)request.getParameter("select_bambini");
	 %>
 <%
 	if   (request.getParameter("successo") != null  ) { 
 		if (request.getParameter("successo").equals("ok")) {
 			out.print("<script type=text/javascript>alert('Pre iscrizione effettuata con successo');window.location='"+temp_nome_chiamante+"';window.location='"+temp_nome_chiamante+"';</script>");
 		} else {
 			String mess=request.getParameter("errore");
 			out.print("<script type=text/javascript>alert('"+mess+"');window.location='"+temp_nome_chiamante+"';window.location='"+temp_nome_chiamante+"';</script>");
 		}
 	}
 %>
 <form name="presenta_domanda_bando" action="<%=request.getContextPath()%>/ServletIscrizioneBambino" method="post" onSubmit="return confirm('Sei sicuro di voler rinunciare all'iscrizione? ');">
 <input name="chiamante" type="hidden" id="chiamante"
			value="rinuncia">
<table cellspacing="10" cellpadding="0" border="0" width="100%">
  <tbody>
  
    <tr>
      <td><table border="0">
        <tbody>
        
      	    <tr>
    <td colspan="4"><label for="altrifisglinido_1">Selezionare il figlio per il quale si vuole rinunciare all'iscrizione</label><br></td>
      
  </tr>
  <tr>
  <td colspan="2"><% if(figli.size()>0)
						{
							out.print("<select name='select_bambini' id='select_bambini' onchange='submitForm()'><option value='null' >Selezionare Bambino</option>");
							String selected="";
							  for (int i=0;i<figli.size();i++){
							  	selected="";
								  if (figli.get(i).getCodiceFiscale().equals(cfb))
									  selected="selected";
							  out.print("<option value='"+figli.get(i).getCodiceFiscale()+"'"+selected+" >"+figli.get(i).getNome()+"</option>");
							  }
						}
						else
						{
							out.print("<em><b>E' necessario inserire un bambino</b></em>");
							return;
						}
						
						%>
						</select></td>
     <td>&nbsp;</td>
  </tr>
          <tr>
            <td >Si ricorda che per presentare la domanda di rinuncia &egrave; necessario aver inserito un bambino</td>
            
            </tr>
            <tr>
              <td>&nbsp;</td></tr>
                <!-- Se tutti i dati sono stati compilati correttamente e non &egrave; scaduto il bando, il tasto PRESENTA DOMANDA ISCRIZIONE sarà abilitato, altrimenti sarà disabled-->
             <tr>
            <td >
           <input type='submit' value='Invio Domanda Iscrizione'>
           </td>
            
            </tr>
          </tbody>
        </table>
         </form></td>
            </tr>
          <tr>
            <td><img border="0" alt="" height="20" width="1" src="atsilo_files/clearpixel.gif" /></td>
            </tr>
          </tbody>
        </table></td>
    </tr>

  </tbody>
</table>
</td><td class="fasciadxvariabile"></td>
</tr>
<%@
include file="atsilo_files/footer.jsp"
 %>



</body>
</html>