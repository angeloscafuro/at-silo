<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fattura Mensile</title>
<!-- Contents -->
	<meta name="author" content="Luca Di Costanzo" />
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Content-Language" content="it" />
	<meta name="description" content="Sistema @silo per la gestione Asilo Nido Aziendale "Roberto Mazzetti - Università Degli Studi Di Salerno/>	
    <meta name="keywords" content="@asilo atsilo at_silo università degli studi di salerno fisciano asilo nido aziendale" />
<!-- imCustomHead -->
	<meta http-equiv="Expires" content="0" />
	<meta name="Resource-Type" content="document" />
	<meta name="Distribution" content="global" />
	<meta name="Robots" content="index, follow" />
	<meta name="Revisit-After" content="21 days" />
	<meta name="Rating" content="general" />
	<!-- Others -->
	<meta http-equiv="ImageToolbar" content="False" />
	<meta name="MSSmartTagsPreventParsing" content="True" />
	<link rel="Shortcut Icon" href="atsilo_files/favicon.ico" type="image/x-icon" />
    <!-- Res -->
	<link type="text/css" href="atsilo_files/template.css" rel="stylesheet">
	<link type="text/css" href="atsilo_files/unisa.css" rel="stylesheet">
	<link type="text/css" href="atsilo_files/personalizzazioni.css" rel="stylesheet"><!-- Stili personalizzati -->
</head>


<body>
<table class="header" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td align="left"><img src="atsilo_images/testata.jpg" align="middle" alt="" border="0"></td>
</tr>
</tbody></table>
<table class="percorsopagina1" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td align="center" height="0" nowrap="true" class="menuprimoselhbar"><a href="index_genitore">Home</a></td>
<td align="center" height="0" nowrap="true" class="menuprimohbar"><a href="forum/index.html">Forum</a></td>
<td align="center" height="0" nowrap="true" class="menuprimohbar"><a href="forum/ricerca_utente.html">Ricerca utente</a></td>
<td align="center" height="0" nowrap="true" class="menuprimohbar"><a href="faq.html">FAQ</a></td>
</tr>
</tbody></table>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td class="breadcrumb " align="left"><p> </a></p>
  <p>&nbsp;</p></td>
</tr>
</tbody></table>
<table class="colonnasx" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td valign="top" class="colonnasx" width="209">
<table class="lineadivisoria" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td class="top_menu_sx">
<div class="user">

<p></p>
</div>
<div class="vista_menu">
</div>
</td>
</tr>
</tbody></table>
<table class="lineadivisoria" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td align="left" class="menuprimosel">&nbsp;<b>'Area Utente</b></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="dati_account.html">Dati Account</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="dati_bambino.html">Dati Bambino</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="logout.jsp">Logout</a></td>
</tr>
</tbody></table>
<table class="lineadivisoria" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
</tr>
</tbody></table>
<table class="lineadivisoria" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td align="left" class="menuprimosel">&nbsp;<b>Gestione Pagamenti</b></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="storico_pagamenti.html.html">Storico Pagamenti</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="fattura_mensile.html">Fattura Mensile</a></td>
</tr>
</tbody></table>
<table class="lineadivisoria" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
</tr>
</tbody></table>
<table class="lineadivisoria" width="100%" cellspacing="0" cellpadding="0" border="0">
<tbody><tr>
<td align="left" class="menuprimosel">&nbsp;<b>Gestione Servizi</b></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="rinuncia_servizio.html">Rinuncia Servizio</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="servizi_attivi.html">Servizi Attivi</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="modifica_orario.html">Modifica Orario</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="modifica_pasti.html">Modifica Pasti</a></td>
</tr>
<tr>
<td class="menusecondo">&nbsp;<a class="linkmenusecondo" href="storico_attivita.html">Storico Attività</a></td>
</tr>
</tbody></table>

<br />
<img width="209" border="0" alt="" height="1" src="atsilo_images/clearpixel.gif" /></td><td class="content" valign="top" bgcolor="#ffffff">
<table width="100%">
<tbody><tr>
<td>
<div class="titolopagina"><!-- Benvenuto XXX --></div>
</td><td class="fasciadxvariabile"></td>
</tr>
</tbody></table>
<br />
<fieldset>
<legend>Fattura MESE ANNO</legend>
<div style="margin-left: 10px;">
<b>Nome</b> : NOME
<br /><b>Cognome</b> : COGNOME
<br /><b>Cod.Fiscale</b> : CODICE FISCALE
<br /><b>Indirizzo</b> : INDIRIZZO
<br /><br /><b>Numero Transazione</b> : NUMERO
<br /><b>Scandeza Pagamento</b> : SCADENZA
<br /><br /><b>Fascia Oraria di appartenenza</b> : FASCIA
<br /><b>Numero Transazione</b> : ID 
<br /><b>Importo retta di base</b> : IMPORTO
<br /><b>Totale servizi Extra</b> : EXTRA

<br /><br /><b>IMPORTO TOTALE</b> : TOTALE
</div>
</fieldset>


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
<td class="bottom" width="209">&nbsp;2012 © Unisa</td><td align="right" class="bottom"></td>
</tr>
</tbody></table>


</body>
</html>