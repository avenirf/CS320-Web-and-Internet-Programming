<li>Description</li>
</ul>

<p>Please deploy your application on CS3, and upload all source files to CSNS. The source files should include all the source code, documentation (optional), and an HTML file <em>hw5.html</em> which contains a hyperlink to your application on the CS3 server. Note that file uploading will be disabled automatically after 11:59PM of the due date, and late submission will not be accepted.</p>

<hr />
<p>[Course Planner] (Extra Credit 80pt)</p>

<p><em>This is an extra credit assignment. You must implement all the required functions in order to receive any credit - no partial credit will be given if you only implement some of the functions. And no late submission will be accepted.</em></p>

<p>Continue to work on the Course Planner application and add the feature that allows users to save their course plans.</p>

<p>1. In the last step of course planning, allow the user to save the course plan. For example:</p>

<div style="margin-left:40px; margin-right:40px">
<p>Here is your course plan:</p>

<p><u>Spring 2014</u></p>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<td style="text-align:center">Code</td>
			<td style="text-align:center">Title</td>
			<td style="text-align:center">Prerequisites</td>
		</tr>
		<tr>
			<td>CS202</td>
			<td>Introduction to Object Oriented Programming</td>
			<td>CS201</td>
		</tr>
	</tbody>
</table>

<p><u>Summer 2014</u></p>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<td style="text-align:center">Code</td>
			<td style="text-align:center">Title</td>
			<td style="text-align:center">Prerequisites</td>
		</tr>
		<tr>
			<td>CS120</td>
			<td>Introduction to Web Site Development</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>CS203</td>
			<td>Programming with Data Structures</td>
			<td>CS202</td>
		</tr>
	</tbody>
</table>

<p><a href="#">Done</a> | <a href="#">Save This Course Plan</a></p>
</div>

<p>The link <em>Save This Course Plan</em> should only be shown if the user is currently logged in; clicking on this link should save the course plan <em>in database</em> and redirects the user to the main page.</p>

<p>2. Add a link <em>Saved Course Plans</em> to the main page of the application. This link is only shown if the user is currently logged in.</p>

<p>3. Clicking on <em>Saved Course Plans</em> should show the list of course plans previously saved by the user. For example:</p>

<p style="margin-left: 40px;">Your Course Plans</p>

<ul>
	<li style="margin-left: 40px;"><a href="#">Saved at 3/1/2014 9:50PM</a></li>
	<li style="margin-left: 40px;"><a href="#">Saved at 2/17/2014 8:05AM</a></li>
	<li style="margin-left: 40px;"><a href="#">Saved at 1/12/2013 11:12AM</a></li>
</ul>

<p>Note that the course plans should be listed in reverse chronological order by the time when the course plan was saved.</p>

<p>4. Clicking on a saved course plan should display the course plan. For example:</p>

<div style="margin-left:40px; margin-right:40px">
<p>Here is your course plan:</p>

<p><u>Spring 2014</u></p>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<td style="text-align:center">Code</td>
			<td style="text-align:center">Title</td>
			<td style="text-align:center">Prerequisites</td>
		</tr>
		<tr>
			<td>CS202</td>
			<td>Introduction to Object Oriented Programming</td>
			<td>CS201</td>
		</tr>
	</tbody>
</table>

<p><u>Summer 2014</u></p>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<td style="text-align:center">Code</td>
			<td style="text-align:center">Title</td>
			<td style="text-align:center">Prerequisites</td>
		</tr>
		<tr>
			<td>CS120</td>
			<td>Introduction to Web Site Development</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>CS203</td>
			<td>Programming with Data Structures</td>
			<td>CS202</td>
		</tr>
	</tbody>
</table>

<p><a href="#">Back</a></p>
</div>

<p>Clicking on the <em>Back</em> link should take the user back to the list of the saved course plans.</p>

<p>For this assignment, in addition to the application source code, please turn in an SQL script file <i>hw5.sql</i> which contains the statements to create and populate all the tables in the database.</p>


</div></div>
