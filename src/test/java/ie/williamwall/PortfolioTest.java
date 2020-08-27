package ie.williamwall;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import ie.williamwall.Portfolio;
import ie.williamwall.Stock;
import ie.williamwall.StockMarket;

public class PortfolioTest extends TestCase {

	private Portfolio portfolio;
	private StockMarket marketMock;

	@Before
	public void setUp() {
		portfolio = new Portfolio();
		portfolio.setName("William's portfolio.");
		marketMock = EasyMock.createMock(StockMarket.class);
		portfolio.setStockMarket(marketMock);
	}

	@Test
	public void testGetTotalValue() {

		
		EasyMock.expect(marketMock.getPrice("EBAY")).andReturn(42.00);
		EasyMock.replay(marketMock);

		
		Stock ebayStock = new Stock("EBAY", 3);
		portfolio.addStock(ebayStock);
		assertEquals(126.00, portfolio.getTotalValue());
	}

}
