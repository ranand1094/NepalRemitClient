package com.crosspay.nepalRemit;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.crosspay.nepalRemitDTO.RequestDTO;
import com.crosspay.nepalRemitDTO.ResponseDTO;

public class SendTransaction {
 		  
		  private static Document parseXmlFile(String in) {
		    try {
		      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		      DocumentBuilder db = dbf.newDocumentBuilder();
		      InputSource is = new InputSource(new StringReader(in));
		      return db.parse(is);
		    } catch (ParserConfigurationException e) {
		      throw new RuntimeException(e);
		    } catch (SAXException e) {
		      throw new RuntimeException(e);
		    } catch (IOException e) {
		      throw new RuntimeException(e);
		    } 
		  }
		  
		  public ResponseDTO getXMCreateTxn4Oasis(RequestDTO requestDTO) {
		    ResponseDTO ResponseDTO = new ResponseDTO();
		    String xmlInput = "";
		    String outputString = "";
		    try {
		      String responseString = "";
		      URL url = new URL(requestDTO.getUrl()); //url to be provided
		      URLConnection connection = url.openConnection();
		      HttpURLConnection httpConn = (HttpURLConnection)connection;
		      ByteArrayOutputStream bout = new ByteArrayOutputStream();
		      
		      xmlInput = 		      
		      "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cli=\"ClientWebService\">"
		      +"<soapenv:Header/>"
		      +"<soapenv:Body>"
		      +"<cli:SendTransaction>"
		      +"<cli:AGENT_CODE>"+requestDTO.getAgentCode()+"A</cli:AGENT_CODE>"
		      +"<cli:USER_ID>"+requestDTO.getUserID()+"</cli:USER_ID>"
		      +"<cli:AGENT_SESSION_ID>"+requestDTO.getAgentSessionID()+"</cli:AGENT_SESSION_ID>"
		      +"<cli:AGENT_TXNID>"+requestDTO.getAgentTxnID()+"</cli:AGENT_TXNID>"
		      +"<cli:LOCATION_ID>"+requestDTO.getLocationID()+"</cli:LOCATION_ID>"
		      +"<cli:SENDER_FIRST_NAME>"+requestDTO.getSenderFirstName()+"</cli:SENDER_FIRST_NAME>"
		      +"<cli:SENDER_MIDDLE_NAME>"+requestDTO.getSenderMiddleName()+"</cli:SENDER_MIDDLE_NAME>"
		      +"<cli:SENDER_LAST_NAME>"+requestDTO.getSenderLastName()+"</cli:SENDER_LAST_NAME>"
		      +"<cli:SENDER_GENDER>"+requestDTO.getSenderGender()+"</cli:SENDER_GENDER>"
		      +"<cli:SENDER_ADDRESS>"+requestDTO.getSenderAddress()+"</cli:SENDER_ADDRESS>"
		      +"<cli:SENDER_CITY>"+requestDTO.getSenderCity()+"</cli:SENDER_CITY>"
		      +"<cli:SENDER_COUNTRY>"+requestDTO.getSenderCountry()+"</cli:SENDER_COUNTRY>"
		      +"<cli:SENDER_ID_TYPE>"+requestDTO.getSenderIDType()+"</cli:SENDER_ID_TYPE>"
		      +"<cli:SENDER_ID_NUMBER>"+requestDTO.getSenderIDNumber()+"</cli:SENDER_ID_NUMBER>"
		      +"<cli:SENDER_ID_ISSUE_DATE>"+requestDTO.getSenderIDIssueDate()+"</cli:SENDER_ID_ISSUE_DATE>"
		      +"<cli:SENDER_ID_EXPIRE_DATE>"+requestDTO.getSenderIDExpiryDate()+"</cli:SENDER_ID_EXPIRE_DATE>"
		      +"<cli:SENDER_DATE_OF_BIRTH>"+requestDTO.getSenderDateOfBirth()+"</cli:SENDER_DATE_OF_BIRTH>"
		      +"<cli:SENDER_MOBILE>"+requestDTO.getSenderMobile()+"</cli:SENDER_MOBILE>"
		      +"<cli:SOURCE_OF_FUND>"+requestDTO.getSourceOfFund()+"</cli:SOURCE_OF_FUND>"
		      +"<cli:SENDER_OCCUPATION>"+requestDTO.getSenderOccupation()+"</cli:SENDER_OCCUPATION>"
		      +"<cli:SENDER_NATIONALITY>"+requestDTO.getSenderNationality()+"</cli:SENDER_NATIONALITY>"
		      +"<cli:RECEIVER_FIRST_NAME>"+requestDTO.getReceiverFirstName()+"</cli:RECEIVER_FIRST_NAME>"
		      +"<cli:RECEIVER_MIDDLE_NAME>"+requestDTO.getReceiverMiddleName()+"</cli:RECEIVER_MIDDLE_NAME>"
		      +"<cli:RECEIVER_LAST_NAME>"+requestDTO.getReceiverLastName()+"</cli:RECEIVER_LAST_NAME>"
		      +"<cli:RECEIVER_ADDRESS>"+requestDTO.getReceiverAddress()+"</cli:RECEIVER_ADDRESS>"
		      +"<cli:RECEIVER_CITY>"+requestDTO.getReceiverCity()+"</cli:RECEIVER_CITY>"
		      +"<cli:RECEIVER_COUNTRY>"+requestDTO.getReceiverCountry()+"</cli:RECEIVER_COUNTRY>"
		      +"<cli:RECEIVER_CONTACT_NUMBER>"+requestDTO.getReceiverContactNumber()+"</cli:RECEIVER_CONTACT_NUMBER>"
		      +"<cli:RELATIONSHIP_TO_BENEFICIARY>"+requestDTO.getRelationship2Bene()+"</cli:RELATIONSHIP_TO_BENEFICIARY>"
		      +"<cli:PAYMENT_MODE>"+requestDTO.getPaymentMode()+"</cli:PAYMENT_MODE>"
		      +"<cli:BANK_ID>"+requestDTO.getBankID()+"</cli:BANK_ID>"
		      +"<cli:BANK_NAME>"+requestDTO.getBankName()+"</cli:BANK_NAME>"
		      +"<cli:BANK_BRANCH_NAME>"+requestDTO.getBankBranchName()+"</cli:BANK_BRANCH_NAME>"
		      +"<cli:BANK_ACCOUNT_NUMBER>"+requestDTO.getBankAccountNumber()+"</cli:BANK_ACCOUNT_NUMBER>"
		      +"<cli:CALC_BY>"+requestDTO.getCalcBy()+"</cli:CALC_BY>"
		      +"<cli:TRANSFER_AMOUNT>"+requestDTO.getTransferAmount()+"</cli:TRANSFER_AMOUNT>"
		      +"<cli:OURSERVICE_CHARGE>"+requestDTO.getOutServiceCharge()+"</cli:OURSERVICE_CHARGE>"
		      +"<cli:TRANSACTION_EXCHANGERATE>"+requestDTO.getTxnExchangeRate()+"</cli:TRANSACTION_EXCHANGERATE>"
		      +"<cli:SETTLEMENT_DOLLARRATE>"+requestDTO.getSettlementDollarRate()+"</cli:SETTLEMENT_DOLLARRATE>"
		      +"<cli:PURPOSE_OF_REMITTANCE>"+requestDTO.getPurposeOfRemittance()+"</cli:PURPOSE_OF_REMITTANCE>"
		      +"<cli:AUTHORIZED_REQUIRED>"+requestDTO.getAuthRequired()+"</cli:AUTHORIZED_REQUIRED>"
		      +"<cli:SIGNATURE>"+requestDTO.getSignature()+"</cli:SIGNATURE>"
		      +"</cli:SendTransaction>"
		      +"</soapenv:Body>"
		      +"</soapenv:Envelope>" ;
		      
		      System.out.println("Request XML :- \n"+xmlInput);
		      
		      byte[] buffer = new byte[xmlInput.length()];
		      buffer = xmlInput.getBytes();
		      bout.write(buffer);
		      byte[] b = bout.toByteArray();
		      httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
		      httpConn.setRequestMethod("POST");
		      httpConn.setDoOutput(true);
		      httpConn.setDoInput(true);
		      OutputStream out = httpConn.getOutputStream();
		      out.write(b);
		      out.close();
		      InputStreamReader isr = new InputStreamReader(
		          httpConn.getInputStream());
		      BufferedReader in = new BufferedReader(isr);
		      
		      while ((responseString = in.readLine()) != null)
		        outputString = String.valueOf(outputString) + responseString; 
		
		      System.out.println("Response XML :- \n"+outputString);
		      
		      Document document = parseXmlFile(outputString);
		      String respCode = document.getElementsByTagName("CODE").item(0).getTextContent();
		      ResponseDTO.setCode(respCode);
		      
		      String agentSessionID = document.getElementsByTagName("AGENT_SESSION_ID").item(0).getTextContent();
		      ResponseDTO.setAgentSessionID(agentSessionID);
		      
		      String message = document.getElementsByTagName("MESSAGE").item(0).getTextContent();
		      ResponseDTO.setMessage(message);
		      
		      String pinNo = document.getElementsByTagName("PINNO").item(0).getTextContent();
		      ResponseDTO.setPinNo(pinNo);
		      
		      String agentTxnID = document.getElementsByTagName("AGENT_TXNID").item(0).getTextContent();
		      ResponseDTO.setAgentTxnID(agentTxnID);
		      
		      String collectAmt = document.getElementsByTagName("COLLECT_AMT").item(0).getTextContent();
		      ResponseDTO.setCollectAmt(collectAmt);
		      
		      String collectCcy = document.getElementsByTagName("COLLECT_CURRENCY").item(0).getTextContent();
		      ResponseDTO.setCollectCcy(collectCcy);
		      
		      String exRate = document.getElementsByTagName("EXCHANGE_RATE").item(0).getTextContent();
		      ResponseDTO.setExRate(exRate);
		      
		      String serviceCharges = document.getElementsByTagName("SERVICE_CHARGE").item(0).getTextContent();
		      ResponseDTO.setServiceCharges(serviceCharges);
		      
		      String payoutAmount = document.getElementsByTagName("PAYOUTAMT").item(0).getTextContent();
		      ResponseDTO.setPayoutAmount(payoutAmount);
		      
		      String payoutCcy = document.getElementsByTagName("PAYOUTCURRENCY").item(0).getTextContent();
		      ResponseDTO.setPayoutCcy(payoutCcy);
		      
		      String txnDate = document.getElementsByTagName("TXN_DATE").item(0).getTextContent();
		      ResponseDTO.setTxnDate(txnDate);
		      
		      String settlementRate = document.getElementsByTagName("SETTLEMENT_RATE").item(0).getTextContent();
		      ResponseDTO.setSettlementRate(settlementRate);
		      
		      String settlementDollarRate = document.getElementsByTagName("SETTLEMENT_DOLLARRATE").item(0).getTextContent();
		      ResponseDTO.setSettlementDollarRate(settlementDollarRate);
		      
		    } catch (ConnectException ce) {
		      ResponseDTO.setCode("Error - ConnectException - Issue in Connecting Partner API");
		      ResponseDTO.setMessage(ce.getMessage());
		      ce.printStackTrace();
		    } catch (NullPointerException ne) {
		      ResponseDTO.setCode("Error - NullPointerException");
			  ResponseDTO.setMessage(ne.getMessage());
		      ne.printStackTrace();
		    } catch (Exception e) {
		      ResponseDTO.setCode("Error - General Exception");
		      ResponseDTO.setMessage(e.getMessage());
		      e.printStackTrace();
		    } 
		    return ResponseDTO;
		  }
}
