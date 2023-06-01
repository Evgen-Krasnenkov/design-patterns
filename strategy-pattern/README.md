# Strategy design pattern task

You have a typical shop stock of products, and you need to find products by manufacture or maximum price.  
You should implement Strategy design pattern for this search. For it, you have FilteringStrategy interface and empty
classes ManufactureFilteringStrategy and MaxPriceFilteringStrategy in the com.kras.impl package.
Search by ManufactureFilteringStrategy should ignore case,so APPLE equals apple.   
Also create method _List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy)_  in ShopStock class which return
products by your filtering strategy. 