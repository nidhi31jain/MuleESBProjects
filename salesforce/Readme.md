
STEP 1:
=======
create a sales force account

STEP 2:
=======
verify account and create user /password
login in to account > click view profile >reset Security Token >copy Token
https://ap2.lightning.force.com/one/one.app#/settings/personal/ResetApiToken/home?t=1472926552062

Security token - Sign into link:http://developer.force.com/, click your name  in the upper right corner, then click Setup > My Personal Information >  Reset Security Token. Then, click Reset My Security Token. Salesforce sends your security token via email to your registered email address.

STEP 3:
========
format
PTeXLR1RJvI6pN7EV8TComtC

CHeck mail and use in mule.

Consumer key and Secret - If you are using the Salesforce connector to access an OAuth API, you also need a consumer key and secret. Refer to the detailed documentation on how to use the Salesforce connector to access an OAuth API. 


STEP 4:
=======
Register for a Salesforce account. 

    After completing the registration, click the link in the confirmation email to set a password, then log in to Salesforce Developer Edition.

    Configure your Salesforce account to be accessed from a remote application using OAuth. On the Salesforce Developer Edition UI, click the Setup link on the top rigth of the screen, next to your user name. In the Quick link section Manage Apps

    Look for the Connected Apps section, and click the New button next to it to connect a new app

    Fill in the form for your application, be sure to enable the checkbox labeled Enable OAuth Settings. Then provide a callback URL and list the permissions that your API should obtain.

    Click Save , then, on the following page, note the consumer key and consumer secret. You will use these values to configure the connector to access Salesforce. 
    
    

    

