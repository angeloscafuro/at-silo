<%@page import="atsilo.util.AtsiloConstants"%>
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
<img width="209" border="0" alt="" height="1" src="atsilo_images/clearpixel.gif"></td><td class="content" valign="top" bgcolor="#ffffff">
<%@
include file="atsilo_files/sidebar_top_iscrizione.jsp"
 %>
 <%@ page
		import="java.util.*,atsilo.application.*,atsilo.entity.*"%>
 <% // setto select bambino
		ControlDatiPersonali cdt= ControlDatiPersonali.getIstance();
	   	Utente utente=cdt.getValoriUtente(username);
	  	Genitore genitore_richiedente=cdt.getDatiGenitore(utente.getCodiceFiscale());//genitore richiedente
	  	List<Bambino> figli= new ArrayList<Bambino>();
	  	figli= cdt.getFigli(genitore_richiedente.getCodiceFiscale()); //lista dei figli 
	  	
	 //setto select orari
	  ControlOrario co= ControlOrario.getInstance();
	  List<OrarioUtente> orari= new ArrayList<OrarioUtente>();
	  orari=co.getElencoOrarioUtente();
			%>
			 <%
	 //setta campi form una volta selezionato il nome del bambino
	  String cfb=null;
	  String action="";
	  if (request.getParameter("select_bambini")!=null ){
	  cfb=(String)request.getParameter("select_bambini");
	  
	  }
	 %>
 <%
 	if  (request.getParameter("successo")!=null ) { 
 		if (request.getParameter("successo").equals("ok")) {
 			out.print("<script type=text/javascript>alert('Presentazione domanda effettuata con successo');window.location='"+temp_nome_chiamante+"';</script>");
 		} else {
 			if ((request.getParameter("errore")) != null) {
 				out.print("<script type=text/javascript>alert('"+request.getParameter("errore").toString()+"');window.location='"+temp_nome_chiamante+"';</script>");
 		 	}
 		}
 	}
 	
 %>


<table cellspacing="10" cellpadding="0" border="0" width="100%">
  <tbody>
  
    <tr>
      <td><table border="0">
        <tbody>
      	
          <tr>
            <td ><p>IL COMPLETAMENTO DELLA DOMANDA &Egrave; OBBLIGATORIO PER COMPLETARE L'ISCRIZIONE DOPO LA PUBBLICAZIONI DELLE GRADUATORIE.
              </p>
              <p><br>
                PRIMA DELL'INVIO DELLA DOMANDA SI RACCOMANDA DI CONTROLLARE L'ESATTA COMPILAZIONE DI TUTTI I CAMPI POICHE', DOPO L'INVIO, NON SARA' POSSIBILE EFFETTUARE ALCUNA MODIFICA</p>
              <p><br>
                N.B.: Per completare l'invio della domanda &egrave; necessario compilare i seguenti campi:</p>
               
            <form name="presenta_domanda_iscrizione"  action="<%=request.getContextPath()%>/ServletIscrizioneBambino" method="post" onSubmit="return confirm('Presentando la domanda ora non potrai pi&uacute; modificare i tuoi dati.Sei sicuro di volerla presentare? ');">
            
                <input name="chiamante" type="hidden" id="chiamante"
			value="iscrizione_completa">
              <table>
                  <tr>
    				<td colspan="4"><label for="altrifisglinido_1">Selezionare il figlio per il quale si vogliono inserire le informazioni</label>
     				 <br>
                    </td>
      
  					</tr>
 					 <tr>
 				 <td colspan="2">
                 <% if(figli.size()>0)
						{
							out.print("<select name='select_bambini' id='select_bambini' ><option value='null' >Selezionare Bambino</option>");
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
                	<td>Selezionare tipo di servizio desiderato</td>
                    <td>
                    <% if(figli.size()>0)
						{
							out.print("<select name='servizio_selezionato' id='servizio_selezionato' ><option value='null' >Selezionare Orario</option>");
							
							  for (int i=0;i<orari.size();i++)
								  
									  
							  out.print("<option value='"+orari.get(i).getId()+"' >"+orari.get(i).getNome()+"</option>");
							  
						}
						else
						{
							out.print("<em><b>E' necessario inserire un bambino</b></em>");
							return;
						}
						
						%>
                    </select>
                    </td>
                </tr>
                <tr>
                	<td>Inserire le vaccinazioni obbligatorie fatte</td>
                    <td><textarea name="vaccinazioni" id="vaccinazioni" cols="45" rows="5"></textarea></td>
                </tr>
                <tr>
                	<td>Inserire le malattie infettive contratte</td>
                    <td>
                      <label for="malattie_contratte"></label>
                      <textarea name="malattie_contratte" id="malattie_contratte" cols="45" rows="5"></textarea>
                 </td>
                </tr>
                <tr>
                	<td >
                     <input type='submit' value='Invio Domanda Iscrizione'>


           </td>
                </tr>
              </table>
               </form>
               <p><br>
          </p></td>
            
            </tr>
                <!-- Se tutti i dati sono stati compilati correttamente e non è scaduto il bando, il tasto PRESENTA DOMANDA ISCRIZIONE sarà abilitato, altrimenti sarà disabled-->
          </tbody>
        </table></td>
            </tr>
          
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