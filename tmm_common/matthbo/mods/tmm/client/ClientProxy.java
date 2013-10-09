package matthbo.mods.tmm.client;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import matthbo.mods.tmm.CommonProxy;
import matthbo.mods.tmm.TooManyMods;
import matthbo.mods.tmm.client.gui.GuiManual;
import matthbo.mods.tmm.client.pages.BookPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.w3c.dom.Document;

public class ClientProxy extends CommonProxy {

	public static Document vanillaManual;

	public static Map<String, Class<? extends BookPage>> pageClasses = new HashMap<String, Class<? extends BookPage>>();

	@Override
	public void initSounds() {
		// init all sounds
	}

	@Override
	public void initRenderers() {

	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == manualGuiID) {
			ItemStack stack = player.getCurrentEquippedItem();
			return new GuiManual(stack, ClientProxy.vanillaManual);
		}
		return null;
	}

	public static Class<? extends BookPage> getPageClass(String type) {
		return pageClasses.get(type);
	}

	public void readManuals() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		vanillaManual = readManual("/assets/tmm/manuals/vanillamanual.xml", dbFactory);
	}

	Document readManual(String location, DocumentBuilderFactory dbFactory) {
		try {
			InputStream stream = TooManyMods.class.getResourceAsStream(location);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
