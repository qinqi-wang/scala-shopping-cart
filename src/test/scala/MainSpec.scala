import org.scalatest.wordspec._

class MainSpec extends AnyWordSpec {
  "This banana" should {
    "cost .5 dollars" in {
      // arrange
      var banana = new Item("Banana", .5)
      var cart = ShoppingCart.AddOneItemOnly(banana)
      // act
      var cost = ShoppingCart.CalculateCostSimple(cart);
      // assert
      assert(cost == .5)
    }
  }

  "Two bananas" should {
    "cost 1 dollar" in {
      // arrange
      var banana = new Item("Banana", .5)
      var emptyCart = new Array[Item](0)
      var cartWithOneBanana = ShoppingCart.AddItemToCart(banana, emptyCart)
      var cartWithTwoBananas = ShoppingCart.AddItemToCart(banana, cartWithOneBanana)
      // act
      var cost = ShoppingCart.CalculateCostSimple(cartWithTwoBananas)
      // assert
      assert(cost == 1.0)
    }
  }

  "Three bananas" should {
    "cost 1 dollar because of a sale" in {
      // arrange
      var banana = new Item("Banana", .5)
      var emptyCart = new Array[Item](0)
      var cartWithOneBanana = ShoppingCart.AddItemToCart(banana, emptyCart)
      var cartWithTwoBananas = ShoppingCart.AddItemToCart(banana, cartWithOneBanana)
      var cartWithThreeBananas = ShoppingCart.AddItemToCart(banana, cartWithTwoBananas)
      // act
      var cost = ShoppingCart.CalculateCost(cartWithThreeBananas)
      // assert
      assert(cost == 1.0)
    }
  }
}