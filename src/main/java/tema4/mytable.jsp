<%@ page import="java.sql.*" %>
<%
    // Conectarea la baza de date MySQL
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tema_ibm?serverTimezone=UTC", "root", "root");

    // Interogarea bazei de date pentru prima tabela
    Statement stmt1 = conn.createStatement();
    String query1 = "SELECT receiving_country_code, sending_country_code, count FROM letonia";
    ResultSet rs1 = stmt1.executeQuery(query1);
%>
<table>
    <tr>
        <th>Receivening Country Code</th>
        <th>Sending Country Code</th>
        <th>Count</th>
    </tr>
    <% while (rs1.next()) { %>
    <tr>
        <td><%= rs1.getString("receiving_country_code") %></td>
        <td><%= rs1.getString("sending_country_code") %></td>
        <td><%= rs1.getInt("count") %></td>
    </tr>
    <% } %>
</table>
<%
    // Închiderea conexiunii la baza de date pentru prima tabela
    rs1.close();
    stmt1.close();

    // Interogarea bazei de date pentru a doua tabela
    Statement stmt2 = conn.createStatement();
    String query2 = "SELECT * FROM malta";
    ResultSet rs2 = stmt2.executeQuery(query2);
%>
<table>
    <tr>
        <th>Receivening Country Code</th>
        <th>Sending Country Code</th>
        <th>Count</th>
    </tr>
    <% while (rs2.next()) { %>
    <tr>
        <td><%= rs2.getString("receiving_country_code") %></td>
        <td><%= rs2.getString("sending_country_code") %></td>
        <td><%= rs2.getInt("count") %></td>
    </tr>
    <% } %>
</table>
<%
    // Închiderea conexiunii la baza de date pentru a doua tabela
    rs2.close();
    stmt2.close();

    // Interogarea bazei de date pentru a treia tabela
    Statement stmt3 = conn.createStatement();
    String query3 = "SELECT * FROM romania";
    ResultSet rs3 = stmt3.executeQuery(query3);
%>
<table>
    <tr>
        <th>Receivening Country Code</th>
        <th>Sending Country Code</th>
        <th>Count</th>
    </tr>
    <% while (rs3.next()) { %>
    <tr>
        <td><%= rs3.getString("receiving_country_code") %></td>
        <td><%= rs3.getString("sending_country_code") %></td>
        <td><%= rs3.getInt("count") %></td>
    </tr>
    <% } %>
</table>

<%
    // Închiderea conexiunii la baza de date pentru a treia tabela și închiderea conexiunii la baza de date
    rs3.close();
    stmt3.close();
    conn.close();
%>