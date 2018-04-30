<%@page pageEncoding="GBK" contentType="text/html; charset=GBK"%>
<%@taglib uri="/tags/struts-bean" prefix="bean"%>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@taglib uri="/tags/struts-logic" prefix="logic"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<title><bean:message key="index.title" /></title>
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<%//��session��ȡ���û���Ϣ
			bookstore.database.Userinfo user = (bookstore.database.Userinfo) session
					.getAttribute("user");

			//��ѯ�õ��������ֻ���Ӧ�������>0����ͼ��
			org.hibernate.Session dbSession = bookstore.database.HibernateUtil
					.currentSession();
			bookstore.database.HibernateUtil.beginTransaction();
			org.hibernate.Query query = dbSession
					.createQuery("from Bookinfo as b where b.remaining>0 order by b.id desc");

			//�˴β�ѯ���ֻȡ3�����
			query.setMaxResults(3);
			java.util.List result = query.list();
			bookstore.database.HibernateUtil.commitTransaction();

			//����ѯ�����Ľ��������һ�����������request��Χ��
			request.setAttribute("books", result);
			request.setAttribute("newest", result.get(0));

			// ��ѯ�õ���ǰ�û������ж���
			bookstore.database.HibernateUtil.beginTransaction();
			query = dbSession
					.createQuery("from Order as o where o.userinfo=:userinfo order by o.id desc");
			query.setParameter("userinfo", user);

			//�˴β�ѯ���ֻȡ4�����
			query.setMaxResults(4);
			result = query.list();
			bookstore.database.HibernateUtil.commitTransaction();

			//����ѯ�����Ľ����������request��Χ�ڡ�
			request.setAttribute("orders", result);

		%>
	<!--�����Java Script���붨������������-->
	<script language="javascript">
<!--
	//�¿�һ�����ڣ���ʾ������ϸ��Ϣ
	function orderDetail(id) {
		window.open("OrderDetail.do?id=" + id, "", "location=no,toolbar=no,status=no,height=250,width=500");
	}
	//�¿�һ�����ڣ���ʾͼ����ϸ��Ϣ
	function bookDetail(id) {
		window.open("BookDetail.do?id=" + id, "", "location=no,toolbar=no,status=no,height=250,width=500");
	}
//-->
</script>
	<body>
		<!--�����ļ�header.jsp������ʾҳ���ϲ�����-->
		<%@include file="header.jsp"%>
		<table width="759" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="200" valign="top">
					<br>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!--���⣺���û���Ϣ��-->
							<td class="title">
								<bean:message key="index.userinfo" />
							</td>
						</tr>
						<tr>
							<td valign="bottom" class="body">
								<br>
								<!--ֻ�е�user�������ʱ����ʾ�������ݣ���ֻ���û���¼��Ż�����������-->
								<logic:present name="user">
									<div align="center" class="text">
										<!--�ı�������ӭ���٣���-->
										<bean:message key="index.welcome" />
										<!--д��user�����username����-->
										<bean:write name="user" property="username" />
										<hr style="height:1pt" width="90%" />
										<!--���޸����ϡ�����-->
										<html:link href="modify.jsp">
											<bean:message key="index.modify" />
										</html:link>
										<!--��ע��������-->
										<html:link href="Logout.do">
											<bean:message key="index.logout" />
										</html:link>
									</div>
								</logic:present>
								<html:form action="Login.do">
									<!--ֻ�е�user���󲻴���ʱ����ʾ�������ݣ���ֻ���û���δ��¼ʱ�Ż�����������-->
									<logic:notPresent name="user">
										<div align="center" class="text">
											<!--�ı������û�������-->
											<bean:message key="index.username" />
											<!--�ı���property������ΪuserName-->
											<html:text property="userName" styleClass="login" />
											<br>
											<!--�ı��������룺��-->
											<bean:message key="index.password" />
											<!--�ı���property������Ϊpassword��-->
											<html:password property="password" styleClass="login" />
											<br>
											<!--�����ע�ᡱ����-->
											<html:link href="register.jsp">
												<bean:message key="index.register" />
											</html:link>
											<!--��ʾ������ת������ҳ��ʱ��ActionMessage�����װ����ʾ��Ϣ-->
											<html:errors property="inputErrors" />
											<hr style="height:1pt" width="90%" />

											<!--����¼����ť-->
											<html:submit styleClass="button">
												<bean:message key="index.login" />
											</html:submit>
											<!--�����á���ť-->
											<html:reset styleClass="button">
												<bean:message key="index.reset" />
											</html:reset>
										</div>
									</logic:notPresent>
								</html:form>
							</td>
						</tr>
					</table>
					<!--ֻ�е�user�������ʱ����ʾ�������ݣ���ֻ���û���¼��Ż�����������-->
					<logic:present name="user">
						<br>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<!--���⣺��������Ϣ��-->
								<td class="title">
									<bean:message key="index.order" />
								</td>
							</tr>
							<tr>
								<td class="body">
									<!--������Ϣ������Ϊ����-->
									<marquee direction="up" scrollamount="2">
										<!--ȡ��֮ǰ������request��Χ�ڵ�orders�����������-->
										<!--name����Ϊ���ϵ�bean���ƣ�scope��bean��������-->
										<!--id��������Ϊ��page����bean���߽ű����������ơ���������һ���α꣬�ڱ������������Ǽ�¼�ż����е�ǰԪ�ص�����-->
										<logic:iterate id="anOrder" name="orders" scope="request">
											<!--id���¶���ı��������ơ�name��Ŀ��bean�����ƣ�property��name���Զ����bean���������ƣ����ڶ����µ�bean-->
											<bean:define id="book" name="anOrder" property="bookinfo" />
											<!--�����¿�һ�����ڵ����ӣ��ô���������ʾĳ������������-->
											<!--bean:write��ǩ��name��Ҫ����������ʾ��bean���ƣ�property��Ҫ��ʾ��������-->
											<!--bean:write��ǩ�н��¶����bean����book��bookName����ֵ��ӡ����-->
											<a href='javascript:orderDetail(<bean:write name="anOrder" property="id" />)'> <bean:write name="book" property="bookName" /> <span class="date"> (<bean:write name="anOrder" property="orderdate" />) </span> </a>
											<br>
										</logic:iterate>
									</marquee>
								</td>
							</tr>
						</table>
					</logic:present>
				</td>
				<td align="center" valign="top">
					<br>
