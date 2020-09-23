package fr.minemobs.test;

import jdk.nashorn.api.scripting.URLReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.URL;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        //Mettez l'ip de votre serveur
        String ipduserv = "tonip";

        Object obj = new JSONParser().parse(new URLReader(new URL( "https://api.mcsrvstat.us/2/" + ipduserv)));

        JSONObject jo = (JSONObject) obj;

        Boolean debug = (Boolean) jo.get("online");
        if(debug == false){
            //Le serveur est off
            System.out.println(debug);
            return;
        }
        //Le serveur est on
        System.out.println(debug);

        String ip = (String) jo.get("ip");
        Long port = (long) jo.get("port");

        System.out.println(ip);
        System.out.println(port);

        String age = (String) jo.get("version");
        System.out.println(age);

        //Recuperer le nombre de joueurs
        JSONObject player = (JSONObject) jo.get("players");
        System.out.println(player.get("online"));

        //Optionnel c'est pour récuperer le nom des mods
        Map address = ((Map)jo.get("mods"));
        JSONArray newAddress = (JSONArray) address.get("names");
        System.out.println(newAddress);

    }
}
