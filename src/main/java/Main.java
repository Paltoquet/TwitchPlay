import org.pircbotx.Channel;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.cap.EnableCapHandler;

public class Main {
    //areliann
    static String chan="#enyxia_tv";
    public static void main(String[] args) {

        MonListener list;
        Configuration config = new Configuration.Builder()
                .setAutoNickChange(false) //Twitch doesn't support multiple users
                .setOnJoinWhoEnabled(false) //Twitch doesn't support WHO command
                .setCapEnabled(true)
                .addCapHandler(new EnableCapHandler("twitch.tv/membership")) //Twitch by default doesn't send JOIN, PART, and NAMES unless you request it, see https://github.com/justintv/Twitch-API/blob/master/IRC.md#membership

                .addServer("irc.twitch.tv")
                .setName("Paltoque") //Your twitch.tv username
                .setServerPassword("oauth:img3n1rzwwn2rzw0l0876jvl91719k") //the ouath token for the same account
                .addAutoJoinChannel(chan) //Some twitch channel

                .addListener(list=new MonListener())
                .buildConfiguration();

        //Create our bot with the configuration
        PircBotX bot = new PircBotX(config);
        list.setBot(bot);
        //Channel channel = (target.length() != 0 && bot.getUserChannelDao().containsChannel(target))
          //      ? bot.getUserChannelDao().getChannel(target) : null;
        //Connect to the server
        System.out.println("voici les channels 1 "+bot.getUserChannelDao().getAllChannels());

        try {
            bot.startBot();
        } catch (Exception a) {
            System.out.println("fail");
        }
    }
}
