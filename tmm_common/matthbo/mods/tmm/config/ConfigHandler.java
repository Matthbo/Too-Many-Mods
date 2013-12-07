package matthbo.mods.tmm.config;

import java.io.File;

import matthbo.mods.tmm.lib.ItemRef;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	public static boolean vanillaManual;
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		ItemRef.vanillaManual_ID = config.getItem("Books", ItemRef.vanillaManual_KEY, ItemRef.vanillaManual_DEFAULT).getInt();
		ItemRef.magilutionManual_ID = config.getItem("Books", ItemRef.magilutionManual_KEY, ItemRef.magilution_DEFAULT).getInt();
		
		vanillaManual = config.get("Books Spawns", "Vanilla Wiki", true).getBoolean(true);
		
		config.save();
	}

}
