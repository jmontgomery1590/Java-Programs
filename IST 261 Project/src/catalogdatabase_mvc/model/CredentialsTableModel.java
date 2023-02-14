package catalogdatabase_mvc.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CredentialsTableModel extends AbstractTableModel {
	private String[] columnNames = {"Type", "Username", "Email"};
	private ArrayList<Credentials> credentialsList;
	
	public CredentialsTableModel(ArrayList<Credentials> newCredentialsList) {
		credentialsList = newCredentialsList; 
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public int getRowCount() {
		return credentialsList.size();
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		switch(col) {
			case 0: return (Object) credentialsList.get(row).getUserType();
			case 1: return (Object) credentialsList.get(row).getUsername();
			case 2: return (Object) credentialsList.get(row).getEmail();
			default: return null;
		}
	}
	
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
	public void setValueAt(String value, int row, int col) {
		columnNames[row] = value;
		fireTableCellUpdated(row, col);
	}
}