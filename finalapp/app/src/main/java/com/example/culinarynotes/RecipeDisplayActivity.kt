package com.example.culinarynotes

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RecipeDisplayActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewPager = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout)
        val recipeId = intent.getIntExtra("RECIPE_ID", -1)

        val ingredients: String
        val description: String

        when (recipeId) {
            R.id.pancakeBtn -> {
                ingredients = "1 ½ cups (195g) all-purpose flour, spooned and leveled\n" +
                        "\n" +
                        "2 tablespoons sugar\n" +
                        "\n" +
                        "1 tablespoon baking powder\n" +
                        "\n" +
                        "1/2 teaspoon of fine sea or table salt, reduce to 1/4 teaspoon if sensitive to salt\n" +
                        "\n" +
                        "1 ¼ cups (295ml) milk, dairy or non-dairy\n" +
                        "\n" +
                        "1 large egg\n" +
                        "\n" +
                        "5 tablespoons (70g) unsalted butter, plus more for skillet\n" +
                        "\n" +
                        "2 teaspoons vanilla extract"
                description = "Melt the butter and set it aside. In a medium bowl, whisk together the flour, sugar, baking powder, and salt.\n" +
                        "\n" +
                        "In a separate bowl, whisk together milk, egg, melted butter, and vanilla extract. (Don’t worry if the butter solidifies slightly).\n" +
                        "\n" +
                        "Create a well in the center of your dry ingredients. Pour in the milk mixture and stir gently with a fork until the flour is just incorporated. A few small lumps are okay. As the batter sits, it should start to bubble.\n" +
                        "\n" +
                        "Place a large skillet or griddle over medium heat. Sprinkle in a few drops of water to test if it’s ready. You want them to dance around a bit and evaporate.\n" +
                        "\n" +
                        "Brush the skillet with melted butter (this creates crispy edges, but you can skip it if using a quality nonstick pan).\n" +
                        "\n" +
                        "Scoop the batter onto the skillet using a 1/4 cup measure or large cookie scoop, and spread each pancake into a 4-inch circle.\n" +
                        "\n" +
                        "After 1 to 2 minutes, the edges will look dry, and bubbles will form and pop on the surface. Flip the pancakes and cook for another 1 to 2 minutes until lightly browned and cooked in the middle.\n" +
                        "\n" +
                        "Serve immediately with warm syrup, butter, and berries."
            }

            R.id.pancakeBtn2 -> {
                ingredients = "1 ½ cups (195g) all-purpose flour, spooned and leveled\n" +
                        "\n" +
                        "2 tablespoons sugar\n" +
                        "\n" +
                        "1 tablespoon baking powder\n" +
                        "\n" +
                        "1/2 teaspoon of fine sea or table salt, reduce to 1/4 teaspoon if sensitive to salt\n" +
                        "\n" +
                        "1 ¼ cups (295ml) milk, dairy or non-dairy\n" +
                        "\n" +
                        "1 large egg\n" +
                        "\n" +
                        "5 tablespoons (70g) unsalted butter, plus more for skillet\n" +
                        "\n" +
                        "2 teaspoons vanilla extract"
                description = "Melt the butter and set it aside. In a medium bowl, whisk together the flour, sugar, baking powder, and salt.\n" +
                        "\n" +
                        "In a separate bowl, whisk together milk, egg, melted butter, and vanilla extract. (Don’t worry if the butter solidifies slightly).\n" +
                        "\n" +
                        "Create a well in the center of your dry ingredients. Pour in the milk mixture and stir gently with a fork until the flour is just incorporated. A few small lumps are okay. As the batter sits, it should start to bubble.\n" +
                        "\n" +
                        "Place a large skillet or griddle over medium heat. Sprinkle in a few drops of water to test if it’s ready. You want them to dance around a bit and evaporate.\n" +
                        "\n" +
                        "Brush the skillet with melted butter (this creates crispy edges, but you can skip it if using a quality nonstick pan).\n" +
                        "\n" +
                        "Scoop the batter onto the skillet using a 1/4 cup measure or large cookie scoop, and spread each pancake into a 4-inch circle.\n" +
                        "\n" +
                        "After 1 to 2 minutes, the edges will look dry, and bubbles will form and pop on the surface. Flip the pancakes and cook for another 1 to 2 minutes until lightly browned and cooked in the middle.\n" +
                        "\n" +
                        "Serve immediately with warm syrup, butter, and berries."
            }

            R.id.avocadoBtn -> {
                ingredients = "1 slice of bread\n" +
                        "\n" +
                        "½ ripe avocado\n" +
                        "\n" +
                        "Pinch of salt"
                description = "Toast your slice of bread until golden and firm.\n" +
                        "\n" +
                        "Remove the pit from your avocado. Use a big spoon to scoop out the flesh. Put it in a bowl and mash it up with a fork until it’s as smooth as you like it.\n" +
                        "\n" +
                        "Mix in a pinch of salt (about ⅛ teaspoon) and add more to taste, if desired.\n" +
                        "\n" +
                        "Spread avocado on top of your toast. Enjoy as-is or top with any extras."
            }
            R.id.avocadoBtn2 -> {
                ingredients = "1 slice of bread\n" +
                        "\n" +
                        "½ ripe avocado\n" +
                        "\n" +
                        "Pinch of salt"
                description = "Toast your slice of bread until golden and firm.\n" +
                        "\n" +
                        "Remove the pit from your avocado. Use a big spoon to scoop out the flesh. Put it in a bowl and mash it up with a fork until it’s as smooth as you like it. Mix in a pinch of salt (about ⅛ teaspoon) and add more to taste, if desired.\n" +
                        "\n" +
                        "Spread avocado on top of your toast. Enjoy as-is or top with any extras."
            }

            R.id.muffinBtn -> {
                ingredients = "Cooking spray\n" +
                        "\n" +
                        "1 green bell pepper, chopped\n" +
                        "\n" +
                        "1 red bell pepper, chopped\n" +
                        "\n" +
                        "1 bunch green onions, chopped\n" +
                        "\n" +
                        "8 large eggs\n" +
                        "\n" +
                        "2 ¾ ounces fully-cooked bacon pieces (such as Oscar Mayer®)\n" +
                        "\n" +
                        "¼ cup whole milk\n" +
                        "\n" +
                        "1 pinch garlic powder, or to taste\n" +
                        "\n" +
                        "1 pinch onion powder, or to taste\n" +
                        "\n" +
                        "salt and ground black pepper to taste\n" +
                        "\n" +
                        "½ (8 ounce) package shredded mild Cheddar cheese"
                description = "Gather all ingredients. Preheat the oven to 350 degrees F (175 degrees C). Grease a 12-cup muffin tin with cooking spray.\n" +
                        "\n" +
                        "Place bell peppers and green onions into a large bowl.\n" +
                        "\n" +
                        "Add eggs, bacon, milk, garlic powder, onion powder, salt, and pepper.\n" +
                        "\n" +
                        "Sprinkle Cheddar cheese into the bowl and whisk until incorporated.\n" +
                        "\n" +
                        "Pour mixture equally into the prepared muffin cups.\n" +
                        "\n" +
                        "Bake in the preheated oven until a toothpick inserted into the center of a muffin comes out clean, about 30 minutes. Let cool slightly before serving."
            }
            R.id.muffinBtn2 -> {
                ingredients = "Cooking spray\n" +
                        "\n" +
                        "1 green bell pepper, chopped\n" +
                        "\n" +
                        "1 red bell pepper, chopped\n" +
                        "\n" +
                        "1 bunch green onions, chopped\n" +
                        "\n" +
                        "8 large eggs\n" +
                        "\n" +
                        "2 ¾ ounces fully-cooked bacon pieces (such as Oscar Mayer®)\n" +
                        "\n" +
                        "¼ cup whole milk\n" +
                        "\n" +
                        "1 pinch garlic powder, or to taste\n" +
                        "\n" +
                        "1 pinch onion powder, or to taste\n" +
                        "\n" +
                        "salt and ground black pepper to taste\n" +
                        "\n" +
                        "½ (8 ounce) package shredded mild Cheddar cheese"
                description = "Gather all ingredients. Preheat the oven to 350 degrees F (175 degrees C). Grease a 12-cup muffin tin with cooking spray.\n" +
                        "\n" +
                        "Place bell peppers and green onions into a large bowl.\n" +
                        "\n" +
                        "Add eggs, bacon, milk, garlic powder, onion powder, salt, and pepper.\n" +
                        "\n" +
                        "Sprinkle Cheddar cheese into the bowl and whisk until incorporated.\n" +
                        "\n" +
                        "Pour mixture equally into the prepared muffin cups.\n" +
                        "\n" +
                        "Bake in the preheated oven until a toothpick inserted into the center of a muffin comes out clean, about 30 minutes. Let cool slightly before serving."
            }

            R.id.wrapBtn -> {
                ingredients = "2 chicken breasts boneless and skinless, sliced into cutlets, 650g in total\n" +
                        "\n" +
                        "1 teaspoon smoked paprika\n" +
                        "\n" +
                        "¼ teaspoon chili powder\n" +
                        "\n" +
                        "½ teaspoon garlic granules\n" +
                        "\n" +
                        "½ teaspoon salt\n" +
                        "\n" +
                        "⅛ teaspoon ground black pepper\n" +
                        "\n" +
                        "1 tablespoon olive oil if frying\n" +
                        "\n" +
                        "4 flour tortilla wraps\n" +
                        "\n" +
                        "4 large iceberg lettuce leaves\n" +
                        "\n" +
                        "1 cup cheddar or mozzarella cheese shredded\n" +
                        "\n" +
                        "½ cup ranch dressing"
                description = "Season the chicken cutlets with smoked paprika, chili powder, garlic granules, salt, and pepper.\n" +
                        "\n" +
                        "Heat oil in a pan, or a grill pan, or preheat your outdoor grill.\n" +
                        "\n" +
                        "Place the seasoned chicken cutlets on the grill or pan, and cook on both sides until the chicken is cooked through. The internal temperature of the center of the chicken must be at least 165°F (75°C).\n" +
                        "\n" +
                        "Remove the chicken from the grill, and allow it to rest on a plate for 5 minutes.\n" +
                        "\n" +
                        "Cut the chicken up, and assemble the wrap.\n" +
                        "\n" +
                        "To assemble, on a tortilla bread, layer lettuce leaves, followed by chicken, shredded cheese, and a drizzle of ranch dressing. Seal the tortilla and place the wrap on the grill (or lightly oiled grill pan). Cook for a minute or 2 on both sides, then remove and slice the wraps in halves and serve."
            }
            R.id.chickwrapBtn -> {
                ingredients = "2 chicken breasts boneless and skinless, sliced into cutlets, 650g in total\n" +
                        "\n" +
                        "1 teaspoon smoked paprika\n" +
                        "\n" +
                        "¼ teaspoon chili powder\n" +
                        "\n" +
                        "½ teaspoon garlic granules\n" +
                        "\n" +
                        "½ teaspoon salt\n" +
                        "\n" +
                        "⅛ teaspoon ground black pepper\n" +
                        "\n" +
                        "1 tablespoon olive oil if frying\n" +
                        "\n" +
                        "4 flour tortilla wraps\n" +
                        "\n" +
                        "4 large iceberg lettuce leaves\n" +
                        "\n" +
                        "1 cup cheddar or mozzarella cheese shredded\n" +
                        "\n" +
                        "½ cup ranch dressing"
                description = "Season the chicken cutlets with smoked paprika, chili powder, garlic granules, salt, and pepper.\n" +
                        "\n" +
                        "Heat oil in a pan, or a grill pan, or preheat your outdoor grill.\n" +
                        "\n" +
                        "Place the seasoned chicken cutlets on the grill or pan, and cook on both sides until the chicken is cooked through. The internal temperature of the center of the chicken must be at least 165°F (75°C).\n" +
                        "\n" +
                        "Remove the chicken from the grill, and allow it to rest on a plate for 5 minutes.\n" +
                        "\n" +
                        "Cut the chicken up, and assemble the wrap.\n" +
                        "\n" +
                        "To assemble, on a tortilla bread, layer lettuce leaves, followed by chicken, shredded cheese, and a drizzle of ranch dressing. Seal the tortilla and place the wrap on the grill (or lightly oiled grill pan). Cook for a minute or 2 on both sides, then remove and slice the wraps in halves and serve."
            }

            R.id.caesarBtn -> {
                ingredients = "For the Croutons:\n" +
                        "\n" +
                        "1/2 French Baguette, cut in half and thinly sliced (1/4\" thick)\n" +
                        "\n" +
                        "3 Tbsp extra virgin olive oil\n" +
                        "\n" +
                        "1 tsp minced garlic, 2 small cloves\n" +
                        "\n" +
                        "2 Tbsp grated parmesan cheese\n" +
                        "\n" +"\n" +
                        "Caesar Salad dressing:\n" +
                        "\n" +
                        "2 small garlic cloves, minced (1 tsp)\n" +
                        "\n" +
                        "2 tsp dijon mustard\n" +
                        "\n" +
                        "1 tsp Worcestershire sauce\n" +
                        "\n" +
                        "2 tsp fresh lemon juice\n" +
                        "\n" +
                        "1 1/2 tsp red wine vinegar\n" +
                        "\n" +
                        "1/3 cup extra virgin olive oil\n" +
                        "\n" +
                        "1/2 tsp sea salt, or to taste\n" +
                        "\n" +
                        "1/8 tsp black pepper, plus more to serve\n" +
                        "\n" +"\n" +
                        "For the Caesar Salad:\n" +
                        "\n" +
                        "1 large romaine lettuce, (or 2 small heads romaine)\n" +
                        "\n" +
                        "1/3 cup parmesan cheese, shredded or shaved"
                description = "How to Make Croutons:\n" +
                        "\n" +
                        "Preheat oven to 350˚F. Cut the baguette in half lengthwise through the top of the baguette then slice diagonally into 1/4\" thick pieces. Place the breads onto a baking sheet.\n" +
                        "\n" +
                        "In a small bowl, combine 3 Tbsp extra virgin olive oil and 1 tsp of finely minced garlic. Drizzle the garlic oil over the croutons and sprinkle the top with 2 Tbsp grated parmesan cheese.\n" +
                        "\n" +
                        "Toss until evenly coated. Spread in a single layer over the baking sheet and bake at 350˚F until light golden and crisp (10-12 minutes), or to desired crispness.\n" +
                        "\n" +"\n" +
                        "How to Make Caesar Salad Dressing:\n" +
                        "\n" +
                        "In a small bowl, whisk together garlic, dijon, Worcestershire, lemon juice and red wine vinegar.\n" +
                        "\n" +
                        "Slowly drizzle in extra virgin olive oil while whisking constantly.\n" +
                        "\n" +
                        "Whisk in 1/2 tsp salt and 1/8 tsp black pepper, or season to taste.\n" +
                        "\n" +"\n" +
                        "How to Make Caesar Salad:\n" +
                        "\n" +
                        "Rinse, dry and chop or tear the romaine into bite-sized pieces. Place in a large serving bowl and sprinkle generously with shredded parmesan cheese and cooled croutons. Drizzle with caesar dressing and toss gently until lettuce is evenly coated."
            }

            R.id.saladBtn -> {
                ingredients = "For the Croutons:\n" +
                        "\n" +
                        "1/2 French Baguette, cut in half and thinly sliced (1/4\" thick)\n" +
                        "\n" +
                        "3 Tbsp extra virgin olive oil\n" +
                        "\n" +
                        "1 tsp minced garlic, 2 small cloves\n" +
                        "\n" +
                        "2 Tbsp grated parmesan cheese\n" +
                        "\n" +"\n" +
                        "Caesar Salad dressing:\n" +
                        "\n" +
                        "2 small garlic cloves, minced (1 tsp)\n" +
                        "\n" +
                        "2 tsp dijon mustard\n" +
                        "\n" +
                        "1 tsp Worcestershire sauce\n" +
                        "\n" +
                        "2 tsp fresh lemon juice\n" +
                        "\n" +
                        "1 1/2 tsp red wine vinegar\n" +
                        "\n" +
                        "1/3 cup extra virgin olive oil\n" +
                        "\n" +
                        "1/2 tsp sea salt, or to taste\n" +
                        "\n" +
                        "1/8 tsp black pepper, plus more to serve\n" +
                        "\n" +"\n" +
                        "For the Caesar Salad:\n" +
                        "\n" +
                        "1 large romaine lettuce, (or 2 small heads romaine)\n" +
                        "\n" +
                        "1/3 cup parmesan cheese, shredded or shaved"
                description = "How to Make Croutons:\n" +
                        "\n" +
                        "Preheat oven to 350˚F. Cut the baguette in half lengthwise through the top of the baguette then slice diagonally into 1/4\" thick pieces. Place the breads onto a baking sheet.\n" +
                        "\n" +
                        "In a small bowl, combine 3 Tbsp extra virgin olive oil and 1 tsp of finely minced garlic. Drizzle the garlic oil over the croutons and sprinkle the top with 2 Tbsp grated parmesan cheese.\n" +
                        "\n" +
                        "Toss until evenly coated. Spread in a single layer over the baking sheet and bake at 350˚F until light golden and crisp (10-12 minutes), or to desired crispness.\n" +
                        "\n" + "\n" +
                        "How to Make Caesar Salad Dressing:\n" +
                        "\n" +
                        "In a small bowl, whisk together garlic, dijon, Worcestershire, lemon juice and red wine vinegar.\n" +
                        "\n" +
                        "Slowly drizzle in extra virgin olive oil while whisking constantly.\n" +
                        "\n" +
                        "Whisk in 1/2 tsp salt and 1/8 tsp black pepper, or season to taste.\n" +
                        "\n" +"\n" +
                        "How to Make Caesar Salad:\n" +
                        "\n" +
                        "Rinse, dry and chop or tear the romaine into bite-sized pieces. Place in a large serving bowl and sprinkle generously with shredded parmesan cheese and cooled croutons. Drizzle with caesar dressing and toss gently until lettuce is evenly coated."
            }

            R.id.spaghettBtn -> {
                ingredients = "1 pound (450g) dried spaghetti\n" +
                        "\n" +
                        "1 pound (450g) lean ground meat like ground beef or ground turkey\n" +
                        "\n" +
                        "3 tablespoons olive oil\n" +
                        "\n" +
                        "1 cup (130g) chopped onion\n" +
                        "\n" +
                        "3 garlic cloves, minced, 1 tablespoon\n" +
                        "\n" +
                        "2 tablespoons tomato paste\n" +
                        "\n" +
                        "1/2 teaspoon dried oregano\n" +
                        "\n" +
                        "\n" +
                        "Pinch crushed red pepper flakes\n" +
                        "\n" +
                        "1 cup water, broth, or dry red wine\n" +
                        "\n" +
                        "1 (28oz) can crushed tomatoes\n" +
                        "\n" +
                        "Salt and fresh ground black pepper\n" +
                        "\n" +
                        "Handful of fresh basil leaves, plus more for serving\n" +
                        "\n" +
                        "Parmesan cheese, for serving"
                description = "Heat the oil in a large pot over medium-high heat (we use a Dutch oven).\n" +
                        "\n" +
                        "Add the meat and cook until browned, about 8 minutes. Use a wooden spoon to break the meat into smaller crumbles as the meat cooks.\n" +
                        "\n" +
                        "Add the onions and cook, stirring every once in a while, until softened, about 5 minutes.\n" +
                        "\n" +
                        "Stir in the garlic, tomato paste, oregano, and red pepper flakes and cook, stirring continuously for about 1 minute.\n" +
                        "\n" +
                        "Pour in the water and use a wooden spoon to scrape up any bits of meat or onion stuck to the bottom of the pot.\n" +
                        "\n" +
                        "Stir in the tomatoes, 3/4 teaspoon of salt, and a generous pinch of black pepper.\n" +
                        "\n" +
                        "Bring the sauce to a low simmer. Cook uncovered for 25 minutes. As it cooks, stir and taste the sauce a few times so you can adjust the seasoning accordingly (see notes for seasoning suggestions).\n" +
                        "\n" +
                        "About 15 minutes before the spaghetti sauce finishes cooking, bring a large pot of salted water to a boil. Then, cook the pasta according to the package directions, but check for doneness a minute or two before the suggested cooking time.\n" +
                        "\n" +
                        "Remove the sauce from the heat and stir in the basil. Toss in the cooked pasta and leave for a minute so that it absorbs some of the sauce. Toss again, and then serve with grated parmesan cheese on top."
            }
            R.id.spaghettiBtn -> {
                ingredients = "1 pound (450g) dried spaghetti\n" +
                        "\n" +
                        "1 pound (450g) lean ground meat like ground beef or ground turkey\n" +
                        "\n" +
                        "3 tablespoons olive oil\n" +
                        "\n" +
                        "1 cup (130g) chopped onion\n" +
                        "\n" +
                        "3 garlic cloves, minced, 1 tablespoon\n" +
                        "\n" +
                        "2 tablespoons tomato paste\n" +
                        "\n" +
                        "1/2 teaspoon dried oregano\n" +
                        "\n" +
                        "Pinch crushed red pepper flakes\n" +
                        "\n" +
                        "1 cup water, broth, or dry red wine\n" +
                        "\n" +
                        "1 (28oz) can crushed tomatoes\n" +
                        "\n" +
                        "Salt and fresh ground black pepper\n" +
                        "\n" +
                        "Handful of fresh basil leaves, plus more for serving\n" +
                        "\n" +
                        "Parmesan cheese, for serving"
                description = "Heat the oil in a large pot over medium-high heat (we use a Dutch oven).\n" +
                        "\n" +
                        "Add the meat and cook until browned, about 8 minutes. Use a wooden spoon to break the meat into smaller crumbles as the meat cooks.\n" +
                        "\n" +
                        "Add the onions and cook, stirring every once in a while, until softened, about 5 minutes.\n" +
                        "\n" +
                        "Stir in the garlic, tomato paste, oregano, and red pepper flakes and cook, stirring continuously for about 1 minute.\n" +
                        "\n" +
                        "Pour in the water and use a wooden spoon to scrape up any bits of meat or onion stuck to the bottom of the pot.\n" +
                        "\n" +
                        "Stir in the tomatoes, 3/4 teaspoon of salt, and a generous pinch of black pepper.\n" +
                        "\n" +
                        "Bring the sauce to a low simmer. Cook uncovered for 25 minutes. As it cooks, stir and taste the sauce a few times so you can adjust the seasoning accordingly (see notes for seasoning suggestions).\n" +
                        "\n" +
                        "About 15 minutes before the spaghetti sauce finishes cooking, bring a large pot of salted water to a boil. Then, cook the pasta according to the package directions, but check for doneness a minute or two before the suggested cooking time.\n" +
                        "\n" +
                        "Remove the sauce from the heat and stir in the basil. Toss in the cooked pasta and leave for a minute so that it absorbs some of the sauce. Toss again, and then serve with grated parmesan cheese on top."
            }
            R.id.soupBtn -> {
                ingredients = "1 (3 pound) whole chicken\n" +
                        "\n" +
                        "4 carrots, halved\n" +
                        "\n" +
                        "4 stalks celery, halved\n" +
                        "\n" +
                        "1 large onion, halved\n" +
                        "\n" +
                        "water to cover\n" +
                        "\n" +
                        "salt and pepper to taste\n" +
                        "\n" +
                        "1 teaspoon chicken bouillon granules (Optional)"
                description = "Gather all ingredients.\n" +
                        "\n" +
                        "Place chicken, carrots, celery, and onion in a large soup pot; add enough cold water to cover. Bring to a boil over medium heat; reduce heat to low and simmer, uncovered, until meat falls off of the bone, about 90 minutes. Skim off foam every so often, as needed.\n" +
                        "\n" +
                        "Remove chicken from the pot and let sit until cool enough to handle; chop meat into pieces, and discard skin and bones.\n" +
                        "\n" +
                        "Strain out vegetables, reserving the stock; rinse the soup pot and return the stock to the pot. Chop vegetables into smaller pieces; return chopped chicken and vegetables to the pot.\n" +
                        "\n" +
                        "Warm soup until heated through; season with salt, pepper, and chicken bouillon to taste.\n" +
                        "\n" +
                        "Serve and enjoy!\n"

            }
            R.id.chicksoupBtn -> {
                ingredients = "1 (3 pound) whole chicken\n" +
                        "\n" +
                        "4 carrots, halved\n" +
                        "\n" +
                        "4 stalks celery, halved\n" +
                        "\n" +
                        "1 large onion, halved\n" +
                        "\n" +
                        "water to cover\n" +
                        "\n" +
                        "salt and pepper to taste\n" +
                        "\n" +
                        "1 teaspoon chicken bouillon granules (Optional)"
                description = "Gather all ingredients.\n" +
                        "\n" +
                        "Place chicken, carrots, celery, and onion in a large soup pot; add enough cold water to cover. Bring to a boil over medium heat; reduce heat to low and simmer, uncovered, until meat falls off of the bone, about 90 minutes. Skim off foam every so often, as needed.\n" +
                        "\n" +
                        "Remove chicken from the pot and let sit until cool enough to handle; chop meat into pieces, and discard skin and bones.\n" +
                        "\n" +
                        "Strain out vegetables, reserving the stock; rinse the soup pot and return the stock to the pot. Chop vegetables into smaller pieces; return chopped chicken and vegetables to the pot.\n" +
                        "\n" +
                        "Warm soup until heated through; season with salt, pepper, and chicken bouillon to taste.\n" +
                        "\n" +
                        "Serve and enjoy!\n"

            }

            else -> {
                ingredients = "Unknown"
                description = "No recipe selected"
            }
        }


        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(IngredientsFragment.newInstance(ingredients), "INGREDIENTS")
        adapter.addFragment(DirectionsFragment.newInstance(description), "DIRECTIONS")

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = adapter.getPageTitle(position)
            tabLayout.setTabTextColors(Color.parseColor("#70553d"), Color.parseColor("#70553d"))
            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#70553d"))}.attach()
    }
}

class ViewPagerAdapter(fragmentActivity: AppCompatActivity) : FragmentStateAdapter(fragmentActivity){
    private val fragments = ArrayList<Fragment>()
    private val fragmentTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String){
        fragments.add(fragment)
        fragmentTitles.add(title)
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
    fun getPageTitle(position:Int): String = fragmentTitles[position]
}
