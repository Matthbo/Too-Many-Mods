package matthbo.mods.magilution.api.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagilutionItems {
	
	private static Class<?> Items;
	
	public static Item getItem(String name){
		try{
			if(Items == null) Items = Class.forName(getPackage() + ".item.Items");
			
			Object ret = Items.getField(name).get(null);
			
			if (ret instanceof Item) {
		        return (Item)ret;
		      }else{
		      return null;	
		      }
		}
		catch(Exception e){
			System.out.println("Magilution API: getItem failed for" + name);
			
			return null;
		}
	}
	
	private static String getPackage(){
		Package pkg = MagilutionItems.class.getPackage();

		if (pkg != null) {
			String packageName = pkg.getName();

			return packageName.substring(0, packageName.length() - ".api.item".length());
		}

		return "matthbo.mods.magilution";
	}
}
