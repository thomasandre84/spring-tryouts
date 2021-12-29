# Spring Security with oAuth
## KeyCloak as Authorization Server
Start with Standalone KeyCloak Server or docker image.

* Gen initial Admin User via Web-Console `http://localhost:8080/` or if using docker-image with the described env-variables
  * admin:start123
* Create a new Realm (don't change the master realm)

| Via UI all steps                                                                                                           | Via Realm File |
|----------------------------------------------------------------------------------------------------------------------------|----------------|
| login as admin and Add Realm `appsdeveloperblog`                                                                           | import realm   |
| Create User `developer:start123`                                                                                           | |
| Create Client app: `photo-app-code-flow-client` with openid-connect                                                        | |
| deactivate Direct Access Grants and enter Valid Redirect URIs : `http://localhost:8083/callback` and save                  
| change type from public to confidential (to allow to generate a secret) and save. In Tab Credentials a secret is available 
| FOR PXE Code Grant Type: Go to Advanced Settings, choose Proof Key for Code Exchange .. = S256 and save                    


## Spring Boot App as Resource Server
* Create Project from https://start.spring.io with dependencies:
  * Spring Web
  * Dev Tools
  * oAuth2 Resource Server
