package matthbo.mods.tmm.client.pages;

import org.w3c.dom.Element;

public class BlankPage extends BookPage {

	@Override
	public void readPageFromXML(Element element) {

	}

	@Override
	public void renderContentLayer(int localwidth, int localheight) {
		manual.fonts.drawSplitString("This page is fucked up!", localwidth, localheight, 178, 0);
	}

}
