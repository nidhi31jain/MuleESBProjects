
WARN  2016-09-07 18:29:41,769 [main] org.mule.module.ognl.expression.OgnlExpressionEvaluator: OGNL module is deprecated and will be removed in Mule 4.0. Use MEL expressions instead.
WARN  2016-09-07 18:29:44,734 [main] org.mule.transport.http.config.HttpResponseBuilderDefinitionParser: Schema warning: Use of element <response-builder> is deprecated.  HTTP transport is deprecated and will be removed in Mule 4.0. Use HTTP module instead..
Retrieving document at 'http://localhost:9085/ESCS/AircraftEngineInfoService/AircraftEngineInfoService.wsdl'.
Retrieving schema at 'AircraftEngineInfoService_schema1.xsd', relative to 'http://localhost:9085/ESCS/AircraftEngineInfoService/AircraftEngineInfoService.wsdl'.
WARN  2016-09-07 18:29:47,756 [main] org.mule.transport.http.HttpConnector: HTTP transport is deprecated and will be removed in Mule 4.0. Use HTTP module instead.
RESPONSE:::<?xml version="1.0" encoding="UTF-8"?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"><soapenv:Body><a:AircraftEngineInfoResponse xmlns:a="http://safety.test.com/aircraftengineinfo"><a:aircraftEngineInfoDetails><a:aircraftType>B717</a:aircraftType><a:aircraftNumber>009559</a:aircraftNumber><a:aircraftRegistrationNumber>N923AT</a:aircraftRegistrationNumber><a:numberOfPassengerSeats>0</a:numberOfPassengerSeats><a:engineType>BR 715</a:engineType><a:engineThrustRating>0</a:engineThrustRating><a:totalAirframeTimeatTimeofOccurrence>0</a:totalAirframeTimeatTimeofOccurrence><a:totalAirframeTimeatLastMaintenanceActivity>0</a:totalAirframeTimeatLastMaintenanceActivity><a:EngineOne><a:engineManufactorySerialNumber> </a:engineManufactorySerialNumber><a:totalTimeSinceOverhaul>0</a:totalTimeSinceOverhaul><a:totalCycles>0</a:totalCycles></a:EngineOne><a:EngineTwo><a:engineManufactorySerialNumber> </a:engineManufactorySerialNumber><a:totalTimeSinceOverhaul>0</a:totalTimeSinceOverhaul><a:totalCycles>0</a:totalCycles></a:EngineTwo><a:EngineThree><a:engineManufactorySerialNumber> </a:engineManufactorySerialNumber><a:totalTimeSinceOverhaul>0</a:totalTimeSinceOverhaul><a:totalCycles>0</a:totalCycles></a:EngineThree><a:EngineFour><a:engineManufactorySerialNumber> </a:engineManufactorySerialNumber><a:totalTimeSinceOverhaul>0</a:totalTimeSinceOverhaul><a:totalCycles>0</a:totalCycles></a:EngineFour></a:aircraftEngineInfoDetails></a:AircraftEngineInfoResponse></soapenv:Body></soapenv:Envelope>