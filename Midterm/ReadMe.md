<li>Description</li>
</ul>

<p>Please deploy your application on CS3, and upload all source files to CSNS. The source files should include all the source code, documentation (optional), and an HTML file <i>midterm.html</i> which contains a hyperlink to your application on the CS3 server. Note that file uploading will be disabled automatically after the due time, and late submission will <i>not</i> be accepted.</p>

<p>&nbsp;</p>

<hr />
<p>&nbsp;</p>

<p>In this exam you are going to develop an online To-do List. Your application must use the MVC architecture discussed in&nbsp;class, and in particular:</p>

<p>&nbsp;</p>

<ul>
	<li>Servlets cannot be used to generate HTML content.</li>
	<li>No scripting elements are allowed in JSP pages.</li>
</ul>

<p>&nbsp;</p>

<p>A To-do list contains a number of <em>tasks</em>, and each task consists of a message and a due date. The main page of your application should display the tasks that are not completed yet. For example:</p>

<p>&nbsp;</p>

<p style="margin-left: 40px;">Current Tasks | <a href="#">Completed Tasks</a></p>

<p>&nbsp;</p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th scope="col">Message</th>
			<th scope="col">Due Date</th>
			<th scope="col">Operations</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Buy grocery</td>
			<td>02/22/2014</td>
			<td style="text-align: center;"><a href="#">Completed</a> | <a href="#">Remove</a></td>
		</tr>
		<tr style="background-color:#FF0000;">
			<td>watch the lego movie</td>
			<td>02/16/2014</td>
			<td style="text-align: center;"><a href="#">Remove</a></td>
		</tr>
		<tr style="background-color:#FFFF00;">
			<td>Meeting with Dr. Pamula</td>
			<td>02/20/2014</td>
			<td style="text-align: center;"><a href="#">Completed</a> | <a href="#">Remove</a></td>
		</tr>
		<tr>
			<td><input name="message" type="text" /></td>
			<td><input name="duedate" type="text" /></td>
			<td style="text-align: center;"><input name="add" type="submit" value="Add" /></td>
		</tr>
	</tbody>
</table>
</div>

<p>&nbsp;</p>

<p>Tasks that are expired (i.e. past the due date) are displayed with a red background. Tasks that are due today or tomorrow are displayed with a yellow background. Note that you may not hard-code today&#39;s date in the application.</p>

<p>&nbsp;</p>

<p>New tasks can be added to the list using the form at the bottom of the table. Dates are entered and displayed in the form of &quot;MM/dd/yyyy&quot;, e.g. <tt>02/19/2014</tt>.</p>

<p>&nbsp;</p>

<p>Clicking on the <em>Remove</em> link of a task will remove the task from the application.</p>

<p>&nbsp;</p>

<p>Clicking on the <em>Completed</em> link of a task will mark the task as completed (note that there is no <em>Completed</em> link for expired tasks). The application will record the date when the task is completed, and remove the task from the list of current tasks. Clicking on <em>Completed Tasks</em> will show the completed tasks. For example:</p>

<p>&nbsp;</p>

<p style="margin-left: 40px;"><a href="#">Current Tasks</a> | Completed Tasks</p>

<p>&nbsp;</p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th scope="col">Message</th>
			<th scope="col">Due Date</th>
			<th scope="col">Completion Date</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>cs320 homework 3</td>
			<td>02/21/2014</td>
			<td style="text-align: center;">02/16/2014</td>
		</tr>
		<tr>
			<td>Prepare for CS320 midterm</td>
			<td>02/19/2014</td>
			<td style="text-align: center;">02/18/2014</td>
		</tr>
	</tbody>
</table>
</div>

<p>&nbsp;</p>

<p>Again, all dates are in the form of &quot;MM/dd/yyyy&quot;. Clicking on <em>Current Tasks</em> should take the user back to the list of current tasks.</p>

<p>&nbsp;</p>

<hr />
<p>&nbsp;</p>

<p>Grading</p>

<p>&nbsp;</p>

<ul>
	<li>Display current tasks (40pt)</li>
	<li>Display completed tasks (10pt)</li>
	<li>Add tasks (20pt)</li>
	<li>Remove tasks (15pt)</li>
	<li>Complete tasks (15pt)</li>
	<li><i>midterm.html</i> is missing or does not have the correct link to your application on the CS3 server (-5pt)</li>
	<li style="font-style: italic;">Only features working correctly on the CS3 server will receive full credit. Partial credit will be given at my discretion.</li>
	<li style="font-style: italic;"><span style="text-decoration: underline;">Please do not modify your files on the CS3 server after the due time. Doing so will be considered cheating.</span></li>
</ul>
