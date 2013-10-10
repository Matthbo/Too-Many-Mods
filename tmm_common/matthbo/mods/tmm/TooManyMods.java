package matthbo.mods.tmm;

import org.lwjgl.Sys;

import matthbo.mods.tmm.command.CommandHandler;
import matthbo.mods.tmm.config.ConfigHandler;
import matthbo.mods.tmm.gui.TMMTCreativeTab;
import matthbo.mods.tmm.item.Items;
import matthbo.mods.tmm.lib.Reference;
import matthbo.mods.tmm.network.TMMPacketHandler;
import matthbo.mods.tmm.util.PlayerHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDS)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {Reference.CHANNEL}, packetHandler = TMMPacketHandler.class)
public class TooManyMods {
	
	/* TODO
	 * 
	 * Make the vanilla wiki book work:
	 *  ! make pageclasses(see tconstruct.client.TProxyClient.initManualPages())
	 *  - make the book gui
	 *  - get wiki in it
	 *  
	 *  Make a in-game message (if in dev version!!!)
	 */

	@Instance(Reference.MOD_ID)
	public static TooManyMods instance;
	
	@SidedProxy(clientSide="matthbo.mods.tmm.client.ClientProxy", serverSide="matthbo.mods.tmm.CommonProxy")
	public static CommonProxy proxy;
	
	public TooManyMods(){
		System.out.println("[TMM] Making wiki books.");
		
		if(Loader.isModLoaded("Magilution")){
			System.out.println("[Magilution] TMM, please do a magic one for me!");
		}
		System.out.println("[TMM] Books are created, have fun!");
	}
	
	public static CreativeTabs TMMTab;
	
	public static PlayerHandler playerTracker;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		proxy.initRenderers();
		proxy.initSounds();
		proxy.readManuals();
		
		Items.PreInit();
		
		TMMTab = new TMMTCreativeTab(CreativeTabs.getNextID(), Items.vanillaManual.itemID, "TMMTab", "Too Many Mods");
		
		
		Items.Init();
		
		playerTracker = new PlayerHandler();
        GameRegistry.registerPlayerTracker(playerTracker);
        MinecraftForge.EVENT_BUS.register(playerTracker);
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		NetworkRegistry.instance().registerConnectionHandler(new CommandHandler());
		
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