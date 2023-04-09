# Pokemon

- HomeScreen shows a pokemon list with name and image, in portrait orientation the list scrolls to bottom, and in landscape it scrolls to right.
- DetailsScreen shows the pokemon data: image, name, type, experience, weight, height ans stats. In portrait orientation the information is below the image, and in landscape it is aside.
- The app uses retrofit and gson to get informations from https://pokeapi.co/
- The app architecture choose was MVVM, the viewmodel store the screen information and communicates with repository, which communicates with server.
- The screens were designed with Jetpack Compose and the first screen has Vertical and Horizontal Pagers.
- For communication with viewmodel, the repository emits values with Flow and is injected by Dagger Hilt.
- The app has unit and instrumented tests, which test almost the whole app
- In details screen there is a button which makes the pokemon favorite and sends a POST to the link: https://webhook.site/361949cb-84c0-4bc0-b35c-cf7c066dc6fb
- The two screens are configured not to break on different screen dimensions
- When the user scrolls to the end of the screen, the app shows a circular progress bar and gets more Pokemons from the server
