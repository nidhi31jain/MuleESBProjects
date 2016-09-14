<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
   <soap:Body>
      <soap:Fault>
         <soap:Code>
            <soap:Value>soap:Receiver</soap:Value>
         </soap:Code>
         <soap:Reason>
            <soap:Text xml:lang="en">Failed to find entry point for component, the following resolvers tried but failed: [
AnnotatedEntryPointResolver: Component: provider.AuthenticationService@3baeda93 doesn't have any annotated methods, skipping.
CallableEntryPointResolver: Object "provider.AuthenticationService@3baeda93" does not implement required interface "interface org.mule.api.lifecycle.Callable"
MethodHeaderPropertyEntryPointResolver: The required property "method" is not set on the event
ReflectionEntryPointResolver: Could not find entry point on: "provider.AuthenticationService" with arguments: "{class org.apache.cxf.staxutils.DepthXMLStreamReader}"
]</soap:Text>
         </soap:Reason>
      </soap:Fault>
   </soap:Body>
</soap:Envelope>
