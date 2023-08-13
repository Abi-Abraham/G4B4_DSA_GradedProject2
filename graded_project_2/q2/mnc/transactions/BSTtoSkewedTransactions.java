package graded_project_2.q2.mnc.transactions;

import graded_project_2.q2.mnc.transactions.transaction_node.TransactionNode;

public class TransactionBSTtoSkewed {
	
	TransactionNode node;
	TransactionNode skewedHeadNode = null;     
	TransactionNode skewedLastNode = null;    
	
	void getInputTransactionBSTData() 
	{
		node = new TransactionNode(50);
		node.left = new TransactionNode(30);
		node.right = new TransactionNode(60); 
		node.left.left = new TransactionNode(10); 
		node.right.left= new TransactionNode(55);
	}
	
	 void transactionBSTtoRightSkewed(TransactionNode root) {
		
		if(root == null)
			return;

		transactionBSTtoRightSkewed(root.left);
		
		TransactionNode rightNodeBST = root.right;
		
		if(skewedHeadNode == null) 
		{
			skewedHeadNode = root;
			root.left = null;
			skewedLastNode = root;
		}
		else
		{
			skewedLastNode.right = root;
			root.left = null;
			skewedLastNode = root;
		}
		
		transactionBSTtoRightSkewed(rightNodeBST);
		
	}
	 
	 void getOutputTransactionSkewedData(TransactionNode root)
	 {

		 if(root == null)
			 return;

		 System.out.print(root.getTransactionData() + " ");

		 getOutputTransactionSkewedData(root.right); 
	 }
	
	public static void main(String[] args) {
		
	TransactionBSTtoSkewed main = new TransactionBSTtoSkewed();
	main.getInputTransactionBSTData();
	main.transactionBSTtoRightSkewed(main.node);
	main.getOutputTransactionSkewedData(main.skewedHeadNode);
	
	}	
	

}