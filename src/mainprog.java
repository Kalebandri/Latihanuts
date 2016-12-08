
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class mainprog extends JFrame
{
	public mainprog()
	{
		try
		{
			
		setTitle("PERPUSTAKAAN XYZ");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Vector<Vector<Object>> data = null;
		Vector<Object> columnNames = new Vector<Object>();
		columnNames.add("Kode Buku");
		columnNames.add("Judul Buku");
		columnNames.add("Penulis Buku");
		columnNames.add("Penerbit Buku");
		columnNames.add("Nomor Rak");
		
		
		
		try
		{
			Latihanuts db = new Latihanuts();
			System.out.println(db.isConnected());
			data = db.selectBook();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		JPanel panel1 = new JPanel(new GridLayout(1, 250));
		JPanel panel2 = new JPanel(new GridLayout(6, 0));
		JPanel panel3 = new JPanel(new GridLayout());
		
		JTable table = new JTable(data,columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		
		//JLabel lb = new JLabel("PERPUSTAKAAN XYZ", JLabel.TOP);		
		
		JLabel lb_kodebuku = new JLabel("Kode Buku");
		JLabel lb_judulbuku = new JLabel("Judul Buku");
		JLabel lb_penulis = new JLabel("Penulis");
		JLabel lb_penerbit = new JLabel("Penerbit");
		JLabel lb_nomorrak = new JLabel("Nomor Rak");
	
		
		JTextField txt_kodebuku = new JTextField();
		JTextField txt_judulbuku = new JTextField();
		JTextField txt_penulis = new JTextField();
		JTextField txt_penerbit = new JTextField();
		JTextField txt_nomorrak = new JTextField();
		
		
		
		JButton btn_add = new JButton("Add Name");
		JButton btn_update = new JButton("Update");
		JButton btn_delete = new JButton("Delete");
		JButton btn_close = new JButton("Close");
		
		
		//panel1.add(lb);
		panel1.add(scrollPane, BorderLayout.CENTER);
		panel2.setBorder(BorderFactory.createEmptyBorder());
		panel2.setBorder(BorderFactory.createTitledBorder("Library Editor"));
		panel2.add(lb_kodebuku);
		panel2.add(txt_kodebuku);
		panel2.add(lb_judulbuku);
		panel2.add(txt_judulbuku);
		panel2.add(lb_penulis);
		panel2.add(txt_penulis);
		panel2.add(lb_penerbit);
		panel2.add(txt_penerbit);
		panel2.add(lb_nomorrak);
		panel2.add(txt_nomorrak);
		
		
		panel3.add(btn_add);
		panel3.add(btn_update);
		panel3.add(btn_delete);
		panel3.add(btn_close);
		
		setLayout(new GridLayout(2, 1));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		setVisible(true);
		}
		catch (Exception e)
		{
			System.out.println("e");
		}
	}
	
	
	public static void main(String[] args)
	{
		new mainprog();
	}
	
	
}
