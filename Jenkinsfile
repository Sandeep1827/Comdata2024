pipeline{
    agent any
    stages{
        stage("Build"){
        steps{
           echo("build the project") 
             }
        }
        stage("Unit"){
        steps{
           echo("Run Unit test cases") 
             }
        }
        stage("Deploy to Dev"){
        steps{
           echo("Dev deployement") 
             }
        }
        stage("Deploy to QA"){
        steps{
           echo("QA deployement") 
             }
        }
         stage("Run my automation Regression test cases"){
        steps{
           echo("Regression test cases") 
             }
        }
         stage("Deploy to STage"){
        steps{
           echo("Stage deployement") 
             }
        }
         stage("Run my automation Sanity test cases"){
        steps{
           echo("Sanity test cases") 
             }
        }
        stage("Deploy to Prod"){
        steps{
           echo("Prod deployement") 
             }
        }   
    }
}