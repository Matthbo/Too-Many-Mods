package matthbo.mods.tmm.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		//blocks / items go here (lolz_ID = ...)
		
		config.save();
	}

}
