package matthbo.mods.tmm.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TMMItem extends Item {
	
	protected String texturePath;

	public TMMItem(int par1, String par2Str) {
		super(par1 + -256);
		
		texturePath = par2Str;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon("tmm" + ":" + "manuals/" + texturePath);
	}

}
