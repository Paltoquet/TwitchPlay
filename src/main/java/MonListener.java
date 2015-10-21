

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by thibault on 17/10/2015.
 */
public class MonListener extends ListenerAdapter {

    boolean echo=false;
    PircBotX bot;
    public MonListener(){
        super();
        InputThread t=new InputThread(this);
        t.start();
    }

    public void notifie(){
        echo=!echo;
        System.out.println("valeur de echo "+echo);
    }
    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        System.out.println("Echo: " + event.getMessage());
        if (echo) {
            event.respond(event.getMessage());
        }
            //When someone says ?helloworld respond with "Hello World"
            if (event.getMessage().contains("bot"))
                event.respond("Je ne suis pas un robot, j'ai des sentiments comme vous !");
            if (event.getMessage().contains("ban"))
                event.respond("Arretez me bannez pas j'ai rien fait");
            if (event.getMessage().contains("napoleon")){
                event.respond("Napol�on Ier, n� le 15 ao�t 1769 � Ajaccio et mort le 5 mai 1821 sur l'�le Sainte-H�l�ne, est le premier empereur des Fran�ais, du 18 mai 1804 au 6 avril 1814 et du 20 mars 1815 au 22 juin 1815. ");
            }
        if (event.getMessage().contains("r2d2")){
            event.respond("ne me comparez pas à cette boite de conserve qu'est R2D2, merci");
        }
        if (event.getMessage().contains("salut")){
            event.respond("Salutation !");
        }
            if (event.getMessage().contains("amour"))
                event.respond("Je vous aime tout");
            if (event.getMessage().contains("binaire"))
            event.respond("10001010111011101011010110110101000111001");
            if (event.getMessage().contains("heure")) {
                Date date = new Date();   // given date
                Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
                calendar.setTime(date);   // assigns calendar to given date
                calendar.get(Calendar.HOUR_OF_DAY);
                event.respond(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY))+"heures "+String.valueOf(calendar.get(Calendar.MINUTE))+" minutes"+String.valueOf(calendar.get(Calendar.SECOND))+" secondes");
            }

    }

    public void notifie(String p,String def){
       bot.sendIRC().message(Main.chan,p+": "+def);

    }

    public void setBot(PircBotX b){
        bot=b;
    }
}