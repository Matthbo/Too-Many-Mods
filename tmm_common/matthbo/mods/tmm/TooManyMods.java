package matthbo.mods.tmm;

import matthbo.mods.tmm.config.ConfigHandler;
import matthbo.mods.tmm.lib.Reference;
import matthbo.mods.tmm.network.TMMPacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {Reference.CHANNEL}, packetHandler = TMMPacketHandler.class)
public class TooManyMods {
	
	/* TODO
	 * 
	 * Make a vanilla wiki book
	 */

	@Instance(Reference.MOD_ID)
	public static TooManyMods instance;
	
	@SidedProxy(clientSide="matthbo.mods.tmm.client.ClientProxy", serverSide="matthbo.mods.tmm.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		/* TODO
		 * 
		 * check ee3 code for mod tutorial
		 * check ichun's mods for tutorial
		 * check mdiyo's mods for tutorial
		 */
	}
}