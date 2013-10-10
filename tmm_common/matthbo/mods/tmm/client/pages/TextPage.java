package matthbo.mods.tmm.client.pages;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TextPage extends BookPage {

	String text;
	String  uText;
	
	boolean u = false;
	
	@Override
	public void readPageFromXML(Element element) {
		NodeList nodes = element.getElementsByTagName("text");
        if (nodes != null) text = nodes.item(0).getTextContent();
	}

	@Override
	public void renderContentLayer(int localwidth, int localheight) {
		manual.fonts.drawSplitString(text, localwidth, localheight, 178, 0);
	}

}
