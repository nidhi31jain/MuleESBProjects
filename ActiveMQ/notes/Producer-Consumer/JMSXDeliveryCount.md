https://github.com/colorzhang/mule-3.4.0-jetty9/blob/master/transports/jms/src/main/java/org/mule/transport/jms/activemq/ActiveMQJmsConnector.java

protected void applyVendorSpecificConnectionFactoryProperties(ConnectionFactory connectionFactory)
    {
        try
        {
            Method getRedeliveryPolicyMethod = connectionFactory.getClass().getMethod("getRedeliveryPolicy");
            Object redeliveryPolicy = getRedeliveryPolicyMethod.invoke(connectionFactory);
            Method setMaximumRedeliveriesMethod = redeliveryPolicy.getClass().getMethod("setMaximumRedeliveries", Integer.TYPE);
            int maxRedelivery = getMaxRedelivery();
            if (maxRedelivery != REDELIVERY_IGNORE )
            {
                // redelivery = deliveryCount - 1, but AMQ is considering the first delivery attempt as a redelivery (wrong!). adjust for it
                maxRedelivery++;
            }
            setMaximumRedeliveriesMethod.invoke(redeliveryPolicy, maxRedelivery);
        }
        catch (Exception e)
        {
            logger.error("Can not set MaxRedelivery parameter to RedeliveryPolicy " + e);
        }
    }
