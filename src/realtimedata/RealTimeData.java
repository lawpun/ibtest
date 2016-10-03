/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimedata;

import java.util.ArrayList;
import java.util.Set;
import java.util.ArrayList;

import java.util.Set;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.DeltaNeutralContract;
import com.ib.client.EClientSocket;
import com.ib.client.EJavaSignal;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.TagValue;
/**
 *
 * @author abc
 */

// RealTimeData Class is an implementation of the 
// IB API EWrapper class
public class RealTimeData implements EWrapper
{
	// Keep track of the next ID
	private int nextOrderID = 0;
	// The IB API Client Socket object
	private EClientSocket client = null;
        private EJavaSignal m_signal = new EJavaSignal();
        private ArrayList<TagValue> m_mktDataOptions = new ArrayList<TagValue>();
        public Contract m_contract = new Contract ();
        
	public RealTimeData ()
	{
		// Create a new EClientSocket object
      		client = new EClientSocket (this, m_signal);
		// Connect to the TWS or IB Gateway application
		// Leave null for localhost
		// Port Number (should match TWS/IB Gateway configuration
		client.eConnect (null, 7496, 0);

		// Pause here for connection to complete
		try 
		{
			// Thread.sleep (1000);
			while (! (client.isConnected()));
			// Can also try: while (client.NextOrderId <= 0);
		}
		catch (Exception e) 
		{
		}
		// Create a new contract
		
		m_contract.symbol("EUR");
		m_contract.exchange("IDEALPRO");
		m_contract.secType("CASH");
		m_contract.currency("USD");
		// Create a TagValue list
		//Vector mktDataOptions = new Vector();
		// Make a call to start off data retrieval
		client.reqMktData(0, m_contract, null, false, m_mktDataOptions);
		// At this point our call is done and any market data events
		// will be returned via the tickPrice method

    } // end RealTimeData

    public void bondContractDetails(int reqId, ContractDetails contractDetails)
    {
    }

    public void contractDetails(int reqId, ContractDetails contractDetails)
    {
    }

    public void contractDetailsEnd(int reqId)
    {
    }

    public void fundamentalData(int reqId, String data)
    {
    }

    public void bondContractDetails(ContractDetails contractDetails)
    {
    }

    public void contractDetails(ContractDetails contractDetails)
    {
    }

    public void currentTime(long time)
    {
    }

    public void displayGroupList(int requestId, String contraftInfo)
    {
    }


    public void displayGroupUpdated(int requestId, String contractInfo)
    {
    }

    public void verifyCompleted(boolean completed, String contractInfo)
    {
    }
    public void verifyMessageAPI(String message)
    {
    }

    public void execDetails(int orderId, Contract contract, Execution execution)
    {
    }

    public void execDetailsEnd(int reqId)
    {
    }

    public void historicalData(int reqId, String date, double open,
            double high, double low, double close, int volume, int count,
            double WAP, boolean hasGaps)
    {
    }

    public void managedAccounts(String accountsList)
    {
    }

    public void commissionReport(CommissionReport cr)
    {
    }

    public void position(String account, Contract contract, int pos, double avgCost)
    {
    }

    public void positionEnd()
    {
    }

    public void accountSummary(int reqId, String account, String tag, String value, String currency)
    {
    }

    public void accountSummaryEnd(int reqId)
    {
    }

    public void accountDownloadEnd(String accountName)
    {
    }

    public void openOrder(int orderId, Contract contract, Order order,
            OrderState orderState)
    {
    }

    public void openOrderEnd()
    {
    }


    public void orderStatus(int orderId, String status, int filled,
            int remaining, double avgFillPrice, int permId, int parentId,
            double lastFillPrice, int clientId, String whyHeld)
    {
    }

    public void receiveFA(int faDataType, String xml)
    {
    }

    public void scannerData(int reqId, int rank,
            ContractDetails contractDetails, String distance, String benchmark,
            String projection, String legsStr)
    {
    }

    public void scannerDataEnd(int reqId)
    {
    }

    public void scannerParameters(String xml)
    {
    }

    public void tickEFP(int symbolId, int tickType, double basisPoints,
            String formattedBasisPoints, double impliedFuture, int holdDays,
            String futureExpiry, double dividendImpact, double dividendsToExpiry)
    {
    }

    public void tickGeneric(int symbolId, int tickType, double value)
    {
    }

    public void tickOptionComputation( int tickerId, int field, 
                      double impliedVol, double delta, double optPrice, 
                      double pvDividend, double gamma, double vega, 
                      double theta, double undPrice)
    {
    }

   
    /*public void deltaNeutralValidation(int reqId, UnderComp underComp) 
    {
    }
*/