<table width="97%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<!--���⣺�������Ƽ���-->
		<td class="title">
			<bean:message key="index.newbook" />
		</td>
	</tr>
	<tr>
		<td class="body">
			<br>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="text">
				<tr>
					<td width="18%" rowspan="6" align="center" valign="top">
						<!--�����¿�һ�����ڵ����ӣ��ô�����ʾĳ��ͼ�������-->
						<a href='javascript:bookDetail(<bean:write name="newest" property="id" />)'> <!--������ֵ�ǿյ�ʱ�����ʾ���������--> <logic:notEmpty name="newest" property="picture">
								<img border="0" src='upload/<bean:write name="newest" property="picture"/>'>
							</logic:notEmpty> <!--������ֵΪ�յ�ʱ�����ʾ���������--> <logic:empty name="newest" property="picture">
								<img border="0" src="image/nopic.gif">
							</logic:empty> </a>
					</td>
					<!--�ı�������������-->
					<td width="82%" height="25">
						<bean:message key="orderdetail.bookname" />
						<bean:write name="newest" property="bookName" />
					</td>
				</tr>
				<tr>
					<!--�ı��������ߣ���-->
					<td height="25">
						<bean:message key="index.writer" />
						<bean:write name="newest" property="writer" />
					</td>
				</tr>
				<tr>
					<!--�ı����������磺��-->
					<td height="25">
						<bean:message key="index.publisher" />
						<bean:write name="newest" property="publisher" />
					</td>
				</tr>
				<tr>
					<!--�ı������۸񣺡�-->
					<td height="25">
						<bean:message key="index.price" />
						<bean:write name="newest" property="price" />
					</td>
				</tr>
				<tr>
					<td height="25">
						<hr style="height:1pt " width="90%" align="left">
						<bean:write name="newest" property="intro" />
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<hr style="height:1pt " width="90%">
					</td>
				</tr>
				<!--����һ�����ϣ��˴�����ʾbooks�����е���Ϣ������ѯ�õ���ͼ����Ϣ-->
				<logic:iterate id="aBook" name="books" scope="request">
					<tr>
						<td colspan="2" height="20">
							<a href='javascript:bookDetail(<bean:write name="aBook" property="id" />)'> <bean:write name="aBook" property="bookName" /> <bean:write name="aBook" property="writer" /> <bean:write name="aBook" property="publisher" /> </a>
						</td>
					</tr>
				</logic:iterate>
				<!--���ӣ�����ͼ���������-->
				<tr>
					<td colspan="2" align="right">
						<a href="SearchBook.do">����>></a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
				</td>
			</tr>
		</table>
		<%@include file="footer.jsp"%>
	</body>
</html>
