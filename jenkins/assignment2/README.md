Assignment -02

Topics Covered:  (User Authentication, User Authorization)

Part 1
There is an organization which has 3 teams based on user roles : 
            - Developer
            - DevOps
            - Testing
        
First, you need to create 9 Jenkins jobs. Each job will print its job name, and build number.
            For the Developer, create 3 dummy jobs, visible in the developer view
                job1:- dev-1
                job2:- dev-2
                job3:- dev-3s
            For Testing, create 3 dummy jobs, visible in the testing view
                job1:- test-1
                job2:- test-2
                job3:- test-3
            For DevOps, create 3 dummy jobs, visible in the devops view
                job1:- devops-1
                job2:- devops-2
                job3:- devops-3
                ![alt text](AdminUser.png)    

Users in each team: 
            developer: [ They can see only dev jobs, can build it, see workspace and configure it ]
                - developer-1 
                - developer-2 
                ![alt text](Developer.png)
            testing: [ They can see all test jobs, can build it, see workspace and can configure it, | They can also view dev jobs ]
                - testing-1 
                - testing-2 
                ![alt text](TestingUser.png)
            devops:  [ They can see all devops jobs, can build it, see workspace and can configure it, | They can also view dev and test jobs  ]
                - devops-1 
                - devops-2
            Administration
                -  admin-1 [ It will have full access ]    
                ![alt text](AdminUser.png)    

See what Authorization strategy suits it and implement it.
Also, go through all authorization strategies.

Legacy mode
Project Based
Matrix Based
Role-Based
![alt text](SerurityPage.png)
![alt text](AssignRole.png)
![alt text](ItemRole.png)
![alt text](image.png)
![alt text](MangeRole(1).png)

##################################################################

Part 2
Enable SSO with Google for admin user
![alt text](OSSlogin.png)