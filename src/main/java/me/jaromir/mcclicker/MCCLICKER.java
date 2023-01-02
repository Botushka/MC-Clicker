package me.jaromir.mcclicker;
import me.jaromir.mcclicker.Cookie.Database;
import me.jaromir.mcclicker.Listener.CookieListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.SQLException;


public final class MCCLICKER extends JavaPlugin implements Listener {
    private Database database;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new CookieListener(this), this);
        try{
            this.database = new Database();
            database.initializeDatabase();
        }catch(SQLException e){

            System.out.println("Unable to connect to database and create tables.");
            e.printStackTrace();
        }
        }

    public Database getDatabase() {
        return database;
    }
}
