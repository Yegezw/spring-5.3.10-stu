package resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 * <a href="https://www.cnblogs.com/lidong422339/p/17553364.html">dom4j</a>
 * <a href="https://github.com/xuchengsheng/spring-reading/blob/master/spring-resources/spring-resource-documentLoader/README.md">DocumentLoader</a>
 */
public class DocumentLoaderTest
{

	@Test
	public void testDocumentLoader() throws Exception
	{
		ClassPathResource resource = new ClassPathResource("sample.xml");

		DocumentLoader loader = new DefaultDocumentLoader();
		Document document = loader.loadDocument(
				new InputSource(resource.getInputStream()),
				null, null,
				0, true
		);

		Element rootElement = document.getDocumentElement();
		printElementInfo(rootElement, "");
	}

	/**
	 * 打印元素信息
	 *
	 * @param element 元素
	 * @param indent  缩进
	 */
	private void printElementInfo(Element element, String indent)
	{
		// 打印元素的名称
		System.out.println(indent + "Element: " + element.getNodeName());

		// 打印元素的属性
		NamedNodeMap attributes = element.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++)
		{
			Node   item  = attributes.item(i);
			String name  = item.getNodeName();
			String value = item.getNodeValue();
			System.out.printf("%sAttribute: %s = %s\n", indent, name, value);
		}

		// 打印元素的子节点(可能是元素或文本)
		NodeList childNodes = element.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++)
		{
			Node  node = childNodes.item(i);
			short type = node.getNodeType();

			// 子节点是元素: 递归打印它
			if (type == Node.ELEMENT_NODE)
			{
				printElementInfo((Element) node, indent + "  ");
			}
			// 子节点是文本: 打印文本内容
			else if (type == Node.TEXT_NODE)
			{
				String text = node.getNodeValue().trim();
				if (!text.isEmpty())
				{
					System.out.println(indent + "  Text: " + node.getNodeValue().trim());
				}
			}
		}
	}
}
