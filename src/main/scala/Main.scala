class Item(var name: String, var price: Double) {}

object ShoppingCart {
  def AddOneItemOnly (item: Item): Array[Item] = {
    return Array(item)
  }

  def AddItemToCart (item: Item, cart: Array[Item]): Array[Item] = {
    val newCart = cart :+ item
    return newCart
  }

  def CalculateCostSimple (cart: Array[Item]): Double = {
    var sum: Double = 0
    for ( i <- 0 until cart.length ) {
      sum = sum + cart(i).price
    }
    return sum
  }

  def CalculateCost (cart: Array[Item]): Double = {
    var sum: Double = 0
    var discount = bananasAreForSale(cart)
    for ( i <- 0 until cart.length ) {
      sum = sum + cart(i).price
    }

    if (discount != 0 ) {
      sum = sum - discount
    }

    return sum
  }

  def bananasAreForSale(cart: Array[Item]): Double = {
    var bananaCount = 0
    for ( i <- 0 until cart.length) {
      if(cart(i).name == "Banana") {
        bananaCount = bananaCount + 1
      }
    }
    var numberOfDiscounts = bananaCount / 3
    var discount = numberOfDiscounts * .5
    return discount
  }

}
