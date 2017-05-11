<%@page import="com.retaillite.pojo.Queue"%>
<%@page import="java.util.List"%>
<%@page import="com.retaillite.rest.QueueService"%>
<%@page import="com.retaillite.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Lite - Display Queue</title>

<script type="text/javascript">
	function handleClick(id, stat) {
		document.location.href = './servlet/processRequest?QueueId=' + id
				+ '&stat=' + stat;

	}
</script>

</head>

<body>
	<%
		QueueService ser = new QueueService();
		List<Queue> list = ser.getAllRecordsQueue();
	%>
	<table align="center" border="1" cellpadding="1" cellspacing="1">
	<tr align="center">
	<td colspan="4"> Virtual Queue Management System - Retail Lite
	</td>
	</tr>
		<tr>
			<td>Queue #</td>
			<td>Customer Name</td>
			<td>Estimated Time (in mins)</td>
			<td>Select</td>
		</tr>
		<%
			for (Queue q : list) {
		%>
		<tr>
			<td><%=q.getCq_UID()%></td>
			<td><%=q.getCq_Customer_Number()%></td>
			<%
				if (q.getCq_Status().equals("AWAITING")) {
			%>
			<td>10</td>
			<td>
				<button onclick="handleClick('<%=q.getCq_UID()%>','PROCESSING');"
					id="customerId" value="123">Process</button> &nbsp;
				<button
					onclick="javascript:handleClick('<%=q.getCq_UID()%>','CANCEL');">Cancel</button>
			</td>
			<%
				} else {
			%>
			<td>0</td>
			<td>
				<button
					onclick="javascript:handleClick('<%=q.getCq_UID()%>','DONE')">Done</button>
				&nbsp;
				<button
					onclick="javascript:handleClick('<%=q.getCq_UID()%>','CANCEL')">Cancel</button>
			</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>

</body>

</html>