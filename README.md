# openapi3demo
Demo of open API 3 and tooling problems 2022-05-16

There are two projects in the repository, the openapi3demo-server and the openapi3demo-client. 
The server is a simple SpringBoot webservice that specifies four endpoints. Endpoint a and b returns simple POJOs named ClassA and ClassB. Endpoint c returns an interface InterfaceC that both ClassA and ClassB implements. The fourth endpoint returns a list of InterfaceC wich has a list of mixed ClassA and ClassB. Start the SpringBoot app, for by running mvn spring-boot:run from command line. Then should you see http://localhost:8080 with all the links, including /v3/api-docs/ where auto generated swagger file is. 

We converted the Swaggerfile from json to yaml and then it is used to generate client code in the openapi3demo-client. Run the class openapi3demo-client/src/main/java/se/democlient/App.java and you see that the requests to endpoint a and b works just fine. But request to endpoint c results in a Exception like this:
<pre>
Exception in thread "main" javax.ws.rs.ProcessingException:
com.fasterxml.jackson.databind.exc.InvalidTypeIdException: Could not resolve type id 'ClassB' as a subtype of 
`se.democlient.model.InlineResponse200`: Class `se.democlient.model.ClassB` not subtype of
`se.democlient.model.InlineResponse200`
</pre>
To correct this run the post processing in the class openapi3demo-client/src/main/java/se/democlient/PostProcessGeneratedCode.java which will do some search and replace in the generated code. Run the App again and now all the requests are ok. One problem though is that the list of interfaces that is returned from the list endpoint are of type LinkedHashMap and not of InterfaceC. 

