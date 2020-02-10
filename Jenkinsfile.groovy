node {
    properties([parameters([choice(choices: ['golden_ami', 'tower ', 'elk ', 'nagiosxi', 'gitlab ', 'nexus ', 'vault'], description: 'What tool would you like to build ?', name: 'TOOL_TO_PROVISION'), choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: '', name: 'AMI_REGION')])])
    stage("Pull Repo"){
        git 'https://github.com/farrukh90/packer.git'
    }
    stage("Build Image"){
        sh "packer version"
        //sh "packer build -var region=${AMI_REGION} tools/jenkins_example.json"
        
    }
    stage("Send Notification to Slack"){
        slackSend channel: 'nagios_alerts', message: 'Golden AMI has been built'
    }
    stage("Send Email"){
        mail bcc: '', body: '''Hello , your AMI is ready in us-east-1''', cc: '', from: '', replyTo: '', subject: 'golden ami has been built', to: 'maksatabakirov1@gmail.com'
    }
}
