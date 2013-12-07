package matthbo.mods.tmm.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import matthbo.mods.tmm.TooManyMods;
import matthbo.mods.tmm.lib.ItemRef;
import net.minecraft.item.Item;

public class Items {
	
	public static Item vanillaManual;
	public static Item magilutionManual;
	
	public static void PreInit(){
		vanillaManual = new TMMItem(ItemRef.vanillaManual_ID, "VanillaWiki").setUnlocalizedName("vanillawiki");
		magilutionManual = new TMMItem(ItemRef.magilutionManual_ID, "MagilutionWiki").setUnlocalizedName("magilutionwiki");
	}
	
	public static void Init(){
		LanguageRegistry.addName(vanillaManual, "Vanilla Wiki");
		LanguageRegistry.addName(magilutionManual, "Magilution Wiki");
		
		GameRegistry.registerItem(vanillaManual, "vanillawiki");
		GameRegistry.registerItem(magilutionManual, "magilutionwiki");
		
		vanillaManual.setCreativeTab(TooManyMods.TMMTab);
		magilutionManual.setCreativeTab(TooManyMods.TMMTab);
	}

}