    public void updateAccountTime(String timeStamp)
    {
    }

    public void updateAccountValue(String key, String value, String currency,
            String accountName)
    {
    }

    public void updateMktDepth(int symbolId, int position, int operation,
            int side, double price, int size)
    {
    }

    public void updateMktDepthL2(int symbolId, int position,
            String marketMaker, int operation, int side, double price, int size)
    {
    }

    public void updateNewsBulletin(int msgId, int msgType, String message,
            String origExchange)
    {
    }

    public void updatePortfolio(Contract contract, int position,
            double marketPrice, double marketValue, double averageCost,
            double unrealizedPNL, double realizedPNL, String accountName)
    {
    }

    public void marketDataType(int reqId, int marketDataType)
    {
    }

    public void tickSnapshotEnd(int tickerId)
    {
    }

    public void connectionClosed()
    {
    }

    public void realtimeBar (int reqId, long time, double open, double high,
            double low, double close, long volume, double wap, int count)
    {
    }


    public void error(Exception e)
    {
	// Print out a stack trace for the exception
        e.printStackTrace ();
    }

    public void error(String str)
    {
	// Print out the error message
        System.err.println (str);
    }

    public void error(int id, int errorCode, String errorMsg)
    {
	// Overloaded error event (from IB) with their own error 
	// codes and messages
        System.err.println ("error: " + id + "," + errorCode + "," + errorMsg);
    }
    
    public void nextValidId (int orderId)
    {
	// Return the next valid OrderID
        nextOrderID = orderId;
    }


    public void tickPrice(int orderId, int field, double price,
            int canAutoExecute)
    {
	try 
	{
		// Print out the current price
		// field will provide the price type:
		// 1 = bid,  2 = ask, 4 = last
		// 6 = high, 7 = low, 9 = close
		System.out.println("tickPrice: " + orderId + "," + field + "," + price);
	} 
	catch (Exception e)
        {
		e.printStackTrace ();
        }
 
	
    }

    public void tickSize (int orderId, int field, int size)
    {
    }
    
    
    public void securityDefinitionOptionalParameter(int reqId, String exchange, int underlyingConId, String tradingClass, String multiplier, Set<String> expirations, Set<Double> strikes)
    {
        //String msg = EWrapperMsgGenerator.securityDefinitionOptionalParameter(reqId, exchange, underlyingConId, tradingClass, multiplier, expirations, strikes);
    }
    
    
    public void securityDefinitionOptionalParameterEnd(int reqId)
    {
    }
    
    public void accountUpdateMulti( int reqId, String account, String modelCode, String key, String value, String currency) {
    //    String msg = EWrapperMsgGenerator.accountUpdateMulti(reqId, account, modelCode, key, value, currency);
    //    m_TWS.add(msg);
    }

    public void accountUpdateMultiEnd( int reqId) {
    //    String msg = EWrapperMsgGenerator.accountUpdateMultiEnd(reqId);
    //    m_TWS.add(msg);
    }

    public void positionMulti( int reqId, String account, String modelCode, Contract contract, double pos, double avgCost) {
//        String msg = EWrapperMsgGenerator.positionMulti(reqId, account, modelCode, contract, pos, avgCost);
//        m_TWS.add(msg);
    }

    public void positionMultiEnd( int reqId) {
//        String msg = EWrapperMsgGenerator.positionMultiEnd(reqId);
//        m_TWS.add(msg);
    }
    
    public void connectAck() {
    }

    
    public void tickString (int orderId, int tickType, String value)
    {
    }

    public void verifyAndAuthMessageAPI( String apiData, String xyzChallenge) { /* Empty */ }
    public void verifyAndAuthCompleted( boolean isSuccessful, String errorText) { /* Empty */ }
 
    public void position(String account, Contract contract, double pos, double avgCost) {
    }

    public void deltaNeutralValidation(int reqId, DeltaNeutralContract underComp) 
    {
    }
    
    public void updatePortfolio(Contract contract, double position, double marketPrice,
        double marketValue, double averageCost, double unrealizedPNL, double realizedPNL,
        String accountName) {
    }

    public void orderStatus( int orderId, String status, double filled, double remaining,
                                                 double avgFillPrice, int permId, int parentId,
                                                 double lastFillPrice, int clientId, String whyHeld) {
    }
    
    public static void main (String args[])
    {
        try
        {
		// Create an instance
		// At this time a connection will be made
		// and the request for market data will happen
		System.out.println ("Request:");
                RealTimeData myData = new RealTimeData();
                
        }
        catch (Exception e)
        {
            System.out.println ("Error:");  
            e.printStackTrace ();
        }
    } // end main
    
}
