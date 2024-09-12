package com.example.domain.repo.meals

import com.example.domain.entity.meals.MealsResponse

interface MealsRepo {

    suspend fun getMealsCategoriesFromRemote() : MealsResponse


}