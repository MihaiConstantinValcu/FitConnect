Business requirements:
1. The user should be able to create a workout session
2. The user should be able to see his workout sessions
3. The user should be able to add exercises to his sessions
4. The user should be able to add ratings of his workouts so far
5. The user should be able to add new exercises
6. The user should be able to categorize his exercises
7. The user should be able to move exercises between categories
8. The user should be able to save his foods of choice
9. The user should be able to update his foods
10. The user should be able to make meals with said foods

Main features:
  1. The user can create a workout session
  2. The user can give ratings to his past workout
  3. The user can add details to the exercises he used in a workout
  4. The user can manage his exercises and their categories
  5. The user can create meals with the foods he added

Entities:
1. Category
2. Exercise
3. WorkoutSession
4. WorkoutExercise
5. Food
6. Meal
7. MealItem

Relations:
1. Category - Exercise (One to Many)
2. Exercise - WorkoutExercise and WorkoutSession - WorkoutExercise (Many To One and Many to One, models Many To Many realtion between Exercise and WorkoutSession)
3. Food - MealItem and Meal - MealItem (One To Many and One to Many, models Many To Many realtion between Food and Meal)
4. WorkoutRating - WorkoutSession (Many To One)





  
