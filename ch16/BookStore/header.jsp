<%@page pageEncoding="GBK" contentType="text/html; charset=GBK"%>
<%@taglib uri="/tags/struts-bean" prefix="bean"%>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@taglib uri="/tags/struts-logic" prefix="logic"%>
<style type="text/css">
<!--
.menu {
	font-family: "��������";
	font-size: 9pt;
	background-color: #006699;
	border: 1px dashed #000066;
	color: #CCCCCC;
}
#header a:link {
	font-family: "����";
	font-size: 9pt;
	color: #CCCCCC;
}
#header a:visited {
	font-family: "����";
	font-size: 9pt;
	color: #CCCCCC;
}
#header a:hover {
	font-family: "����";
	font-size: 9pt;
	color: #FFFFFF;
}
#header a:active {
	font-family: "����";
	font-size: 9pt;
	color: #FFFFFF;
}
-->
</style>
<div align="center">
	<table width="759" border="0" cellspacing="0" cellpadding="0" id="header">
		<!--������һ����һ��ͼƬ-->
		<tr>
			<td>
				<img src="image/title.jpg">
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="text">
					<tr>
						<!--����ҳ������-->
						<td width="120" align="center" class="menu">
							<a href="index.jsp"><bean:message key="menu.frontPage" /></a>
						</td>
						<!--��ͼ�����������-->
						<td width="120" align="center" class="menu">
							<a href="SearchBook.do"><bean:message key="menu.search" /></a>
						</td>
						<!--ֻ�е�user�������ʱ����ʾ�������ݣ���ֻ���û���¼��Ż�����������-->
						<logic:present name="user">
							<!--���������ϡ�����-->
							<td width="120" align="center" class="menu">
								<a href="modify.jsp"><bean:message key="menu.personal" /> </a>
							</td>
							<!--�����ﳵ������-->
							<td width="120" align="center" class="menu">
								<a href="ViewCart.do"> <bean:message key="menu.shoppingCart" /></a>
							</td>
							<!--��ע��������-->
							<td width="120" align="center" class="menu">
								<a href="Logout.do"><bean:message key="menu.logout" /></a>
							</td>
						</logic:present>
						<td class="menu">
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	