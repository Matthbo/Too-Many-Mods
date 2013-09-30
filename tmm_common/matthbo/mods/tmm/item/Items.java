package matthbo.mods.tmm.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import matthbo.mods.tmm.lib.ItemRef;
import net.minecraft.item.Item;

public class Items {
	
	public static Item vanillaManual;
	
	public static void PreInit(){
		vanillaManual = new TMMItem(ItemRef.vanillaManual_ID, "VanillaWiki").setUnlocalizedName("vanillawiki");
	}
	
	public static void Init(){
		LanguageRegistry.addName(vanillaManual, "Vanilla Wiki");
		
		GameRegistry.registerItem(vanillaManual, "vanillawiki");
	}

}