package exam;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("50\u984C\u96A8\u6A5F\u6A21\u64EC\u6E2C\u9A57", null, layeredPane, null);
		layeredPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{395, -9};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		layeredPane.add(scrollPane);
		
		ArrayList<quest> arrayQuest = new ArrayList<quest>();	//五十題題庫物件陣列
		ArrayList<String> arrayAllQuest = new ArrayList<String>();	//檔案載入全題庫物件
		ArrayList<quest> allQuest = new ArrayList<quest>();		//全題庫隨機物件陣列

		try {
			InputStreamReader read = new InputStreamReader (new FileInputStream("quest.txt"),"UTF-8");
			@SuppressWarnings("resource")
			Scanner inf = new Scanner(read);
			frame.setTitle(inf.next() + "\u6A21\u64EC\u6E2C\u9A57");	//第一行為標題名稱
			while (inf.hasNext()) {
				if (inf.hasNextLine()) {
					String s = inf.next();
					if(!s.substring(0, 3).equals("***"))	//***開頭為章節說明行
						arrayAllQuest.add(s);
				}
			}
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int[] rand = randomCommon(0, arrayAllQuest.size() - 1, 50);
		
		for(int i = 0; i < 50; i++) {
			JPanel panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = i;
			panel.add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
		
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setColumns(60);
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.insets = new Insets(0, 0, 5, 0);
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 0;
			gbc_textArea.gridy = 0;
			gbc_textArea.anchor = GridBagConstraints.WEST;
			panel_1.add(textArea, gbc_textArea);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_1.gridx = 0;
			gbc_rdbtnNewRadioButton_1.gridy = 1;
			gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
			panel_1.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_2.gridx = 0;
			gbc_rdbtnNewRadioButton_2.gridy = 2;
			gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
			panel_1.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
			
			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_3.gridx = 0;
			gbc_rdbtnNewRadioButton_3.gridy = 3;
			gbc_rdbtnNewRadioButton_3.anchor = GridBagConstraints.WEST;
			panel_1.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
			
			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_4.gridx = 0;
			gbc_rdbtnNewRadioButton_4.gridy = 4;
			gbc_rdbtnNewRadioButton_4.anchor = GridBagConstraints.WEST;
			panel_1.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
			
			ButtonGroup btnGroup = new ButtonGroup();
			btnGroup.add(rdbtnNewRadioButton_1);
			btnGroup.add(rdbtnNewRadioButton_2);
			btnGroup.add(rdbtnNewRadioButton_3);
			btnGroup.add(rdbtnNewRadioButton_4);
			
			quest q = new quest();
			q.setTextArea(textArea);
			q.setRadioButto(rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, rdbtnNewRadioButton_3, rdbtnNewRadioButton_4);
			
			q.setQuest(arrayAllQuest.get(rand[i]));

			arrayQuest.add(q);
		}
		
		JButton btnNewButton = new JButton("\u8A55\u5206");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int score = 0;
				for(int i = 0; i < 50; i++) {
					if(arrayQuest.get(i).checkAnswer())
						score += 2;
					btnNewButton.setText(Integer.toString(score));
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 50;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("\u5168\u984C\u5EAB\u6E2C\u9A57(\u9806\u5E8F\u6253\u4E82)", null, layeredPane_1, null);
		layeredPane_1.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{395, -9};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(panel_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(20);
		layeredPane_1.add(scrollPane_1);

		int[] rand_2 = randomCommon(0, arrayAllQuest.size() - 1, arrayAllQuest.size() - 2);

		for(int i = 0; i < arrayAllQuest.size() - 2; i++) {
			JPanel panel_2 = new JPanel();
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 0);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 0;
			gbc_panel_2.gridy = i;
			panel_1.add(panel_2, gbc_panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
		
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setColumns(60);
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.insets = new Insets(0, 0, 5, 0);
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 0;
			gbc_textArea.gridy = 0;
			gbc_textArea.anchor = GridBagConstraints.WEST;
			panel_2.add(textArea, gbc_textArea);
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_1.gridx = 0;
			gbc_rdbtnNewRadioButton_1.gridy = 1;
			gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
			panel_2.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
			
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_2.gridx = 0;
			gbc_rdbtnNewRadioButton_2.gridy = 2;
			gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
			panel_2.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
			
			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_3.gridx = 0;
			gbc_rdbtnNewRadioButton_3.gridy = 3;
			gbc_rdbtnNewRadioButton_3.anchor = GridBagConstraints.WEST;
			panel_2.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
			
			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
			GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnNewRadioButton_4.gridx = 0;
			gbc_rdbtnNewRadioButton_4.gridy = 4;
			gbc_rdbtnNewRadioButton_4.anchor = GridBagConstraints.WEST;
			panel_2.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
			
			ButtonGroup btnGroup = new ButtonGroup();
			btnGroup.add(rdbtnNewRadioButton_1);
			btnGroup.add(rdbtnNewRadioButton_2);
			btnGroup.add(rdbtnNewRadioButton_3);
			btnGroup.add(rdbtnNewRadioButton_4);
			
			quest q = new quest();
			q.setTextArea(textArea);
			q.setRadioButto(rdbtnNewRadioButton_1, rdbtnNewRadioButton_2, rdbtnNewRadioButton_3, rdbtnNewRadioButton_4);
			
			String s = Integer.toString(i);
			
			JButton btnNewButton_1 = new JButton("Check");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					allQuest.get(Integer.parseInt(s)).checkAnswer();
				}
			});
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.gridx = 0;
			gbc_btnNewButton_1.gridy = 5;
			panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
			
			q.setQuest(arrayAllQuest.get(rand_2[i]));
	
			allQuest.add(q);
		}
	}
	
	/** 
	* 隨機指定範圍內N個不重複的數 
	* @param min 指定範圍最小值 
	* @param max 指定範圍最大值 
	* @param n 隨機數個數 
	*/ 
	public static int[] randomCommon(int min, int max, int n){
		if (n > (max - min - 1) || max < min) {
			return null;
		}
		int[] result = new int[n];
		int count = 0;
		while(count < n) {
			int num = (int) (Math.random() * (max - min)) - min;
			boolean flag = true;
			for (int j = 0; j < n; j++ ) {
				if(num == result[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result[count] = num;
				count++;
			}
		}
		return result;
	}
}
