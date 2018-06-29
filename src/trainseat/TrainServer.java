package trainseat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TrainServer extends JFrame {
	private static final long serialVersionUID = -8029119751800341454L;
	public static JButton button1, button2, button3, button4, button5, button6, button4_1, button4_2, button4_3,
			button4_4, button4_5, button4_6;
	private JPanel contentPane;
	public static JTextArea textArea;

	public TrainServer() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Train server");
		setBounds(150, 150, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("1�샇李�");
		comboBox.addItem("2�샇李�");
		comboBox.addItem("3�샇李�");
		comboBox.addItem("4�샇李�");
		comboBox.addItem("5�샇李�");
		comboBox.addItem("6�샇李�");
		comboBox.addItem("7�샇李�");
		comboBox.addItem("8�샇李�");
		comboBox.addItem("9�샇李�");
		comboBox.addItem("10�샇李�");

		comboBox.setBounds(161, 10, 106, 29);
		contentPane.add(comboBox);

		JButton button1 = new JButton("1-1");
		button1.setBounds(12, 58, 55, 55);
		contentPane.add(button1);

		JButton button2 = new JButton("1-2");
		button2.setBounds(66, 58, 55, 55);
		contentPane.add(button2);

		JButton button3 = new JButton("1-3");
		button3.setBounds(120, 58, 55, 55);
		contentPane.add(button3);

		JButton button4 = new JButton("1-4");
		button4.setBounds(12, 113, 55, 55);
		contentPane.add(button4);

		JButton button5 = new JButton("1-5");
		button5.setBounds(66, 113, 55, 55);
		contentPane.add(button5);

		JButton button6 = new JButton("1-6");
		button6.setBounds(120, 113, 55, 55);
		contentPane.add(button6);

		JButton button4_1 = new JButton("4-1");
		button4_1.setBounds(252, 58, 55, 55);
		contentPane.add(button4_1);

		JButton button4_2 = new JButton("4-2");
		button4_2.setBounds(306, 58, 55, 55);
		contentPane.add(button4_2);

		JButton button4_3 = new JButton("4-3");
		button4_3.setBounds(360, 58, 55, 55);
		contentPane.add(button4_3);

		JButton button4_4 = new JButton("4-4");
		button4_4.setBounds(252, 113, 55, 55);
		contentPane.add(button4_4);

		JButton button4_5 = new JButton("4-5");
		button4_5.setBounds(306, 113, 55, 55);
		contentPane.add(button4_5);

		JButton button4_6 = new JButton("4-6");
		button4_6.setBounds(360, 113, 55, 55);

		this.textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		scrollPane.setBounds(12, 173, 405, 79);
		contentPane.add(scrollPane);

		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		contentPane.add(button5);
		contentPane.add(button6);
		contentPane.add(button4_1);
		contentPane.add(button4_2);
		contentPane.add(button4_3);
		contentPane.add(button4_4);
		contentPane.add(button4_5);
		contentPane.add(button4_6);
	}

	public void updateTextArea(String text) {
		textArea.setText(text);
	}
}
