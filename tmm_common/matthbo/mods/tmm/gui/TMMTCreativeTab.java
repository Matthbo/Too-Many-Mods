package matthbo.mods.tmm.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class TMMTCreativeTab extends CreativeTabs {
	
	private int tabIndexID;
	private String tabName;

	public TMMTCreativeTab(int par1, int par2, String par2Str, String par4Str) {
		super(par1, par2Str);
		
		this.tabName = par4Str;
		this.tabIndexID = par2;
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return this.tabIndexID;
	}

	public String getTranslatedTabLabel() {
		return this.tabName;
	}

}
