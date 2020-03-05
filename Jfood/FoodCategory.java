
public enum FoodCategory
{
     Beverages("Beverages"),Coffee("Coffee"),Western("Western"),Snacks("Snacks"),Rice("Rice"),Noodles("Noodles"),Bakery("Bakery"),Japanese("Japanese");
     
     private String foodCategory;
     
     FoodCategory(String foodCategory)
     {
         this.foodCategory = foodCategory;
     }

     public String toString()
     {
         return foodCategory;
     }
}