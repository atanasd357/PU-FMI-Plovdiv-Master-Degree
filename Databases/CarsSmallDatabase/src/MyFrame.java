import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MyFrame extends JFrame {

	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	int id = 0;
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel leftUpPanel = new JPanel();
	private JPanel leftDownPanel = new JPanel();
	//split the left down panel into 2 new panels
	private JPanel leftDownLeftPanel = new JPanel();
	private JPanel leftDownRightPanel = new JPanel();

	private JLabel modelLabel = new JLabel("Model");
	private JLabel brandLabel = new JLabel("Brand");
	private JLabel priceLabel = new JLabel("Price");
	private JLabel enginePowerLabel = new JLabel("Engine Power");

	private JTextField modelJTField = new JTextField();
	private JTextField priceJTField = new JTextField();
	private JTextField enginePowerJTField = new JTextField();
	//search text field
	private JTextField searchJTField = new JTextField();

	String[] contentComboBox = { "Audi", "Ford", "Lexus", "BMW" };
	JComboBox<String> brandComboBox = new JComboBox<>(contentComboBox);

	JButton addBtn = new JButton("Add");
	JButton deleteBtn = new JButton("Delete");
	//search button
	JButton searchBtn = new JButton("Search");

	public MyFrame() {
		this.setVisible(true);
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));
		this.add(leftPanel);
		this.add(rightPanel);

		// left panel
		leftPanel.setLayout(new GridLayout(2, 1));
		leftPanel.add(leftUpPanel);
		leftPanel.add(leftDownPanel);

		// left up panel
		leftUpPanel.setLayout(new GridLayout(4, 2));
		leftUpPanel.add(modelLabel);
		leftUpPanel.add(modelJTField);
		leftUpPanel.add(priceLabel);
		leftUpPanel.add(priceJTField);
		leftUpPanel.add(enginePowerLabel);
		leftUpPanel.add(enginePowerJTField);
		leftUpPanel.add(brandLabel);
		leftUpPanel.add(brandComboBox);

		// leftDownPanel
		//set new layout to left down panel
		leftDownPanel.setLayout(new GridLayout(1, 2));
		leftDownPanel.add(leftDownLeftPanel);
		leftDownPanel.add(leftDownRightPanel);
		
		//set new layout to left down right panel
		leftDownRightPanel.setLayout(new GridLayout(4, 1));
		leftDownRightPanel.add(addBtn);
		leftDownRightPanel.add(deleteBtn);
		addBtn.addActionListener(new AddAction());
		deleteBtn.addActionListener(new DelAction());
		//add search text field, button and search button ActionListener 
		leftDownRightPanel.add(searchJTField);
		leftDownRightPanel.add(searchBtn);
		searchBtn.addActionListener(new SearchAction());

		// right panel
		scroller.setPreferredSize(new Dimension(350, 225));
		rightPanel.add(scroller);
		table.addMouseListener(new MouseClicked());
		refreshTable();
	}

	class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String model = modelJTField.getText();
			int price = Integer.parseInt(priceJTField.getText());
			float enginePower = Float.parseFloat(enginePowerJTField.getText());
			String brand = brandComboBox.getSelectedItem().toString();

			conn = DBConnector.getConnection();
			String sql = "INSERT INTO CAR VALUES(null,?,?,?,?)";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, brand);
				state.setString(2, model);
				state.setInt(3, price);
				state.setFloat(4, enginePower);
				state.execute();
				resetForm();
				refreshTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class DelAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "DELETE FROM CAR WHERE ID=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable();
				id = 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// SearchAction
	class SearchAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String searchValue = searchJTField.getText();
			conn = DBConnector.getConnection();
			String sql = "SELECT * FROM CAR WHERE Brand LIKE ?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, "%" + searchValue + "%");
				result = state.executeQuery();
				table.setModel(new MyModel(result));
			} catch (SQLException exc) {
				exc.printStackTrace();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	class MouseClicked implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			id = Integer.parseInt(table.getValueAt(row, 0).toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	private void resetForm() {
		modelJTField.setText("");
		priceJTField.setText("");
		enginePowerJTField.setText("");
	}

	public void refreshTable() {
		conn = DBConnector.getConnection();
		String sql = "SELECT * FROM CAR";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			table.setModel(new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}