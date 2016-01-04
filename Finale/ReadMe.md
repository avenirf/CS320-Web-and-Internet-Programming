<li>Description</li>
</ul>

<p>Please deploy your application on CS3, and upload all source files to CSNS. The source files should include all the source code, documentation (optional), and an HTML file <i>final.html</i> which contains a hyperlink to your application on the CS3 server. Note that file uploading will be disabled automatically after the due time, and late submission will <i>not</i> be accepted.</p>

<hr />
<p>CS Department is currently hiring for several job positions. In this exam you are going to develop a web application that helps the department to keep track of the job openings and the job applications.</p>

<p>Your application must use a database to store the data, and you must submit an SQL script file <i>final.sql</i> which contains the statements to create and populate all the tables for the application. You may use JDBC or JSTL SQL or a combination of the two for database access, but in any case, servlets (if you use any) cannot be used to generate HTML content, and no scripting elements are allowed in JSP pages. For simplicity, we&nbsp;assume that all user input are correct so you do not need to do input validation.</p>

<p>The main page of the application displays a list of current job applications, including the applicant&#39;s name, the position he or she is applying for, and the time the application was submitted.</p>

<div style="margin-left: 40px;">
<p><strong>CS Jobs</strong></p>

<p><a href="#">Post A Position</a> | <a href="#">Apply For Position(s)</a></p>

<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th><a href="#">Position</a></th>
			<th><a href="#">Applicant</a></th>
			<th><a href="#">Submitted On</a></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align: center;">Assistant Professor</td>
			<td style="text-align: center;">Jane</td>
			<td style="text-align: center;">2014-03-11 09:01</td>
		</tr>
		<tr>
			<td style="text-align: center;">Assistant Professor</td>
			<td style="text-align: center;">John</td>
			<td style="text-align: center;">2014-03-12 14:22</td>
		</tr>
		<tr>
			<td style="text-align: center;">Part-time Instructor for CS120</td>
			<td style="text-align: center;">Tom</td>
			<td style="text-align: center;">2014-03-05 20:06</td>
		</tr>
		<tr>
			<td style="text-align: center;">Part-time Instructor for CS122</td>
			<td style="text-align: center;">John</td>
			<td style="text-align: center;">2014-03-12 14:22</td>
		</tr>
	</tbody>
</table>
</div>

<p>By default the list is sorted by position, but a user may click on a column header to sort the list by that column. For example, clicking on <em>Applicant</em> will sort the list by applicant&#39;s name:</p>

<div style="margin-left: 40px;">
<p><strong>CS Jobs</strong></p>

<p><a href="#">Post A Position</a> | <a href="#">Apply For Position(s)</a></p>

<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th><a href="#">Position</a></th>
			<th><a href="#">Applicant</a></th>
			<th><a href="#">Submitted On</a></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align: center;">Assistant Professor</td>
			<td style="text-align: center;">Jane</td>
			<td style="text-align: center;">2014-03-11 09:01</td>
		</tr>
		<tr>
			<td style="text-align: center;">Assistant Professor</td>
			<td style="text-align: center;">John</td>
			<td style="text-align: center;">2014-03-12 14:22</td>
		</tr>
		<tr>
			<td style="text-align: center;">Part-time Instructor for CS122</td>
			<td style="text-align: center;">John</td>
			<td style="text-align: center;">2014-03-12 14:22</td>
		</tr>
		<tr>
			<td style="text-align: center;">Part-time Instructor for CS120</td>
			<td style="text-align: center;">Tom</td>
			<td style="text-align: center;">2014-03-05 20:06</td>
		</tr>
	</tbody>
</table>
</div>

<p>Also note that the submission time is displayed in the format of &quot;yyyy-MM-dd hh:mm&quot;.</p>

<p>A user may click on <em>Post A Position</em> to post a new job position:</p>

<p style="margin-left: 40px;"><strong><a href="#">CS Jobs</a> - Job Positions</strong></p>

<ul>
	<li style="margin-left: 40px;">Assistant Professor</li>
	<li style="margin-left: 40px;">Part-time Instructor for CS120</li>
	<li style="margin-left: 40px;">Part-time Instructor for CS122</li>
</ul>

<p style="margin-left: 40px;">New Position: <input name="position" type="text" /> <input name="add" type="submit" value="Add" /></p>

<p>Current job positions should be listed on this page, and new positions can be added using the form at the end of the list. Clicking on <em>CS Jobs</em> should take the user back to the main page.</p>

<p>A user may click on <em>Apply For Position(s)</em> to apply for one or more job positions. For example:</p>

<div style="margin-left: 40px;">
<p><strong><a href="#">CS Jobs</a> - Application</strong></p>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th scope="row" style="text-align: right;">Name:</th>
			<td><input name="name" type="text" /></td>
		</tr>
		<tr>
			<th scope="row" style="text-align: right; vertical-align: top;">Positions:</th>
			<td>
			<div><input name="position" type="checkbox" />Assistant Professor</div>

			<div><input name="position" type="checkbox" />Part-time Instructor for CS120</div>

			<div><input name="position" type="checkbox" />Part-time Instructor for CS122</div>
			</td>
		</tr>
		<tr>
			<th colspan="2" scope="row" style="text-align: right;"><input name="apply" type="submit" value="Apply" /></th>
		</tr>
	</tbody>
</table>
</div>

<p>For simplicity you may assume that applicant names are unique.</p>

<hr />
<p>Grading</p>

<ul>
	<li>Display job applications (20pt)</li>
	<li>Sort job applications (30pt)</li>
	<li>Post positions (20pt)</li>
	<li>Apply for positions (30pt)</li>
	<li><i>final.html</i> is missing or does not have the correct link to your application on the CS3 server (-10pt)</li>
	<li style="font-style: italic;">Only features working correctly on the CS3 server will receive full credit. Partial credit will be given at my discretion.</li>
	<li style="font-style: italic;"><span style="text-decoration: underline;">Please do not modify your files on the CS3 server after the due time. Doing so will be considered cheating.</span></li>
</ul>
