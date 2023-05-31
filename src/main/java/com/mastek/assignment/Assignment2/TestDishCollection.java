package com.mastek.assignment.Assignment2;





import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mastek.assignment.Assignment2.Dish.Type;



// All method names describe the requirement. You need to use serial and parallel streams to solve.

public class TestDishCollection {

	public static void getDishesSortedForCaloriesLessThan400(List<Dish> menu) {
	
		
		List<Dish> caloriesList= menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparingInt(Dish::getCalories))
                .collect(Collectors.toList());
		 System.out.println(caloriesList);
	
	}

	public static void getDishWithMaximumCalories(List<Dish> menu) {
		
		Optional<Dish> maxcaloriesList= menu.stream().max(Comparator.comparingInt(Dish::getCalories));
		 System.out.println(maxcaloriesList);
		
	}

	public static void Skip2AndLimit3Dishes(List<Dish> menu) {
		List<Dish> dishes = menu.stream()
		        .skip(2)
		        .limit(3)
		        .collect(Collectors.toList());
		 System.out.println(dishes);
	}

	public static void getTwoMeatDishes(List<Dish> menu) {
		List<Dish> meatDishesList = menu.stream()
		        .filter(dish -> dish.getType().equals("Meat"))
		        .limit(2)
		        .collect(Collectors.toList());
		 System.out.println("meatDishList:::"+meatDishesList);
		}

	public static void getVegetrianDishes(List<Dish> menu) {
		
		List<Dish> vegList=menu.stream().filter(dish->dish.isVegetarian()).collect(Collectors.toList());
		System.out.println("vegList::"+vegList);
		
	}

	public static void printAllDishTypes() {
		
		Stream.of(Type.values()).forEach(System.out::println);
		
		
	}

/*
    Provide two solutions for this requirements
*/
	public static void printSumofCalories(List<Dish> menu) {
		
		//1 way
		int sumOfCalories = menu.stream()
		        .mapToInt(Dish::getCalories)
		        .sum();
		System.out.println("Sum::"+sumOfCalories);
		
		//2 way
		int sum = menu.stream()
		        .map(Dish::getCalories)
		        .reduce(0, Integer::sum);
		System.out.println("Sum::"+sum);
	}

	public static void anyDishwithCaloriesLess400(List<Dish> menu) {
		
		//1 way
		Optional<Dish> lessCaloriesDish = menu.stream()
		        .min(Comparator.comparingInt(Dish::getCalories));
		 System.out.println(lessCaloriesDish);
		 
		 //2 way
		 Optional<Dish> dishWithLessCalories = menu.stream()
			        .filter(dish -> dish.getCalories() < 400)
			        .findAny();
		 
		 System.out.println(dishWithLessCalories);
	}
	

	
	public static void printTotalCaloriesofEveryDish(List<Dish> menu) {
		
		menu.forEach(dish -> System.out.println("Dish: " + dish.getName() + ", Total Calories: " + dish.getCalories()));
	
	}

	public static void main(String[] args) {
		List<Dish> menu = Dish.getDishes();
		 System.out.println(menu);
		 getDishesSortedForCaloriesLessThan400(menu);
		 getDishWithMaximumCalories(menu);
		 Skip2AndLimit3Dishes(menu);
		 getTwoMeatDishes(menu);
		 getVegetrianDishes(menu);
		 printAllDishTypes();
		 printSumofCalories(menu);
		 anyDishwithCaloriesLess400(menu);
		 printTotalCaloriesofEveryDish(menu);
		 
		 
		
		
		 
		// getDishesCaloriesLessThan400(menu);
		// getDishWithMaximumCalories(menu);
		 
		
	}

}

