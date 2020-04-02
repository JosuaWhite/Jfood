import java.util.*;

public class DatabaseFood
{

    public ArrayList<Food> FOOD_DATABASE;
    public int lastId = 0;

    public ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    public int getLastId()
    {
        return lastId;
    }

    public Food getFoodById(int id)
    {
        if (FOOD_DATABASE.get(id)!=null) {
            return FOOD_DATABASE.get(id);
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Food> getFoodBySeller(int SellerId)
    {
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == SellerId)
            {
                list.add(food);
            }
        }
        return list;
    }

    public ArrayList<Food> getFoodByCategory(FoodCategory foodCategory)
    {
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory() == foodCategory)
            {
                list.add(food);
            }
        }
        return list;
    }

    public boolean addSeller(Food food)
    {
        FOOD_DATABASE.add(lastId,food);
        lastId++;
        return true;
    }

    public boolean removeSeller(int id)
    {
        FOOD_DATABASE.remove(id);
        lastId--;
        return true;
    }

}
