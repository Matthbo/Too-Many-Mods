package matthbo.mods.tmm.util;

import matthbo.mods.tmm.lib.tools.AbilityHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Loader;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {

	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		/*if(Loader.isModLoaded("ic2")){
			if(item.itemID == ic2 rubber){
				AbilityHelper.spawnItemAtPlayer(player, ic2 wiki book);
			}
		}*/

	}

}
