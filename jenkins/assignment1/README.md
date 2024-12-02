Assignment 01
Topics Covered: (Shell Scripting, Git, Freestyle Job, Parameters, Upstream/Downstream, Slack + Email Notification)

Part 1:-

Create a Jenkins job via which you will be able to perform the below operations & if any of the steps fail a Slack and Email notification should be sent:
Create a branch
List all branches
Merge one branch with another branch
Rebase one branch with another branch
Delete a branch

![alt text](MainPageJob1.png)
![alt text](Execute_shell1.png) 
![alt text](Execute_shell2.png) 
![alt text](Execute_shell3.png)
![alt text](EmailConfigureJob1.png)
![alt text](Slack_NotificationJob1.png)
![alt text](ConsoleOutputJob1.png)

###########################################################################

Part 2:-

Create a Jenkins job that takes input parameter string <Ninja Name> and it should - 

Create a file:-

Add content in the file "<Ninja Name> from DevOps Ninja"

![alt text](MainPagePart2.png)
![alt text](ExecuteShellJob2.png)     
![alt text](EmailConfigureJob2.png)
![alt text](Slack_NotificationJob2.png)
![alt text](ConsoleOutputJob2.png)
![alt text](OutputPagePart2.png)
 	

Create another Jenkins job that should -
Publish the file content created in job 1 using a web server

![alt text](ExecuteShellJob3.png)
![alt text](EmailConfigureJob3.png)
![alt text](Slack_NotificationJob3.png)
![alt text](ConsoleOutputJob3.png)
![alt text](<Screenshot 2024-11-26 at 9.52.47 PM.png>)
      
Configurations should be such that - 
The second job must be triggered automatically only after completing the first job successfully.
If any steps fail, a Slack and Email notification should be sent.
If all jobs run successfully, Slack and Email notifications should be sent.
![alt text](SlackOutput.png)