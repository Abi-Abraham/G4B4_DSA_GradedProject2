package graded_project_2.q2.mnc.transactions.transaction_node;

 public class TransactionNode {

	
	private int transactionData;
	
	public TransactionNode left;
	public TransactionNode right;
	
	public TransactionNode(int tData){
		 
		transactionData = tData;
		left = right = null;
		
	}
	
	public int getTransactionData() {
		return transactionData;
	}
	public void setTransactionData(int transactionData) {
		this.transactionData = transactionData;
	}

}