package matthbo.mods.tmm.util;

import matthbo.mods.magilution.api.item.MagilutionItems;
import matthbo.mods.tmm.TooManyMods;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Loader;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		if(Loader.isModLoaded("Magilution")){
			if(item.itemID == MagilutionItems.getItem("mysticCrystal").itemID){
				System.out.println("It Works :D");
			}
		}
		/*if(Loader.isModLoaded("ic2")){
			if(item.itemID == ic2 reinforced iron){
				AbilityHelper.spawnItemAtPlayer(player, ic2 wiki book);
			}
		}*/

	}

}
