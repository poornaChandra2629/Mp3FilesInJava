import java.awt.Color;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public abstract class Player implements AudioSpectrumListener{
	public static void main(String args[])
	{
		try {
			new javafx.embed.swing.JFXPanel();
			Scanner sc=new Scanner(System.in); 
		    String filePath = "C:\\Users\\kadreddy\\Downloads\\123\\2.mp3"; 
			String uriString = new File(filePath).toURI().toString();
			MediaPlayer player = new MediaPlayer(new Media(uriString));
			  JFrame f= new JFrame("Panel Example");    
		        JPanel panel=new JPanel();  
		        panel.setBounds(0,0,400,400);    
		        panel.setBackground(Color.black);  
		        f.add(panel);  
                f.setSize(400,400);    
                f.setLayout(null);    
                f.setVisible(true);
			String s="";
			int flag=0;
			while(true)
			{
				String status=player.getStatus().toString();
				if(status.equalsIgnoreCase("Stopped") || status.equalsIgnoreCase("ready") || status.equalsIgnoreCase("playing"))
				{
					System.out.println("Enter Choice");
					s=sc.next();
				}
				player.setOnEndOfMedia(()->
				{
					System.out.println("Succesfully completed");
					player.stop();
				});
				if( s.equalsIgnoreCase("STOP"))
				{
					System.out.println("stopped...!!!!");
					player.stop();;
				}
				else if(s.equalsIgnoreCase("play"))
				{
				
					System.out.println("Playing....");
					player.play();
					System.out.println(player.getAudioSpectrumThreshold());
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
