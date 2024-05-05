def call(String tag="mahmoud:latest"){
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                sh"""
                
                docker build -f dockerfile . -t ${USERNAME}/${tag}
                docker login -u ${USERNAME} -p ${PASSWORD}
                docker push ${USERNAME}/${tag}
                """
                }
  
}
