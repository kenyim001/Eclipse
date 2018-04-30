// JavaScript Document 
function doPrint() { 
bdhtml=window.document.body.innerHTML; 
sprnstr="<!--startprint-->"; 
switch(location.hash){
case "#a":
	eprnstr="<!--endprint1-->"; 
	break;
case "#b":
	eprnstr="<!--endprint2-->"; 
	break;
case "#c":
	eprnstr="<!--endprint3-->"; 
	break;
case "#d":
	eprnstr="<!--endprint4-->"; 
	break;
case "#e":
	eprnstr="<!--endprint5-->"; 
	break;
	default:;
}

prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
window.document.body.innerHTML=prnhtml; 
window.print(); 
} 