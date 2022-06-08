package HorlogeDigital;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame  {
	
	Calendar calendar;
	
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	
	String time;
	String day;
	String date;

	MyFrame(){ // création du cadre/fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermer la fenetre
		this.setTitle("Horloge numerique"); // titre
		this.setLayout(new FlowLayout()); // alignement centré et un écart horizontal et vertical de 5 unités par défaut
		this.setSize(350,200); // dimension
		this.setResizable(false); // non modulable (dimension)
		
		timeFormat = new SimpleDateFormat("HH:mm:ss"); // l'heure
		dayFormat = new SimpleDateFormat("EEEE "); // le jour de la semaine
		dateFormat = new SimpleDateFormat("dd MMMMM yyyy"); // la date numéro du jour/mois/année
		
		timeLabel = new JLabel(); // l'heure
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50)); //police, taille 50
		timeLabel.setForeground(new Color(0x00e0fe)); // couleur de l'heure
		timeLabel.setBackground(Color.black); // couleur derriere l'heure
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel(); //le jour de la semaine
		dayLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		
		dateLabel = new JLabel(); // la date
		dateLabel.setFont(new Font("Verdana",Font.PLAIN,25));
		
		// on appel tous pour l'afficher
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true); // visible => oui
		
		setTime();
	}
	
	public void setTime() {
		
		while(true) { // la boucle 
			
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
