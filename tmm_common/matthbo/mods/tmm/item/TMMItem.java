package matthbo.mods.tmm.item;

import matthbo.mods.tmm.TooManyMods;
import matthbo.mods.tmm.client.ClientProxy;
import matthbo.mods.tmm.client.gui.GuiManual;
import matthbo.mods.tmm.lib.ItemRef;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.FMLCommonHandler;

public class TMMItem extends Item {

	protected String texturePath;

	public TMMItem(int par1, String par2Str) {
		super(par1 + -256);

		texturePath = par2Str;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon("tmm" + ":" + "manuals/" + texturePath);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (this.itemID == ItemRef.vanillaManual_ID) {
			Side side = FMLCommonHandler.instance().getEffectiveSide();
			if (side.isClient()) FMLClientHandler.instance().displayGuiScreen(player, new GuiManual(player.getCurrentEquippedItem(), ClientProxy.vanillaManual));

			//player.openGui(TooManyMods.instance, TooManyMods.proxy.manualGuiID, world, 0, 0, 0);
		}
		return stack;
	}

}
